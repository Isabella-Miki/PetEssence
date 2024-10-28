package br.com.petEssence.dao;

import br.com.petEssence.model.Raca;
import br.com.petEssence.utils.SingleConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class RacaDAO implements GenericDAO {
    
    private Connection conexao;

    public RacaDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Raca aRaca = (Raca) objeto;
        Boolean retorno = false;
        retorno = aRaca.getIdRaca() == 0 ? this.inserir(aRaca) : this.alterar(aRaca);
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Raca aRaca = (Raca) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert into raca(nome) values (?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aRaca.getNomeRaca());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex) {
            try {
                System.out.println("Problemas ao inserir raça! Erro: " + ex.getMessage());
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
        Raca aRaca = (Raca) objeto;
        PreparedStatement stmt = null;
        String sql = "Update raca set nome =? where id =?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aRaca.getNomeRaca());
            stmt.setInt(2, aRaca.getIdRaca());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a raça! " + ex.getMessage());
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
        int idRaca = numero;
        String sql = "Delete from raca where id =?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idRaca);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir raça! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from raca where id =?";
        Raca aRaca = new Raca();
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            rs = stmt.executeQuery();
            while (rs.next()) {
                aRaca = new Raca();
                aRaca.setIdRaca(rs.getInt("id"));
                aRaca.setNomeRaca(rs.getString("nome"));
            }
            return aRaca;
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
        String sql = "Select * from raca order by nome";

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Raca aRaca = new Raca();
                aRaca.setIdRaca(rs.getInt("id"));
                aRaca.setNomeRaca(rs.getString("nome"));
                resultado.add(aRaca);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar raça" + ex.getMessage());
        }
        return resultado;
    }
    
}
