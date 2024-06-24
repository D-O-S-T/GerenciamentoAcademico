package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackProfessor;

@WebServlet("/ListarFeedbackAlunoServlet")
public class ListarFeedbackAlunoServlet extends HttpServlet {
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
        listarFeedbacksAluno(request, response);
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
        
        System.out.println("Método listarFeedbacksAluno foi chamado.");

        System.out.println("alunoId: " + alunoId);

        List<FeedbackProfessor> listaFeedbacksProfessor = feedbackProfessorDAO.getFeedbacksPorAlunoId(alunoId);

        System.out.println("Número de feedbacks recuperados no Servlet: " + listaFeedbacksProfessor.size());

        request.setAttribute("listaFeedbacksProfessor", listaFeedbacksProfessor);
        request.getRequestDispatcher("listar-feedbackaluno.jsp").forward(request, response);
    }
}
