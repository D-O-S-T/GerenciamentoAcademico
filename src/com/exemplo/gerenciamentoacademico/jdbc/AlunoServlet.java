package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AlunoDAO alunoDAO;

    public void init() {
        alunoDAO = new AlunoDAO();
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
                listarAlunos(request, response);
                break;
            case "inserir":
                inserirAluno(request, response);
                break;
            case "editar":
                editarAluno(request, response);
                break;
            case "atualizar":
                atualizarAluno(request, response);
                break;
            case "excluir":
                excluirAluno(request, response);
                break;
            default:
                listarAlunos(request, response);
        }
    }

    private void listarAlunos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();
        request.setAttribute("listaAlunos", listaAlunos);
        request.getRequestDispatcher("listar-alunos.jsp").forward(request, response);
    }

    private void inserirAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Aluno novoAluno = new Aluno(matricula, nome, email, lattes, login, senha);
        alunoDAO.adicionarAluno(novoAluno);

        response.sendRedirect("AlunoServlet?action=listar");
    }

    private void editarAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Aluno aluno = alunoDAO.getAlunoPorId(id);
        request.setAttribute("aluno", aluno);
        request.getRequestDispatcher("update-aluno-form.jsp").forward(request, response);
    }

    private void atualizarAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String lattes = request.getParameter("lattes");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Aluno alunoAtualizado = new Aluno(id, matricula, nome, email, lattes, login, senha);
        alunoDAO.atualizarAluno(alunoAtualizado);

        response.sendRedirect("AlunoServlet?action=listar");
    }

    private void excluirAluno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        alunoDAO.excluirAluno(id);
        response.sendRedirect("AlunoServlet?action=listar");
    }
}
