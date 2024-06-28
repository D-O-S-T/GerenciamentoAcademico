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
        String action = request.getParameter("action");
        
        if ("login".equals(action)) {
            handleLogin(request, response);
        } else if ("redefinirSenha".equals(action)) {
            handleRedefinirSenha(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            if ("aluno".equals(tipoUsuario)) {
                session.setAttribute("alunoId", usuario.getId());
            } else if ("professor".equals(tipoUsuario)) {
                session.setAttribute("professorId", usuario.getId());
            }

            String redirectPage = getRedirectPage(tipoUsuario);
            response.sendRedirect(redirectPage);
        } else {
            request.setAttribute("erroLogin", "Senha, login ou tipo de usuário está errado.");
            // Limpa mensagens de sucesso e redireciona para index.jsp
            clearSessionMessages(request);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void handleRedefinirSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoUsuario = request.getParameter("tipoUsuario");
        String user = request.getParameter("user");
        String novaSenha = request.getParameter("novaSenha");
        String confirmarSenha = request.getParameter("confirmarSenha");

        if (novaSenha.equals(confirmarSenha)) {
            IndexDAO indexDAO = new IndexDAO();
            boolean isUpdated = false;

            switch (tipoUsuario) {
                case "professor":
                    isUpdated = indexDAO.atualizarSenhaProfessor(user, novaSenha);
                    break;
                case "aluno":
                    isUpdated = indexDAO.atualizarSenhaAluno(user, novaSenha);
                    break;
                case "coordenador":
                    isUpdated = indexDAO.atualizarSenhaCoordenador(user, novaSenha);
                    break;
            }

            if (isUpdated) {
                HttpSession session = request.getSession();
                session.setAttribute("mensagemSucesso", "Senha atualizada com sucesso.");
                // Redireciona para index.jsp
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("erroRedefinicao", "Usuário não encontrado.");
                // Limpa mensagens de sucesso e redireciona para index.jsp
                clearSessionMessages(request);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("erroRedefinicao", "As senhas não coincidem.");
            // Limpa mensagens de sucesso e redireciona para index.jsp
            clearSessionMessages(request);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void clearSessionMessages(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("mensagemSucesso");
    }

    private String getRedirectPage(String tipoUsuario) {
        switch (tipoUsuario) {
            case "professor":
                return "index-professor.jsp";
            case "aluno":
                return "index-aluno.jsp";
            case "coordenador":
                return "index-coordenador.jsp";
            default:
                return "index.jsp";
        }
    }
}
