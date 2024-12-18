package br.com.petEssence.controller.pet;

import br.com.petEssence.dao.EspecieDAO;
import br.com.petEssence.dao.PetDAO;
import br.com.petEssence.dao.RacaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetCarregar", urlPatterns = {"/PetCarregar"})
public class PetCarregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=iso-8859-1");
        try {
            int idPet = Integer.parseInt(request.getParameter("idPet"));
            
            PetDAO oPetDAO = new PetDAO();
            request.setAttribute("pet", oPetDAO.carregar(idPet));
            
            EspecieDAO oEspecieDAO = new EspecieDAO();
            request.setAttribute("especies", oEspecieDAO.listar());
            
            RacaDAO aRacaDAO = new RacaDAO();
            request.setAttribute("racas", aRacaDAO.listar());
            
            request.getRequestDispatcher("/cadastros/pet/petCadastrar.jsp").forward(request, response);                        
        } catch (Exception ex) {
            System.out.println("Erro ao carregar pet: " + ex.getMessage());
            ex.printStackTrace();
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
