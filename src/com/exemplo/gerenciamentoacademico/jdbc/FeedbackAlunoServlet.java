package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackAlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackAluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FeedbackAlunoServlet")
public class FeedbackAlunoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FeedbackAlunoDAO feedbackAlunoDAO;

    public void init() {
        feedbackAlunoDAO = new FeedbackAlunoDAO();
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
                listarFeedbacksAlunos(request, response);
                break;
            case "inserir":
                inserirFeedbackAluno(request, response);
                break;
            case "editar":
                editarFeedbackAluno(request, response);
                break;
            case "atualizar":
                atualizarFeedbackAluno(request, response);
                break;
            case "excluir":
                excluirFeedbackAluno(request, response);
                break;
            default:
                listarFeedbacksAlunos(request, response);
        }
    }

    private void listarFeedbacksAlunos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<FeedbackAluno> listaFeedbacks = feedbackAlunoDAO.getTodosFeedbacksAlunos();
        request.setAttribute("listaFeedbacks", listaFeedbacks);
        request.getRequestDispatcher("listar-feedbackaluno.jsp").forward(request, response);
    }

    private void inserirFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        String alunoNome = ""; // Recupere o nome do aluno conforme necessário
        String professorNome = ""; // Recupere o nome do professor conforme necessário

        FeedbackAluno novoFeedback = new FeedbackAluno(titulo, feedback, alunoId, professorId, alunoNome, professorNome);
        feedbackAlunoDAO.adicionarFeedbackAluno(novoFeedback);

        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }

    private void editarFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FeedbackAluno feedback = feedbackAlunoDAO.getFeedbackAlunoPorId(id);
        request.setAttribute("feedback", feedback);
        request.getRequestDispatcher("update-feedbackaluno-form.jsp").forward(request, response);
    }

    private void atualizarFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        String alunoNome = ""; // Recupere o nome do aluno conforme necessário
        String professorNome = ""; // Recupere o nome do professor conforme necessário

        FeedbackAluno feedbackAtualizado = new FeedbackAluno(id, titulo, feedback, alunoId, professorId, alunoNome, professorNome);
        feedbackAlunoDAO.atualizarFeedbackAluno(feedbackAtualizado);

        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }

    private void excluirFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        feedbackAlunoDAO.excluirFeedbackAluno(id);
        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }
}
