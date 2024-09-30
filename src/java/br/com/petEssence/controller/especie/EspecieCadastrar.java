package br.com.petEssence.controller.especie;

import br.com.petEssence.dao.EspecieDAO;
import br.com.petEssence.dao.GenericDAO;
import br.com.petEssence.model.Especie;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EspecieCadastrar", urlPatterns = {"/EspecieCadastrar"})
public class EspecieCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idEspecie = Integer.parseInt(request.getParameter("idespecie")); //o get paramenter pegará o valor do input da view
        String nomeEspecie = request.getParameter("nomeespecie");

        Especie oEspecie = new Especie();
        oEspecie.setIdEspecie(idEspecie);
        oEspecie.setNomeEspecie(nomeEspecie);

        try {
            GenericDAO dao = new EspecieDAO();
            dao.cadastrar(oEspecie);
            response.sendRedirect("EspecieListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar especie! Erro " + ex.getMessage());

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
