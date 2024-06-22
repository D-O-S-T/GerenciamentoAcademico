package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.AtividadeDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Atividade;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;

@WebServlet("/AtividadeServlet")
public class AtividadeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AtividadeDAO atividadeDAO;

    public void init() {
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

        switch (action) {
            case "listar":
                listarAtividades(request, response);
                break;
            case "inserir":
                inserirAtividade(request, response);
                break;
            case "editar":
                editarAtividade(request, response);
                break;
            case "atualizar":
                atualizarAtividade(request, response);
                break;
            case "excluir":
                excluirAtividade(request, response);
                break;
            default:
                listarAtividades(request, response);
        }
    }

    private void listarAtividades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Atividade> listaAtividades = atividadeDAO.getTodasAtividades();
        request.setAttribute("listaAtividades", listaAtividades);
        request.getRequestDispatcher("listar-atividades.jsp").forward(request, response);
    }

    private void inserirAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        LocalDate dataInicial = LocalDate.parse(request.getParameter("dataInicial"));
        LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));
        int projetoId = Integer.parseInt(request.getParameter("projetoId"));

        Atividade novaAtividade = new Atividade(titulo, conteudo, dataInicial, dataFinal, projetoId);
        atividadeDAO.adicionarAtividade(novaAtividade);

        response.sendRedirect("AtividadeServlet?action=listar");
    }

    private void editarAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Atividade atividade = atividadeDAO.getAtividadePorId(id);

        // Obtém lista de projetos do banco de dados para o dropdown
        ProjetoDAO projetoDAO = new ProjetoDAO();
        List<Projeto> listaProjetos = projetoDAO.getTodosProjetos();

        request.setAttribute("atividade", atividade);
        request.setAttribute("listaProjetos", listaProjetos);

        request.getRequestDispatcher("update-atividade-form.jsp").forward(request, response);
    }

    private void atualizarAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        LocalDate dataInicial = LocalDate.parse(request.getParameter("dataInicial"));
        LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));
        int projetoId = Integer.parseInt(request.getParameter("projetoId"));

        Atividade atividadeAtualizada = new Atividade(id, titulo, conteudo, dataInicial, dataFinal, projetoId);
        atividadeDAO.atualizarAtividade(atividadeAtualizada);

        response.sendRedirect("AtividadeServlet?action=listar");
    }

    private void excluirAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        atividadeDAO.excluirAtividade(id);
        response.sendRedirect("AtividadeServlet?action=listar");
    }
}
