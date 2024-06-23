package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackAlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackAluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

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
                listarFeedbacksAluno(request, response);
                break;
            case "inserir":
                inserirFeedback(request, response);
                break;
            case "editar":
                editarFeedback(request, response);
                break;
            case "atualizar":
                atualizarFeedback(request, response);
                break;
            case "excluir":
                excluirFeedback(request, response);
                break;
            default:
                listarFeedbacksAluno(request, response);
        }
    }

    private void listarFeedbacksAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer alunoId = (Integer) session.getAttribute("alunoId");

        if (alunoId == null) {
            System.out.println("alunoId não encontrado na sessão.");
            response.sendRedirect("index.jsp");
            return;
        }

        System.out.println("alunoId: " + alunoId);

        List<FeedbackAluno> listaFeedbacksAluno = feedbackAlunoDAO.getFeedbacksPorAluno(alunoId);

        System.out.println("Número de feedbacks recuperados no Servlet: " + listaFeedbacksAluno.size());

        for (FeedbackAluno feedback : listaFeedbacksAluno) {
            String nomeProfessor = feedbackAlunoDAO.getNomeProfessorPorFeedbackId(feedback.getId());
            feedback.setProfessorNome(nomeProfessor);
        }

        request.setAttribute("listaFeedbacksAluno", listaFeedbacksAluno);
        request.getRequestDispatcher("listar-feedbackaluno.jsp").forward(request, response);
    }

    private void inserirFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        HttpSession session = request.getSession();

        Integer alunoId = (Integer) session.getAttribute("alunoId");
        if (alunoId == null) {
            throw new ServletException("ID do aluno não encontrado na sessão.");
        }

        System.out.println("alunoId ao inserir feedback: " + alunoId);

        String professorIdStr = request.getParameter("professorId");
        if (professorIdStr == null || professorIdStr.isEmpty()) {
            throw new ServletException("ID do professor não foi enviado no formulário.");
        }

        int professorId = Integer.parseInt(professorIdStr);

        FeedbackAluno novoFeedback = new FeedbackAluno(titulo, feedback, alunoId, professorId);
        feedbackAlunoDAO.adicionarFeedback(novoFeedback);

        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }
    private void editarFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FeedbackAluno feedback = feedbackAlunoDAO.getFeedbackPorId(id);

        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();

        request.setAttribute("feedback", feedback);
        request.setAttribute("listaProfessores", listaProfessores);
        request.setAttribute("listaAlunos", listaAlunos);

        request.getRequestDispatcher("update-feedbackaluno-form.jsp").forward(request, response);
    }

    private void atualizarFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        HttpSession session = request.getSession();
        int alunoId = (int) session.getAttribute("alunoId");
        int professorId = Integer.parseInt(request.getParameter("professorId"));

        FeedbackAluno feedbackAtualizado = new FeedbackAluno(id, titulo, feedback, alunoId, professorId);
        feedbackAlunoDAO.atualizarFeedback(feedbackAtualizado);

        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }

    private void excluirFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        feedbackAlunoDAO.excluirFeedback(id);
        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }
}
