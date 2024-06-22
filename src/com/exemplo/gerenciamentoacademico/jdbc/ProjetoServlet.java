package com.exemplo.gerenciamentoacademico.jdbc;

import com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO;
import com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO;
import com.exemplo.gerenciamentoacademico.jdbc.model.Aluno;
import com.exemplo.gerenciamentoacademico.jdbc.model.Professor;
import com.exemplo.gerenciamentoacademico.jdbc.model.Projeto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ProjetoServlet")
public class ProjetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetoDAO projetoDAO;
    private ProfessorDAO professorDAO;
    private AlunoDAO alunoDAO;

    public void init() {
        projetoDAO = new ProjetoDAO();
        professorDAO = new ProfessorDAO();
        alunoDAO = new AlunoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Carrega as listas de professores e alunos antes de qualquer ação
      
    

        String action = request.getParameter("action");

        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "listar":
                listarProjetos(request, response);
                break;
            case "inserir":
            	
            	  // Atualiza listas de professores e alunos antes de mostrar o formulário de inserção
                List<Professor> listaProfessores = professorDAO.getTodosProfessores();
                List<Aluno> listaAlunosBolsistas = alunoDAO.getTodosAlunos();
                List<Aluno> listaAlunosVoluntarios = alunoDAO.getTodosAlunos();

                request.setAttribute("listaProfessores", listaProfessores);
                request.setAttribute("listaAlunosBolsistas", listaAlunosBolsistas);
                request.setAttribute("listaAlunosVoluntarios", listaAlunosVoluntarios);

                request.getRequestDispatcher("projeto-form.jsp").forward(request, response);
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

        // Para cada projeto, obter os nomes dos professores e alunos
        for (Projeto projeto : listaProjetos) {
            Professor professor = professorDAO.getProfessorPorId(projeto.getProfessor().getId());
            Aluno bolsista = alunoDAO.getAlunoPorId(projeto.getAlunoBolsista().getId());
            Aluno voluntario = alunoDAO.getAlunoPorId(projeto.getAlunoVoluntario().getId());

            projeto.getProfessor().setNome(professor != null ? professor.getNome() : "Não encontrado");
            projeto.getAlunoBolsista().setNome(bolsista != null ? bolsista.getNome() : "Não encontrado");
            projeto.getAlunoVoluntario().setNome(voluntario != null ? voluntario.getNome() : "Não encontrado");
        }

        request.setAttribute("listaProjetos", listaProjetos);
        request.getRequestDispatcher("listar-projetos.jsp").forward(request, response);
    }

    private void inserirProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String dataInicialStr = request.getParameter("dataInicial");
        String dataFinalStr = request.getParameter("dataFinal");
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicial;
        Date dataFinal;
        try {
            dataInicial = sdf.parse(dataInicialStr);
            dataFinal = sdf.parse(dataFinalStr);
        } catch (ParseException e) {
            throw new ServletException("Erro ao converter data", e);
        }

        // Verifica se os IDs de professor e alunos existem no banco de dados
        Professor professor = professorDAO.getProfessorPorId(professorId);
        Aluno alunoBolsista = alunoDAO.getAlunoPorId(alunoBolsistaId);
        Aluno alunoVoluntario = alunoDAO.getAlunoPorId(alunoVoluntarioId);

        if (professor == null || alunoBolsista == null || alunoVoluntario == null) {
            // Tratamento de erro caso algum dos IDs não exista no banco de dados
            // Você pode redirecionar para uma página de erro ou tratar de outra forma
            response.sendRedirect("erro.jsp");
            return;
        }

        // Cria um novo objeto Projeto com os dados recebidos
        Projeto novoProjeto = new Projeto(titulo, dataInicial, dataFinal, professor, alunoBolsista, alunoVoluntario);

        // Adiciona o projeto ao banco de dados
        projetoDAO.adicionarProjeto(novoProjeto);

        // Atualiza as listas de professores e alunos no contexto do servlet
        List<Professor> listaProfessores = professorDAO.getTodosProfessores();
        List<Aluno> listaAlunosBolsistas = alunoDAO.getTodosAlunos();
        List<Aluno> listaAlunosVoluntarios = alunoDAO.getTodosAlunos();

        getServletContext().setAttribute("listaProfessores", listaProfessores);
        getServletContext().setAttribute("listaAlunosBolsistas", listaAlunosBolsistas);
        getServletContext().setAttribute("listaAlunosVoluntarios", listaAlunosVoluntarios);

        // Redireciona para a página de listagem de projetos após a inserção
        response.sendRedirect("ProjetoServlet?action=listar");
    }

    private void editarProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Projeto projetoExistente = projetoDAO.getProjetoPorId(id);

        request.setAttribute("projeto", projetoExistente);
        request.getRequestDispatcher("editar-projeto.jsp").forward(request, response);
    }

    private void atualizarProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String dataInicialStr = request.getParameter("dataInicial");
        String dataFinalStr = request.getParameter("dataFinal");
        int professorId = Integer.parseInt(request.getParameter("professorId"));
        int alunoBolsistaId = Integer.parseInt(request.getParameter("alunoBolsistaId"));
        int alunoVoluntarioId = Integer.parseInt(request.getParameter("alunoVoluntarioId"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicial;
        Date dataFinal;
        try {
            dataInicial = sdf.parse(dataInicialStr);
            dataFinal = sdf.parse(dataFinalStr);
        } catch (ParseException e) {
            throw new ServletException("Erro ao converter data", e);
        }

        // Verifica se os IDs de professor e alunos existem no banco de dados
        Professor professor = professorDAO.getProfessorPorId(professorId);
        Aluno alunoBolsista = alunoDAO.getAlunoPorId(alunoBolsistaId);
        Aluno alunoVoluntario = alunoDAO.getAlunoPorId(alunoVoluntarioId);

        if (professor == null || alunoBolsista == null || alunoVoluntario == null) {
            // Tratamento de erro caso algum dos IDs não exista no banco de dados
            // Você pode redirecionar para uma página de erro ou tratar de outra forma
            response.sendRedirect("erro.jsp");
            return;
        }

        // Cria um novo objeto Projeto com os dados recebidos
        Projeto projetoAtualizado = new Projeto(id, titulo, dataInicial, dataFinal, professor, alunoBolsista, alunoVoluntario);

        // Atualiza o projeto no banco de dados
        projetoDAO.atualizarProjeto(projetoAtualizado);

        // Redireciona para a página de listagem de projetos após a atualização
        response.sendRedirect("ProjetoServlet?action=listar");
    }

    private void excluirProjeto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        // Exclui o projeto do banco de dados
        projetoDAO.excluirProjeto(id);

        // Redireciona para a página de listagem de projetos após a exclusão
        response.sendRedirect("ProjetoServlet?action=listar");
    }
}
