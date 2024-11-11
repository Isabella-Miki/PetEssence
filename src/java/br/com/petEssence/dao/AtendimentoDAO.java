package br.com.petEssence.dao;

import br.com.petEssence.model.Atendimento;
import br.com.petEssence.model.Pet;
import br.com.petEssence.utils.SingleConnection;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.sql.Time;

public class AtendimentoDAO implements GenericDAO {

    private Connection conexao;

    public AtendimentoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Atendimento oAtendimento = (Atendimento) objeto;
        Boolean retorno = false;
        retorno = oAtendimento.getIdAtendimento() == 0 ? this.inserir(oAtendimento) : this.alterar(oAtendimento);
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Atendimento oAtendimento = (Atendimento) objeto;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO atendimento "
                + "(descricao, dataatendimento,horario,idpet,valor,duracao,nomeveterinario) "
                + "values (?,?,?,?,?,?,?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oAtendimento.getDescricao());
            stmt.setDate(2, new java.sql.Date(oAtendimento.getDataAtendimento().getTime()));
            LocalTime horario = oAtendimento.getHorario();
            stmt.setTime(3, Time.valueOf(horario));
            stmt.setInt(4, oAtendimento.getPet().getIdPet());
            stmt.setDouble(5, oAtendimento.getValor());
            LocalTime duracao = oAtendimento.getDuracao();
            stmt.setTime(6, Time.valueOf(duracao));
            stmt.setString(7, oAtendimento.getNomeVeterinario());

            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar atendimento" + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }

    }

    @Override
    public Boolean alterar(Object objeto) {
        Atendimento oAtendimento = (Atendimento) objeto;
        PreparedStatement stmt = null;
        String sql = "UPDATE atendimento set descricao=? , dataatendimento=?,horario=?,idpet=?,valor=?,duracao=?,nomeveterinario=? where id=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oAtendimento.getDescricao());
            stmt.setDate(2, new java.sql.Date(oAtendimento.getDataAtendimento().getTime()));
            LocalTime horario = oAtendimento.getHorario();
            stmt.setTime(3, Time.valueOf(horario));
            stmt.setInt(4, oAtendimento.getPet().getIdPet());
            stmt.setDouble(5, oAtendimento.getValor());
            LocalTime duracao = oAtendimento.getDuracao();
            stmt.setTime(6, Time.valueOf(duracao));
            stmt.setString(7, oAtendimento.getNomeVeterinario());
            stmt.setInt(8, oAtendimento.getIdAtendimento());

            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar o atendimento! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        PreparedStatement stmt = null;
        int idAtendimento = numero;
        String sql = "Delete from atendimento where id =?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idAtendimento);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Atendimento! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idAtendimento = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Atendimento oAtendimento = null;
        String sql = "select * from atendimento where id=?";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idAtendimento);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oAtendimento = new Atendimento();
                oAtendimento.setDataAtendimento(rs.getDate("dataatendimento"));
                Time duracaoTime = rs.getTime("duracao");
                LocalTime duracao = (duracaoTime != null) ? duracaoTime.toLocalTime() : null;
                oAtendimento.setDuracao(duracao);
                oAtendimento.setDescricao(rs.getString("descricao"));
                Time horarioTime = rs.getTime("horario");
                LocalTime horario = (horarioTime != null) ? horarioTime.toLocalTime() : null;
                oAtendimento.setHorario(horario);
                oAtendimento.setValor(rs.getDouble("valor"));
                oAtendimento.setIdAtendimento(rs.getInt("id"));
                oAtendimento.setNomeVeterinario(rs.getString("nomeveterinario"));

                PetDAO oPetDAO = new PetDAO();
                oAtendimento.setPet((Pet) oPetDAO.carregar(rs.getInt("id")));
            }
            return oAtendimento;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Atendimento! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM atendimento ORDER BY dataatendimento";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Atendimento oAtendimento = new Atendimento();
                oAtendimento.setDataAtendimento(rs.getDate("dataatendimento"));
                Time duracaoTime = rs.getTime("duracao");
                LocalTime duracao = (duracaoTime != null) ? duracaoTime.toLocalTime() : null;
                oAtendimento.setDuracao(duracao);
                oAtendimento.setDescricao(rs.getString("descricao"));
                Time horarioTime = rs.getTime("horario");
                LocalTime horario = (horarioTime != null) ? horarioTime.toLocalTime() : null;
                oAtendimento.setHorario(horario);
                oAtendimento.setValor(rs.getDouble("valor"));
                oAtendimento.setIdAtendimento(rs.getInt("id"));
                oAtendimento.setNomeVeterinario(rs.getString("nomeveterinario"));

                PetDAO oPetDAO = null;
                try {
                    oPetDAO = new PetDAO();
                } catch (Exception ex) {
                    System.out.println("Erro ao buscar o pet: " + ex.getMessage());
                    ex.printStackTrace();
                }
                oAtendimento.setPet((Pet) oPetDAO.carregar(rs.getInt("idpet")));
                System.out.println(oAtendimento.getPet());
                resultado.add(oAtendimento);
            }
        } catch (SQLException ex) {
            System.out.println("problemas ao listar atendimentos! Erro: " + ex.getMessage());
        }
        return resultado;
    }
}
