package com.exemplo.gerenciamentoacademico.jdbc;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.AtividadeDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Atividade;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

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
        Date dataInicial = Date.valueOf(request.getParameter("dataInicial"));
        Date dataFinal = Date.valueOf(request.getParameter("dataFinal"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        Atividade novaAtividade = new Atividade(titulo, conteudo, dataInicial, dataFinal, professorId, alunoBolsistaId, alunoVoluntarioId);
        atividadeDAO.adicionarAtividade(novaAtividade);

        response.sendRedirect("AtividadeServlet?action=listar");
    }

    private void editarAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Atividade atividade = atividadeDAO.getAtividadePorId(id);

        // Obtém listas de professores e alunos do banco de dados
        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();

        request.setAttribute("atividade", atividade);
        request.setAttribute("listaProfessores", listaProfessores);
        request.setAttribute("listaAlunos", listaAlunos);

        request.getRequestDispatcher("update-atividade-form.jsp").forward(request, response);
    }

    private void atualizarAtividade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Date dataInicial = Date.valueOf(request.getParameter("dataInicial"));
        Date dataFinal = Date.valueOf(request.getParameter("dataFinal"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        Atividade atividadeAtualizada = new Atividade(id, titulo, conteudo, dataInicial, dataFinal, professorId, alunoBolsistaId, alunoVoluntarioId);
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
