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
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;

@WebServlet("/ProjetoServlet")
public class ProjetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetoDAO projetoDAO;

    public void init() {
        projetoDAO = new ProjetoDAO();
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
                listarProjetos(request, response);
                break;
            case "inserir":
                inserirProjeto(request, response);
                break;
            case "editar":
                editarProjeto(request, response);
                break;
            case "atualizar":
                atualizarProjeto(request, response);
                break;
            case "excluir":
                excluirProjeto(request, response);
                break;
            default:
                listarProjetos(request, response);
        }
    }

    private void listarProjetos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Projeto> listaProjetos = projetoDAO.getTodosProjetos();
        request.setAttribute("listaProjetos", listaProjetos);
        request.getRequestDispatcher("listar-projetos.jsp").forward(request, response);
    }

    private void inserirProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Date dataInicial = Date.valueOf(request.getParameter("dataInicial"));
        Date dataFinal = Date.valueOf(request.getParameter("dataFinal"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        Projeto novoProjeto = new Projeto(titulo, conteudo, dataInicial, dataFinal, professorId, alunoBolsistaId, alunoVoluntarioId);
        projetoDAO.adicionarProjeto(novoProjeto);

        response.sendRedirect("ProjetoServlet?action=listar");
    }

    private void editarProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projeto projeto = projetoDAO.getProjetoPorId(id);

        // Obtém listas de professores e alunos do banco de dados
        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();

        request.setAttribute("projeto", projeto);
        request.setAttribute("listaProfessores", listaProfessores);
        request.setAttribute("listaAlunos", listaAlunos);

        request.getRequestDispatcher("update-projeto-form.jsp").forward(request, response);
    }

    private void atualizarProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Date dataInicial = Date.valueOf(request.getParameter("dataInicial"));
        Date dataFinal = Date.valueOf(request.getParameter("dataFinal"));
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        Projeto projetoAtualizado = new Projeto(id, titulo, conteudo, dataInicial, dataFinal, professorId, alunoBolsistaId, alunoVoluntarioId);
        projetoDAO.atualizarProjeto(projetoAtualizado);

        response.sendRedirect("ProjetoServlet?action=listar");
    }

    private void excluirProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projetoDAO.excluirProjeto(id);
        response.sendRedirect("ProjetoServlet?action=listar");
    }
}

