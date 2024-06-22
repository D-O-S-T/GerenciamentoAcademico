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

        // Validar o login e senha de acordo com o tipo de usuário selecionado
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
            // Definir o id e o nome na sessão
            HttpSession session = request.getSession();
            session.setAttribute("usuarioId", usuario.getId());
            session.setAttribute("usuarioNome", usuario.getNome());
            
            // Redirecionar para a página apropriada
            switch (tipoUsuario) {
                case "professor":
                    response.sendRedirect("index-professor.jsp");
                    break;
                case "aluno":
                    response.sendRedirect("index-aluno.jsp");
                    break;
                case "coordenador":
                    response.sendRedirect("index-coordenador.jsp");
                    break;
            }
        } else {
            // Definir a mensagem de erro e encaminhar de volta para index.jsp
            request.setAttribute("erroLogin", "Senha, login ou tipo de usuário está errado.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}


