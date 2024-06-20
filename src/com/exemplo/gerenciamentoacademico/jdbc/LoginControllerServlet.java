package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemplo.gerenciamentoacademico.jdbc.dao.UsuarioDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Usuario;

@WebServlet("/LoginControllerServlet")
public class LoginControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = new UsuarioDAO(); // Inicializa o usuarioDAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String tipoUsuario = request.getParameter("tipoUsuario");

        if (login == null || senha == null || tipoUsuario == null || login.isEmpty() || senha.isEmpty() || tipoUsuario.isEmpty()) {
            request.setAttribute("mensagemErro", "Login, senha e tipo de usuário são obrigatórios.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            Usuario usuario = usuarioDAO.getUsuarioByLoginAndPassword(login, senha);

            if (usuario != null && tipoUsuario.equalsIgnoreCase(usuario.gettipoUsuario())) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
                session.setAttribute("tipoUsuario", tipoUsuario);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("mensagemErro", "Login, senha ou tipo de usuário inválidos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}