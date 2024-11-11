package br.com.petEssence.controller.atendimento;

import br.com.petEssence.dao.AtendimentoDAO;
import br.com.petEssence.dao.GenericDAO;
import br.com.petEssence.dao.PetDAO;
import br.com.petEssence.model.Atendimento;
import br.com.petEssence.model.Especie;
import br.com.petEssence.model.Pet;
import br.com.petEssence.model.Raca;
import br.com.petEssence.utils.Conversao;
import java.io.IOException;
import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AtendimentoCadastrar", urlPatterns = {"/AtendimentoCadastrar"})
public class AtendimentoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=iso-8859-1");

        int idAtendimento = Integer.parseInt(request.getParameter("idatendimento"));
        int idPet = Integer.parseInt(request.getParameter("idpet"));
        Conversao oConversao = new Conversao();

        String descricao = request.getParameter("descricao");
        Date dataAtendimento = oConversao.converterData(request.getParameter(("dataatendimento")));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        String horarioParam = request.getParameter("horario");
        String duracaoParam = request.getParameter("duracao");

        String horarioStr = horarioParam.substring(0, 5);
        String duracaoStr = duracaoParam.substring(0, 5);

        LocalTime horario = LocalTime.parse(horarioStr, formatter);
        LocalTime duracao = LocalTime.parse(duracaoStr, formatter);

        double valor = oConversao.valorDinheiro(request.getParameter("valor"));
        String nomeVeterinario = request.getParameter("nomeveterinario");

        String mensagem = null;

        try {
            Atendimento oAtendimento = new Atendimento();
            PetDAO oPetDAO = new PetDAO();
            Pet oPet = new Pet();

            oAtendimento.setIdAtendimento(idAtendimento);
            oAtendimento.setDescricao(descricao);
            oAtendimento.setHorario(horario);
            oAtendimento.setDuracao(duracao);
            oAtendimento.setValor(valor);
            oAtendimento.setDataAtendimento(dataAtendimento);
            oAtendimento.setNomeVeterinario(nomeVeterinario);
            oAtendimento.setPet(new Pet(idPet, "", new Especie(), new Raca(), ""));

            GenericDAO dao = new AtendimentoDAO();
            if (dao.cadastrar(oAtendimento)) {
                mensagem = "Atendimento cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Atendimento. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("AtendimentoListar").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Atendimento! Erro: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AtendimentoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AtendimentoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
