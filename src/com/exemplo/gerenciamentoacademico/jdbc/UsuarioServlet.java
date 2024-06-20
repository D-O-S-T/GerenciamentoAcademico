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
	            case "ADD": // Adicionar este case para o comando ADD
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
	    // Pode redirecionar para o seu formulário de adicionar usuário aqui
	    // Por exemplo:
	    response.sendRedirect(request.getContextPath() + "/usuario-form.jsp");
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
		 UsuarioDAO usuarioDao = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDao.getUsuarios();
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
		
		 UsuarioDAO usuarioDao = new UsuarioDAO();
		 usuarioDao.addUsuario(newUsuario);

		listUsuarios(request, response);
	}

	private void loadUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
	    // 1. Recupera o ID do usuário a partir do parâmetro da solicitação
	    int usuarioId = Integer.parseInt(request.getParameter("id"));
	    
	    UsuarioDAO usuarioDao = new UsuarioDAO();
	    // 2. Obtém o usuário do banco de dados (utilizando DatabaseUtil)
	    Usuario theUsuario = usuarioDao.getUsuario(usuarioId);

	    // 3. Coloca o usuário no request como um atributo
	    request.setAttribute("THE_USUARIO", theUsuario);

	    // 4. Envia para a página JSP: update-usuario-form.jsp
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/update-usuario-form.jsp");
	    dispatcher.forward(request, response);
	}


	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // 1. Recuperar os parâmetros do formulário
	    int id = Integer.parseInt(request.getParameter("id"));
	    String login = request.getParameter("login");
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    String tipoUsuario = request.getParameter("tipoUsuario");

	    // 2. Criar um objeto Usuario com os novos dados
	    Usuario usuarioAtualizado = new Usuario(id, login, email, senha, tipoUsuario);
	    UsuarioDAO usuarioDao = new UsuarioDAO();
	    // 3. Chamar o método para atualizar o usuário no banco de dados
	    usuarioDao.updateUsuario(usuarioAtualizado);

	    // 4. Redirecionar para a página de listagem de usuários após a atualização
	    response.sendRedirect(request.getContextPath() + "/UsuarioControllerServlet?command=LIST");
	}



	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        // 1. Recuperação do ID do usuário a ser excluído
	        int usuarioId = Integer.parseInt(request.getParameter("id"));

	        // 2. Chamada ao método do DAO para excluir o usuário
	        UsuarioDAO usuarioDao = new UsuarioDAO();
	        usuarioDao.deletarUsuario(usuarioId);

	        // 3. Atualiza a lista de usuários e redireciona para a página de listagem
	        listUsuarios(request, response);
	    } catch (Exception exc) {
	        throw new ServletException(exc);
	    }
	}
}
