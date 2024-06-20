package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;

@WebServlet("/AlunoControllerServlet")
public class AlunoServlet extends HttpServlet {
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
                    listAlunos(request, response);
                    break;
                case "LOAD":
                    loadAluno(request, response);
                    break;
                case "DELETE":
                    deleteAluno(request, response);
                    break;
                case "ADD":
                    showFormAdicionarAluno(request, response);
                    break;
                default:
                    listAlunos(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void showFormAdicionarAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pode redirecionar para o seu formulário de adicionar aluno aqui
        // Por exemplo:
        response.sendRedirect(request.getContextPath() + "/aluno-form.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            switch (theCommand) {
                case "ADD":
                    addAluno(request, response);
                    break;
                case "UPDATE":
                    updateAluno(request, response);
                    break;
                default:
                    listAlunos(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void listAlunos(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AlunoDAO alunoDao = new AlunoDAO();
        List<Aluno> alunos = alunoDao.getAlunos();
        request.setAttribute("ALUNO_LIST", alunos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno-list.jsp");
        dispatcher.forward(request, response);
    }

    private void addAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String matricula = request.getParameter("matricula");
        String curso = request.getParameter("curso");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");

        Aluno newAluno = new Aluno(matricula, curso, nome, email, lattes);

        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.addAluno(newAluno);

        listAlunos(request, response);
    }

    private void loadAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int alunoId = Integer.parseInt(request.getParameter("id"));

        AlunoDAO alunoDao = new AlunoDAO();
        Aluno theAluno = alunoDao.getAluno(alunoId);

        request.setAttribute("THE_ALUNO", theAluno);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-aluno-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateAluno(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String matricula = request.getParameter("matricula");
        String curso = request.getParameter("curso");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");

        Aluno alunoAtualizado = new Aluno(id, matricula, curso, nome, email, lattes);
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.updateAluno(alunoAtualizado);

        response.sendRedirect(request.getContextPath() + "/AlunoControllerServlet?command=LIST");
    }

    private void deleteAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int alunoId = Integer.parseInt(request.getParameter("id"));

            AlunoDAO alunoDao = new AlunoDAO();
            alunoDao.deletarAluno(alunoId);

            listAlunos(request, response);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
}
