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
                listarFeedbacks(request, response);
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
                listarFeedbacks(request, response);
        }
    }

    private void listarFeedbacks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        ////confira IndexSerlet para ver se esse atributo foi passado para lá
        int alunoId = (int) session.getAttribute("alunoId");
        
        List<FeedbackAluno> listaFeedbacks = feedbackAlunoDAO.getFeedbacksPorAluno(alunoId);

        // Para cada feedback, obter o nome do professor e definir no objeto FeedbackAluno
        for (FeedbackAluno feedback : listaFeedbacks) {
            String nomeProfessor = feedbackAlunoDAO.getNomeProfessorPorFeedbackId(feedback.getId());
            feedback.setProfessorNome(nomeProfessor);
        }

        request.setAttribute("listaFeedbacks", listaFeedbacks);
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

        String professorIdStr = request.getParameter("professorId");
        if (professorIdStr == null || professorIdStr.isEmpty()) {
            throw new ServletException("ID do professor não foi enviado no formulário.");
        }

        int professorId = Integer.parseInt(professorIdStr);

        FeedbackAluno novoFeedback = new FeedbackAluno(titulo, feedback, professorId, alunoId);
        feedbackAlunoDAO.adicionarFeedback(novoFeedback);

        response.sendRedirect("FeedbackAlunoServlet?action=listar");
    }

    private void editarFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FeedbackAluno feedback = feedbackAlunoDAO.getFeedbackPorId(id);

        // Obtém listas de professores e alunos do banco de dados
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
        int alunoId = (int) session.getAttribute("alunoId"); // Obtém o alunoId da sessão
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
