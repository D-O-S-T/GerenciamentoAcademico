package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioControllerServlet")
public class UsuarioServlet extends HttpServlet {
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
				listUsuarios(request, response);
				break;
			case "LOAD":
				loadUsuario(request, response);
				break;
			case "DELETE":
				deleteUsuario(request, response);
				break;
			default:
				listUsuarios(request, response);
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
		List<Usuario> usuarios = databaseUtil.getUsuarios();
		request.setAttribute("USUARIO_LIST", usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario-list.jsp");
		dispatcher.forward(request, response);
	}

	private void addUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String tipoUsuario = request.getParameter("tipoUsuario");

		Usuario newUsuario = new Usuario(login, email, senha, tipoUsuario);

		databaseUtil.addUsuario(newUsuario);

		listUsuarios(request, response);
	}

	private void loadUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Implementation for loading a user
	}

	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Implementation for updating a user
	}



	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        // 1. Recuperação do ID do usuário a ser excluído
	        int usuarioId = Integer.parseInt(request.getParameter("id"));

	        // 2. Chamada ao método do DAO para excluir o usuário
	        databaseUtil.deletarUsuario(usuarioId);

	        // 3. Atualiza a lista de usuários e redireciona para a página de listagem
	        listUsuarios(request, response);
	    } catch (Exception exc) {
	        throw new ServletException(exc);
	    }
	}
}
