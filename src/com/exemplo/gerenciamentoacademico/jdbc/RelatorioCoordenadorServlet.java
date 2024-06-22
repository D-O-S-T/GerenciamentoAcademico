package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.RelatorioCoordenadorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioCoordenador;

@WebServlet("/RelatorioCoordenadorServlet")
public class RelatorioCoordenadorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RelatorioCoordenadorDAO relatorioCoordenadorDAO;

    public void init() {
        relatorioCoordenadorDAO = new RelatorioCoordenadorDAO();
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
                listarRelatorios(request, response);
                break;
            case "inserir":
                inserirRelatorio(request, response);
                break;
            case "editar":
                editarRelatorio(request, response);
                break;
            case "atualizar":
                atualizarRelatorio(request, response);
                break;
            case "excluir":
                excluirRelatorio(request, response);
                break;
            default:
                listarRelatorios(request, response);
        }
    }

    private void listarRelatorios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<RelatorioCoordenador> listaRelatorios = relatorioCoordenadorDAO.getTodosRelatorios();
        request.setAttribute("listaRelatorios", listaRelatorios);
        request.getRequestDispatcher("listar-relatoriocoordenador.jsp").forward(request, response);
    }

    private void inserirRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String relatorio = request.getParameter("relatorio");
        int coordenadorId = Integer.parseInt(request.getParameter("coordenadorId"));

        RelatorioCoordenador novoRelatorio = new RelatorioCoordenador(titulo, relatorio, coordenadorId);
        relatorioCoordenadorDAO.adicionarRelatorioCoordenador(novoRelatorio);

        response.sendRedirect("RelatorioCoordenadorServlet?action=listar");
    }

    private void editarRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RelatorioCoordenador relatorio = relatorioCoordenadorDAO.getRelatorioPorId(id);
        
        if (relatorio != null) {
            request.setAttribute("relatorio", relatorio); // Configura o atributo relatorio na requisição
            request.getRequestDispatcher("update-relatoriocoordenador-form.jsp").forward(request, response);
        } else {
            // Tratar o caso em que o relatório não foi encontrado
            response.sendRedirect("RelatorioCoordenadorServlet?action=listar");
        }
    }



    private void atualizarRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String relatorio = request.getParameter("relatorio");
        int coordenadorId = Integer.parseInt(request.getParameter("coordenadorId"));

        RelatorioCoordenador relatorioAtualizado = new RelatorioCoordenador(id, titulo, relatorio, coordenadorId);
        relatorioCoordenadorDAO.atualizarRelatorioCoordenador(relatorioAtualizado);

        response.sendRedirect("RelatorioCoordenadorServlet?action=listar");
    }

    private void excluirRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        relatorioCoordenadorDAO.excluirRelatorioCoordenador(id);
        response.sendRedirect("RelatorioCoordenadorServlet?action=listar");
    }
}

