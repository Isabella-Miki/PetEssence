package br.com.petEssence.dao;

import br.com.petEssence.model.Especie;
import br.com.petEssence.model.Pet;
import br.com.petEssence.model.Raca;
import br.com.petEssence.utils.SingleConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements GenericDAO {
    
    private Connection conexao;
    
    public PetDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Pet oPet = (Pet) objeto;
        Boolean retorno = false;
        retorno = oPet.getIdPet() == 0 ? this.inserir(oPet) : this.alterar(oPet);
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Pet oPet = (Pet) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into pet (nome, idespecie, idraca, situacao) values (?, ?, ?, ?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oPet.getNomePet());
            stmt.setInt(2, oPet.getEspecie().getIdEspecie());
            stmt.setInt(3, oPet.getRaca().getIdRaca());
            stmt.setString(4, oPet.getSituacao());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
            System.out.println("Problemas ao cadastrar pet! Erro: " + ex.getMessage());
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
    Pet oPet = (Pet) objeto;
    PreparedStatement stmt = null;
    String sql = "update pet set nome=?, idespecie=?, idraca=?, situacao=? where id=?";
    
    try {
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, oPet.getNomePet());
        stmt.setInt(2, oPet.getEspecie().getIdEspecie());
        stmt.setInt(3, oPet.getRaca().getIdRaca());
        stmt.setString(4, oPet.getSituacao());
        stmt.setInt(5, oPet.getIdPet());
        stmt.execute();
        conexao.commit();
        return true;
    } catch (Exception ex) {
        try {
            System.out.println("Problemas ao alterar o pet! Erro: " + ex.getMessage());
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
        int idPet = numero;
        PreparedStatement stmt = null;
        String sql = "update pet set situacao=? where id=?";
        
        try {
            Pet oPet = (Pet) this.carregar(idPet);
            stmt = conexao.prepareStatement(sql);
            if(oPet.getSituacao().equals("A"))
                stmt.setString(1, "I");
            else stmt.setString(1, "A");
                stmt.setInt(2, idPet);
                stmt.execute();
                conexao.commit();
                return true;
        } catch(Exception ex) {
            System.out.println("Problemas ao excluir pet! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idPet = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pet oPet = null;
        String sql = "select * from pet where id=?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idPet);
            rs = stmt.executeQuery();
            while(rs.next()) {
                oPet = new Pet();
                oPet.setIdPet(rs.getInt("id"));
                oPet.setNomePet(rs.getString("nome"));
                oPet.setSituacao(rs.getString("situacao"));
                
                EspecieDAO oEspecieDAO = new EspecieDAO();
                oPet.setEspecie((Especie) oEspecieDAO.carregar(rs.getInt("idespecie")));
                
                RacaDAO aRacaDAO = new RacaDAO();
                oPet.setRaca((Raca) aRacaDAO.carregar(rs.getInt("idraca")));
            }
            return oPet;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar pet! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from pet order by nome";
        
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            EspecieDAO oEspecieDAO = new EspecieDAO();
            RacaDAO aRacaDAO = new RacaDAO();

            
            while(rs.next()) {
                Pet oPet = new Pet();
                oPet.setIdPet(rs.getInt("id"));
                oPet.setNomePet(rs.getString("nome"));
                oPet.setSituacao(rs.getString("situacao"));
                
                Especie especie = (Especie) oEspecieDAO.carregar(rs.getInt("idespecie"));
                oPet.setEspecie(especie);

                Raca raca = (Raca) aRacaDAO.carregar(rs.getInt("idraca"));
                oPet.setRaca(raca);

                resultado.add(oPet);
               
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar pets! Erro: " + ex.getMessage());
        }  catch (Exception ex) {
            System.out.println("Erro ao carregar dados: " + ex.getMessage());
            ex.printStackTrace();
    }
        return resultado;
    }
}
    

