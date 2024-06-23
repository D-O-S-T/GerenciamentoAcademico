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
import com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackProfessor;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

@WebServlet("/FeedbackProfessorServlet")
public class FeedbackProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FeedbackProfessorDAO feedbackProfessorDAO;

    public void init() {
        feedbackProfessorDAO = new FeedbackProfessorDAO();
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
        int professorId = (int) session.getAttribute("professorId");
        
        List<FeedbackProfessor> listaFeedbacks = feedbackProfessorDAO.getFeedbacksPorProfessor(professorId);

     // Para cada feedback, obter o nome do aluno e definir no objeto FeedbackProfessor
     for (FeedbackProfessor feedback : listaFeedbacks) {
         String nomeAluno = feedbackProfessorDAO.getNomeAlunoPorFeedbackId(feedback.getId());
        
         feedback.setAlunoNome(nomeAluno);
     }

  
        request.setAttribute("listaFeedbacks", listaFeedbacks);
        request.getRequestDispatcher("listar-feedbackprofessor.jsp").forward(request, response);
    }

    private void inserirFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        HttpSession session = request.getSession();
        
        // Verificar se professorId está presente na sessão
        Integer professorId = (Integer) session.getAttribute("usuarioId");
        if (professorId == null) {
            // Tratar o caso em que professorId não está na sessão
            throw new ServletException("ID do professor não encontrado na sessão.");
        }

        // Verificar se alunoId está presente no request
        String alunoIdStr = request.getParameter("alunoId");
        if (alunoIdStr == null || alunoIdStr.isEmpty()) {
            // Tratar o caso em que alunoId não está presente no formulário
            throw new ServletException("ID do aluno não foi enviado no formulário.");
        }
        
        int alunoId = Integer.parseInt(alunoIdStr);

        FeedbackProfessor novoFeedback = new FeedbackProfessor(titulo, feedback, professorId, alunoId);
        feedbackProfessorDAO.adicionarFeedback(novoFeedback);

        response.sendRedirect("FeedbackProfessorServlet?action=listar");
    }
    private void editarFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FeedbackProfessor feedback = feedbackProfessorDAO.getFeedbackPorId(id);

        // Obtém listas de professores e alunos do banco de dados
        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();

        request.setAttribute("feedback", feedback);
        request.setAttribute("listaProfessores", listaProfessores);
        request.setAttribute("listaAlunos", listaAlunos);

        request.getRequestDispatcher("update-feedbackprofessor-form.jsp").forward(request, response);
    }

    private void atualizarFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        HttpSession session = request.getSession();
        int professorId = (int) session.getAttribute("professorId"); // Obtém o professorId da sessão
        int alunoId = Integer.parseInt(request.getParameter("alunoId"));

        FeedbackProfessor feedbackAtualizado = new FeedbackProfessor(id, titulo, feedback, professorId, alunoId);
        feedbackProfessorDAO.atualizarFeedback(feedbackAtualizado);

        response.sendRedirect("FeedbackProfessorServlet?action=listar");
    }

    private void excluirFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        feedbackProfessorDAO.excluirFeedback(id);
        response.sendRedirect("FeedbackProfessorServlet?action=listar");
    }
}


