package com.exemplo.gerenciamentoacademico.jdbc;



import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

@WebServlet("/professores")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DatabaseUtil databaseUtil;
    private ProfessorDAO professorDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		databaseUtil = new DatabaseUtil();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Professor> professores = professorDAO.listarTodos();
            request.setAttribute("professores", professores);
            request.getRequestDispatcher("/listaProfessores.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar professores", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String areaAtuacao = request.getParameter("areaAtuacao");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");

        Professor professor = new Professor(areaAtuacao, nome, email, lattes);

        try {
            professorDAO.inserir(professor);
            response.sendRedirect(request.getContextPath() + "/professores");
        } catch (SQLException e) {
            throw new ServletException("Erro ao inserir professor", e);
        }
    }

   
}
