package br.com.petEssence.dao;

import br.com.petEssence.model.Especie;
import br.com.petEssence.utils.SingleConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class EspecieDAO implements GenericDAO {

    private Connection conexao;

    public EspecieDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Especie oEspecie = (Especie) objeto;
        Boolean retorno = false;
        retorno = oEspecie.getIdEspecie() == 0 ? this.inserir(oEspecie) : this.alterar(oEspecie);
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Especie oEspecie = (Especie) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into especie(nome) values (?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEspecie.getNomeEspecie());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex) {
            try {
                System.out.println("Problemas ao inserir especie! Erro: " + ex.getMessage());
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
        Especie oEspecie = (Especie) objeto;
        PreparedStatement stmt = null;
        String sql = "Update especie set nome =? where id =?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEspecie.getNomeEspecie());
            stmt.setInt(2, oEspecie.getIdEspecie());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a especie! " + ex.getMessage());
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
        int idEspecie = numero;
        String sql = "Delete from especie where id =?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idEspecie);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir especie! Erro: " + ex.getMessage());
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
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from especie where id =?";
        Especie oEspecie = new Especie();
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oEspecie = new Especie();
                oEspecie.setIdEspecie(rs.getInt("id"));
                oEspecie.setNomeEspecie(rs.getString("nome"));
            }
            return oEspecie;
        } catch (Exception ex) {
            System.out.println("Erro ao carregar! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from especie order by nome";

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Especie oEspecie = new Especie();
                oEspecie.setIdEspecie(rs.getInt("id"));
                oEspecie.setNomeEspecie(rs.getString("nome"));
                resultado.add(oEspecie);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar especie" + ex.getMessage());
        }
        return resultado;
    }

}
