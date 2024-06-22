<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Projeto</title>
</head>
<body>
    <h2>Formulário de Projeto</h2>
    <form action="ProjetoServlet?action=inserir" method="post">
        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>

        <%-- Conteúdo --%>
        <label for="conteudo">Conteúdo:</label><br>
        <input type="text" id="conteudo" name="conteudo" required><br><br>

        <%-- Data Inicial --%>
        <label for="dataInicial">Data Inicial:</label><br>
        <input type="date" id="dataInicial" name="dataInicial" required><br><br>

        <%-- Data Final --%>
        <label for="dataFinal">Data Final:</label><br>
        <input type="date" id="dataFinal" name="dataFinal" required><br><br>

        <%-- Professor (combobox) --%>
        <label for="professorId">Professor:</label><br>
        <select id="professorId" name="professorId" required>
            <option value="">Selecione um Professor</option>
            <%
                ProfessorDAO professorDAO = new ProfessorDAO();
                List<Professor> listaProfessores = professorDAO.getTodosProfessores();
                for (Professor professor : listaProfessores) {
            %>
                <option value="<%= professor.getId() %>"><%= professor.getNome() %></option>
            <%
                }
            %>
        </select><br><br>

        <%-- Aluno Bolsista (combobox) --%>
        <label for="alunoBolsistaId">Aluno Bolsista:</label><br>
        <select id="alunoBolsistaId" name="alunoBolsistaId">
            <option value="">Selecione um Aluno Bolsista</option>
            <%
                AlunoDAO alunoDAO = new AlunoDAO();
                List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();
                for (Aluno aluno : listaAlunos) {
            %>
                <option value="<%= aluno.getId() %>"><%= aluno.getNome() %></option>
            <%
                }
            %>
        </select><br><br>

        <%-- Aluno Voluntário (combobox) --%>
        <label for="alunoVoluntarioId">Aluno Voluntário:</label><br>
        <select id="alunoVoluntarioId" name="alunoVoluntarioId">
            <option value="">Selecione um Aluno Voluntário</option>
            <%
                for (Aluno aluno : listaAlunos) {
            %>
                <option value="<%= aluno.getId() %>"><%= aluno.getNome() %></option>
            <%
                }
            %>
        </select><br><br>

        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>

