package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProfessorDAO professorDAO;

    public void init() {
       
    	
        professorDAO = new ProfessorDAO();
        

       
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
                listarProfessores(request, response);
                break;
            case "inserir":
                inserirProfessor(request, response);
                break;
            case "editar":
                editarProfessor(request, response);
                break;
            case "atualizar":
                atualizarProfessor(request, response);
                break;
            case "excluir":
                excluirProfessor(request, response);
                break;
            default:
                listarProfessores(request, response);
        }
    }

    private void listarProfessores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();
        request.setAttribute("listaProfessores", listaProfessores);
        request.getRequestDispatcher("listar-professores.jsp").forward(request, response);
    }

    private void inserirProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String areaAtuacao = request.getParameter("areaAtuacao");

        Professor novoProfessor = new Professor(nome, email, lattes, login, senha, areaAtuacao);
        professorDAO.adicionarProfessor(novoProfessor);

        response.sendRedirect("ProfessorServlet?action=listar");
    }

    private void editarProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Professor professor = professorDAO.getProfessorPorId(id);
        request.setAttribute("professor", professor);
        request.getRequestDispatcher("update-professor-form.jsp").forward(request, response);
    }

    private void atualizarProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String areaAtuacao = request.getParameter("areaAtuacao");

        Professor professorAtualizado = new Professor(id, nome, email, lattes, login, senha, areaAtuacao);
        professorDAO.atualizarProfessor(professorAtualizado);

        response.sendRedirect("ProfessorServlet?action=listar");
    }

    private void excluirProfessor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        professorDAO.excluirProfessor(id);
        response.sendRedirect("ProfessorServlet?action=listar");
    }
}
