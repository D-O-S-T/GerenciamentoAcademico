package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;

@WebServlet("/ProjetoControllerServlet")
public class ProjetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetoDAO projetoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        projetoDAO = new ProjetoDAO(); // Inicializa o projetoDAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            switch (theCommand) {
                case "LIST":
                    listProjetos(request, response);
                    break;
                case "LOAD":
                    loadProjeto(request, response);
                    break;
                case "DELETE":
                    deleteProjeto(request, response);
                    break;
                case "ADD":
                    showFormAdicionarProjeto(request, response);
                    break;
                default:
                    listProjetos(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void showFormAdicionarProjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/projeto-form.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            switch (theCommand) {
                case "ADD":
                    addProjeto(request, response);
                    break;
                case "UPDATE":
                    updateProjeto(request, response);
                    break;
                default:
                    listProjetos(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void listProjetos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Projeto> projetos = projetoDAO.getProjetos();
        request.setAttribute("PROJETO_LIST", projetos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/projeto-list.jsp");
        dispatcher.forward(request, response);
    }

    private void addProjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        java.sql.Date dataInicial = java.sql.Date.valueOf(request.getParameter("dataInicial"));
        java.sql.Date dataFinal = java.sql.Date.valueOf(request.getParameter("dataFinal"));
        int qtdAulas = Integer.parseInt(request.getParameter("qtdAulas"));

        Projeto novoProjeto = new Projeto(titulo, dataInicial, dataFinal, qtdAulas);
        projetoDAO.addProjeto(novoProjeto);

        response.sendRedirect(request.getContextPath() + "/ProjetoControllerServlet?command=LIST");
    }

    private void loadProjeto(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int projetoId = Integer.parseInt(request.getParameter("id"));
        Projeto theProjeto = projetoDAO.getProjeto(projetoId);
        request.setAttribute("THE_PROJETO", theProjeto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-projeto-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProjeto(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        java.sql.Date dataInicial = java.sql.Date.valueOf(request.getParameter("dataInicial"));
        java.sql.Date dataFinal = java.sql.Date.valueOf(request.getParameter("dataFinal"));
        int qtdAulas = Integer.parseInt(request.getParameter("qtdAulas"));

        Projeto projetoAtualizado = new Projeto(id, titulo, dataInicial, dataFinal, qtdAulas);
        projetoDAO.updateProjeto(projetoAtualizado);

        response.sendRedirect(request.getContextPath() + "/ProjetoControllerServlet?command=LIST");
    }

    private void deleteProjeto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int projetoId = Integer.parseInt(request.getParameter("id"));
            projetoDAO.deletarProjeto(projetoId);
            listProjetos(request, response);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
}
