package br.com.petEssence.controller.pet;

import br.com.petEssence.dao.GenericDAO;
import br.com.petEssence.dao.PetDAO;
import br.com.petEssence.model.Especie;
import br.com.petEssence.model.Pet;
import br.com.petEssence.model.Raca;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PetCadastrar", urlPatterns = {"/PetCadastrar"})
public class PetCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=iso-8859-1");
        
        int idPet = Integer.parseInt(request.getParameter("idpet"));
        int idEspecie = Integer.parseInt(request.getParameter("idespecie"));
        int idRaca = Integer.parseInt(request.getParameter("idraca"));
       
        String nomePet = request.getParameter("nomepet");
        String situacao = request.getParameter("situacao");
        String mensagem = null;
        
        try {
            Pet oPet = new Pet();
            oPet.setIdPet(idPet);
            oPet.setNomePet(nomePet);
            oPet.setSituacao(situacao);
            oPet.setEspecie(new Especie(idEspecie, ""));
            oPet.setRaca(new Raca(idRaca, ""));
            
            GenericDAO dao = new PetDAO();
            if(dao.cadastrar(oPet)) {
                mensagem = "Pet cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar pet. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("PetListar").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar pet! Erro: " + ex.getMessage());
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
