package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cadastrarProfessor")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfessorDAO professorDAO;
    private DatabaseUtil databaseUtil;

    public void init() {
        professorDAO = new ProfessorDAO();
        DatabaseUtil databaseUtil = new DatabaseUtil();
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Professor professor = new Professor(nome, email, lattes, login, senha);

        try {
            professorDAO.insertProfessor(professor); // Passa databaseUtil como parâmetro
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("sucesso.html");
    }
}
