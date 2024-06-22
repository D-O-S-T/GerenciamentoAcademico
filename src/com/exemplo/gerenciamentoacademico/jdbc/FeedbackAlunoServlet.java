package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackAlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackAluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        Object alunoIdObj = session.getAttribute("alunoId");

        if (alunoIdObj != null && alunoIdObj instanceof Integer) {
            int alunoId = (Integer) alunoIdObj;
            List<FeedbackAluno> listaFeedbacks = feedbackAlunoDAO.getFeedbacksPorAluno(alunoId);
            request.setAttribute("listaFeedbacks", listaFeedbacks);
            request.getRequestDispatcher("listar-feedbackaluno.jsp").forward(request, response);
        } else {
            // Redireciona para a página de login se o alunoId não estiver na sessão
            response.sendRedirect("index.jsp");
        }
    }
//    private void listarFeedbacksAlunos(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<FeedbackAluno> listaFeedbacks = feedbackAlunoDAO.getTodosFeedbacksAlunos();
//        request.setAttribute("listaFeedbacks", listaFeedbacks);
//        request.getRequestDispatcher("listar-feedbackaluno.jsp").forward(request, response);
//    }

//    private void inserirFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String titulo = request.getParameter("titulo");
//        String feedback = request.getParameter("feedback");
//        int alunoId = Integer.parseInt(request.getParameter("alunoId"));
//        int professorId = Integer.parseInt(request.getParameter("professorId"));
//        String alunoNome = ""; // Recupere o nome do aluno conforme necessário
//        String professorNome = ""; // Recupere o nome do professor conforme necessário
//
//        FeedbackAluno novoFeedback = new FeedbackAluno(titulo, feedback, alunoId, professorId, alunoNome, professorNome);
//        feedbackAlunoDAO.adicionarFeedbackAluno(novoFeedback);
//
//        response.sendRedirect("FeedbackAlunoServlet?action=listar");
//    }
    
    
    private void inserirFeedbackAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String feedback = request.getParameter("feedback");
        int professorId = Integer.parseInt(request.getParameter("professorId"));

        // Obter o id do aluno a partir da sessão
        HttpSession session = request.getSession();
        Object usuarioIdObj = session.getAttribute("usuarioId");

        if (usuarioIdObj != null && usuarioIdObj instanceof Integer) {
            int alunoId = (Integer) usuarioIdObj;

            // Criar o objeto FeedbackAluno
            FeedbackAluno novoFeedback = new FeedbackAluno(titulo, feedback, alunoId, professorId);
            feedbackAlunoDAO.adicionarFeedbackAluno(novoFeedback);

            response.sendRedirect("FeedbackAlunoServlet?action=listar");
        } else {
            // Lidar com o caso em que o usuário não está autenticado
            response.sendRedirect("index.jsp"); // ou redirecionar para a página de login novamente
        }
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
