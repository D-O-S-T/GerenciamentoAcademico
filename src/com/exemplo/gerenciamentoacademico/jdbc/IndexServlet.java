package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.IndexDAO;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoUsuario = request.getParameter("tipoUsuario");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        IndexDAO indexDAO = new IndexDAO();
        boolean isValidLogin = false;

        // Validar o login e senha de acordo com o tipo de usuário selecionado
        switch (tipoUsuario) {
            case "professor":
                isValidLogin = indexDAO.validarProfessor(login, senha);
                if (isValidLogin) {
                    response.sendRedirect("index-professor.jsp");
                } else {
                    response.sendRedirect("erro-login.jsp");
                }
                break;
            case "aluno":
                isValidLogin = indexDAO.validarAluno(login, senha);
                if (isValidLogin) {
                    response.sendRedirect("index-aluno.jsp");
                } else {
                    response.sendRedirect("erro-login.jsp");
                }
                break;
            case "coordenador":
                isValidLogin = indexDAO.validarCoordenador(login, senha);
                if (isValidLogin) {
                    response.sendRedirect("index-coordenador.jsp");
                } else {
                    response.sendRedirect("erro-login.jsp");
                }
                break;
            default:
                response.sendRedirect("erro-login.jsp");
                break;
        }
    }
}

