package br.com.petEssence.filter;

import br.com.petEssence.utils.SingleConnection;
import java.sql.Connection;
import java.sql.SQLException; // Adicione esta linha
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/*"})
public class FilterAutenticacao implements Filter {

    private static Connection conexao;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        if (conexao != null) { // Adicione esta verificação para evitar NullPointerException
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
