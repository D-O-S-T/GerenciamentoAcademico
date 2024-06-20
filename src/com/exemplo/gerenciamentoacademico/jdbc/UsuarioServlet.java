package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.UsuarioDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Usuario;

@WebServlet("/UsuarioControllerServlet")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDAO = new UsuarioDAO(); // Inicializa o usuarioDAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "LIST";
            }

            switch (theCommand) {
                case "LIST":
                    listUsuarios(request, response);
                    break;
                case "LOAD":
                    loadUsuario(request, response);
                    break;
                case "DELETE":
                    deleteUsuario(request, response);
                    break;
                case "ADD":
                    showFormAdicionarUsuario(request, response);
                    break;
                default:
                    listUsuarios(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void showFormAdicionarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/usuario-form.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");

            switch (theCommand) {
                case "ADD":
                    addUsuario(request, response);
                    break;
                case "UPDATE":
                    updateUsuario(request, response);
                    break;
                default:
                    listUsuarios(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    private void listUsuarios(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        request.setAttribute("USUARIO_LIST", usuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario-list.jsp");
        dispatcher.forward(request, response);
    }

    private void addUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipoUsuario = request.getParameter("tipoUsuario");

        Usuario novoUsuario = new Usuario(login, email, senha, tipoUsuario);
        usuarioDAO.addUsuario(novoUsuario);

        // Após adicionar o usuário, redirecione para a página de login
        response.sendRedirect("login.jsp");
    }

    private void loadUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int usuarioId = Integer.parseInt(request.getParameter("id"));
        Usuario theUsuario = usuarioDAO.getUsuario(usuarioId);
        request.setAttribute("THE_USUARIO", theUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-usuario-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipoUsuario = request.getParameter("tipoUsuario");

        Usuario usuarioAtualizado = new Usuario(id, login, email, senha, tipoUsuario);
        usuarioDAO.updateUsuario(usuarioAtualizado);

        response.sendRedirect(request.getContextPath() + "/UsuarioControllerServlet?command=LIST");
    }

    private void deleteUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int usuarioId = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.deletarUsuario(usuarioId);
            listUsuarios(request, response);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
}
