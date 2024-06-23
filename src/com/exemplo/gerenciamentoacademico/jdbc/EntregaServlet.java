package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exemplo.gerenciamentoacademico.jdbc.dao.EntregaDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.AtividadeDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Entrega;
import com.exemplo.gerenciamentoacademico.jdbc.model.Atividade;

@WebServlet("/EntregaServlet")
public class EntregaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntregaDAO entregaDAO;
    private AtividadeDAO atividadeDAO;

    public void init() {
        entregaDAO = new EntregaDAO();
        atividadeDAO = new AtividadeDAO();
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

        try {
            switch (action) {
                case "listar":
                    listarEntregas(request, response);
                    break;
                case "mostrarFormInsercao":
                    mostrarFormInsercao(request, response);
                    break;
                case "inserir":
                    inserirEntrega(request, response);
                    break;
                case "editar":
                    editarEntrega(request, response);
                    break;
                case "atualizar":
                    atualizarEntrega(request, response);
                    break;
                case "excluir":
                    excluirEntrega(request, response);
                    break;
                default:
                    listarEntregas(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void mostrarFormInsercao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioId") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int usuarioId = (Integer) session.getAttribute("usuarioId");
        List<Atividade> listaAtividades = atividadeDAO.getAtividadesPorProfessor(usuarioId);
        request.setAttribute("listaAtividades", listaAtividades);

        request.getRequestDispatcher("entrega-form.jsp").forward(request, response);
    }

    private void listarEntregas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioId") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int usuarioId = (Integer) session.getAttribute("usuarioId");
        List<Entrega> listaEntregas = entregaDAO.getEntregasPorProfessor(usuarioId);
        request.setAttribute("listaEntregas", listaEntregas);
        request.getRequestDispatcher("listar-entregas.jsp").forward(request, response);
    }

    private void inserirEntrega(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioId") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int usuarioId = (Integer) session.getAttribute("usuarioId");

        String conteudo = request.getParameter("conteudo");
        LocalDate dataEntrega = LocalDate.parse(request.getParameter("dataEntrega"));
        int alunoDaEntregaId = Integer.parseInt(request.getParameter("alunoDaEntregaId"));
        int atividadeId = Integer.parseInt(request.getParameter("atividadeId"));

        Entrega entrega = new Entrega(conteudo, dataEntrega, usuarioId, alunoDaEntregaId, atividadeId);

        try {
            entregaDAO.inserirEntrega(entrega);
            response.sendRedirect("EntregaServlet?action=listar");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("EntregaServlet?action=listar&error=InsertFailed");
        }
    }

    private void editarEntrega(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Entrega entrega = entregaDAO.getEntregaPorId(id);
            List<Atividade> listaAtividades = atividadeDAO.getTodasAtividades();

            request.setAttribute("entrega", entrega);
            request.setAttribute("listaAtividades", listaAtividades);

            request.getRequestDispatcher("update-entrega-form.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("EntregaServlet?action=listar&error=InvalidEntrega");
        }
    }

    private void atualizarEntrega(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioId") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int usuarioId = (Integer) session.getAttribute("usuarioId");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String conteudo = request.getParameter("conteudo");
            LocalDate dataEntrega = LocalDate.parse(request.getParameter("dataEntrega"));
            int alunoDaEntregaId = Integer.parseInt(request.getParameter("alunoDaEntregaId"));
            int atividadeId = Integer.parseInt(request.getParameter("atividadeId"));

            Entrega entregaAtualizada = new Entrega(id, conteudo, dataEntrega, usuarioId, alunoDaEntregaId, atividadeId);
            entregaDAO.atualizarEntrega(entregaAtualizada);

            response.sendRedirect("EntregaServlet?action=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("EntregaServlet?action=editar&id=" + request.getParameter("id") + "&error=UpdateFailed");
        }
    }

    private void excluirEntrega(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            entregaDAO.excluirEntrega(id);
            response.sendRedirect("EntregaServlet?action=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("EntregaServlet?action=listar&error=DeleteFailed");
        }
    }
}
