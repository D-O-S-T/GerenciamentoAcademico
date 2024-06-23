package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemplo.gerenciamentoacademico.jdbc.dao.IndexDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Usuario;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoUsuario = request.getParameter("tipoUsuario");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        IndexDAO indexDAO = new IndexDAO();
        Usuario usuario = null;

        switch (tipoUsuario) {
            case "professor":
                usuario = indexDAO.validarProfessor(login, senha);
                break;
            case "aluno":
                usuario = indexDAO.validarAluno(login, senha);
                break;
            case "coordenador":
                usuario = indexDAO.validarCoordenador(login, senha);
                break;
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNome", usuario.getNome());
            // Definindo o ID para o tipo de usuário correto
            if ("aluno".equals(tipoUsuario)) {
                session.setAttribute("alunoId", usuario.getId());
            } else if ("professor".equals(tipoUsuario)) {
                session.setAttribute("professorId", usuario.getId());
            }

            if ("professor".equals(tipoUsuario)) {
                response.sendRedirect("index-professor.jsp");
            } else if ("aluno".equals(tipoUsuario)) {
                response.sendRedirect("index-aluno.jsp");
            } else if ("coordenador".equals(tipoUsuario)) {
                response.sendRedirect("index-coordenador.jsp");
            }
        } else {
            request.setAttribute("erroLogin", "Senha, login ou tipo de usuário está errado.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
