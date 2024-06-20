package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

@WebServlet("/ProfessorControllerServlet")
public class ProfessorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DatabaseUtil databaseUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        databaseUtil = new DatabaseUtil();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            switch (theCommand) {
                case "LIST":
                    listProfessores(request, response);
                    break;
                case "LOAD":
                    loadProfessor(request, response);
                    break;
                case "DELETE":
                    deleteProfessor(request, response);
                    break;
                case "ADD":
                    showFormAdicionarProfessor(request, response);
                    break;
                default:
                    listProfessores(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            switch (theCommand) {
                case "ADD":
                    addProfessor(request, response);
                    break;
                case "UPDATE":
                    updateProfessor(request, response);
                    break;
                default:
                    listProfessores(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void listProfessores(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProfessorDAO professorDao = new ProfessorDAO();
        List<Professor> professores = professorDao.getProfessores();
        request.setAttribute("PROFESSOR_LIST", professores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/professor-list.jsp");
        dispatcher.forward(request, response);
    }

    private void addProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String areaAtuacao = request.getParameter("areaAtuacao");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");

        Professor newProfessor = new Professor(areaAtuacao, nome, email, lattes);

        ProfessorDAO professorDao = new ProfessorDAO();
        professorDao.addProfessor(newProfessor);

        listProfessores(request, response);
    }

    private void showFormAdicionarProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/professor-form.jsp");
    }

    private void loadProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int professorId = Integer.parseInt(request.getParameter("id"));

        ProfessorDAO professorDao = new ProfessorDAO();
        Professor theProfessor = professorDao.getProfessor(professorId);

        request.setAttribute("THE_PROFESSOR", theProfessor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-professor-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String areaAtuacao = request.getParameter("areaAtuacao");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");

        Professor professorAtualizado = new Professor(areaAtuacao, nome, email, lattes);

        ProfessorDAO professorDao = new ProfessorDAO();
        professorDao.updateProfessor(professorAtualizado);

        response.sendRedirect(request.getContextPath() + "/ProfessorControllerServlet?command=LIST");
    }

    private void deleteProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int professorId = Integer.parseInt(request.getParameter("id"));

            ProfessorDAO professorDao = new ProfessorDAO();
            professorDao.deletarProfessor(professorId);

            listProfessores(request, response);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
}
