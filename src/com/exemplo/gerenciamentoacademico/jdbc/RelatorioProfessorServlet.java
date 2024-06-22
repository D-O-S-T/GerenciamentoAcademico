package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.RelatorioProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioProfessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RelatorioProfessorServlet")
public class RelatorioProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RelatorioProfessorDAO relatorioProfessorDAO;

    public void init() {
        relatorioProfessorDAO = new RelatorioProfessorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarRelatoriosProfessores(request, response);
                break;
            case "inserir":
                inserirRelatorioProfessor(request, response);
                break;
            case "editar":
                editarRelatorioProfessor(request, response);
                break;
            case "atualizar":
                atualizarRelatorioProfessor(request, response);
                break;
            case "excluir":
                excluirRelatorioProfessor(request, response);
                break;
            default:
                listarRelatoriosProfessores(request, response);
        }
    }

    private void listarRelatoriosProfessores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RelatorioProfessor> listaRelatorios = relatorioProfessorDAO.getTodosRelatoriosProfessor();
        request.setAttribute("listaRelatorios", listaRelatorios);
        request.getRequestDispatcher("listar-relatorios.jsp").forward(request, response);
    }

    private void inserirRelatorioProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String relatorio = request.getParameter("relatorio");
        int professorId = Integer.parseInt(request.getParameter("professor_id"));

        RelatorioProfessor novoRelatorio = new RelatorioProfessor(titulo, relatorio, professorId);
        relatorioProfessorDAO.adicionarRelatorioProfessor(novoRelatorio);

        response.sendRedirect("RelatorioProfessorServlet?action=listar");
    }

    private void editarRelatorioProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RelatorioProfessor relatorioProfessor = relatorioProfessorDAO.getRelatorioProfessorPorId(id);
        request.setAttribute("relatorioProfessor", relatorioProfessor);
        request.getRequestDispatcher("update-relatorio-form.jsp").forward(request, response);
    }

    private void atualizarRelatorioProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String relatorio = request.getParameter("relatorio");
        int professorId = Integer.parseInt(request.getParameter("professor_id"));

        RelatorioProfessor relatorioAtualizado = new RelatorioProfessor(id, titulo, relatorio, professorId);
        relatorioProfessorDAO.atualizarRelatorioProfessor(relatorioAtualizado);

        response.sendRedirect("RelatorioProfessorServlet?action=listar");
    }

    private void excluirRelatorioProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        relatorioProfessorDAO.excluirRelatorioProfessor(id);
        response.sendRedirect("RelatorioProfessorServlet?action=listar");
    }
}
