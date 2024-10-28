package br.com.petEssence.controller.raca;

import br.com.petEssence.dao.GenericDAO;
import br.com.petEssence.dao.RacaDAO;
import br.com.petEssence.model.Raca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RacaCadastrar", urlPatterns = {"/RacaCadastrar"})
public class RacaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idRaca = Integer.parseInt(request.getParameter("idraca"));
        String nomeRaca = request.getParameter("nomeraca");
        Raca aRaca = new Raca();
        aRaca.setIdRaca(idRaca);
        aRaca.setNomeRaca(nomeRaca);
        try {
            GenericDAO dao = new RacaDAO();
            dao.cadastrar(aRaca);
            response.sendRedirect("RacaListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar raça! Erro " + ex.getMessage());

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
