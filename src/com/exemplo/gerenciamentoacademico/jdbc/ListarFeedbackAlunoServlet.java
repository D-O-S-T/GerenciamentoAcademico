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
    	
    	 String action = request.getParameter("action");

         if (action == null) {
             action = "listar";
         }

         switch (action) {
             case "listar":
                 listarFeedbacksAluno(request, response);
                 break;
            default :
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
        
        System.out.println("Método listarFeedbacksAluno foi chamado.");

        System.out.println("alunoId: " + alunoId);

        List<FeedbackProfessor> listaFeedbacksProfessor = feedbackProfessorDAO.getFeedbacksPorAlunoId(alunoId);
        
        
        // Para cada feedback, obter o nome do aluno e definir no objeto FeedbackProfessor
        for (FeedbackProfessor feedback : listaFeedbacksProfessor) {
            String nomeProfessor = feedbackProfessorDAO.getNomeProfessorPorFeedbackId(feedback.getId());
           
            feedback.setProfessorNome(nomeProfessor);
        }

        System.out.println("Número de feedbacks recuperados no Servlet: " + listaFeedbacksProfessor.size());

        request.setAttribute("listaFeedbacksProfessor", listaFeedbacksProfessor);
        request.getRequestDispatcher("aluno-feedbackprofessor-list.jsp").forward(request, response);
    }
}
