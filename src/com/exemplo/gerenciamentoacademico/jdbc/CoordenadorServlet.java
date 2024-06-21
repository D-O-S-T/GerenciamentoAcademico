package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.CoordenadorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Coordenador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CoordenadorServlet")
public class CoordenadorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CoordenadorDAO coordenadorDAO;

    public void init() {
        coordenadorDAO = new CoordenadorDAO();
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
                listarCoordenadores(request, response);
                break;
            case "inserir":
                inserirCoordenador(request, response);
                break;
            case "editar":
                editarCoordenador(request, response);
                break;
            case "atualizar":
                atualizarCoordenador(request, response);
                break;
            case "excluir":
                excluirCoordenador(request, response);
                break;
            default:
                listarCoordenadores(request, response);
        }
    }

    private void listarCoordenadores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Coordenador> listaCoordenadores = coordenadorDAO.getTodosCoordenadores();
        request.setAttribute("listaCoordenadores", listaCoordenadores);
        request.getRequestDispatcher("listar-coordenadores.jsp").forward(request, response);
    }

    private void inserirCoordenador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Coordenador novoCoordenador = new Coordenador(nome, email, login, senha);
        coordenadorDAO.adicionarCoordenador(novoCoordenador);

        response.sendRedirect("CoordenadorServlet?action=listar");
    }

    private void editarCoordenador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Coordenador coordenador = coordenadorDAO.getCoordenadorPorId(id);
        request.setAttribute("coordenador", coordenador);
        request.getRequestDispatcher("update-coordenador-form.jsp").forward(request, response);
    }

    private void atualizarCoordenador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Coordenador coordenadorAtualizado = new Coordenador(id, nome, email, login, senha);
        coordenadorDAO.atualizarCoordenador(coordenadorAtualizado);

        response.sendRedirect("CoordenadorServlet?action=listar");
    }

    private void excluirCoordenador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        coordenadorDAO.excluirCoordenador(id);
        response.sendRedirect("CoordenadorServlet?action=listar");
    }
}
