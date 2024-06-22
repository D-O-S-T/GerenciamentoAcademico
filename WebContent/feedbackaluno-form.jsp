<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Feedback de Aluno</title>
</head>
<body>
    <h2>Formulário de Feedback de Aluno</h2>
    <form action="FeedbackAlunoServlet?action=inserir" method="post">
        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>

        <%-- Feedback --%>
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" rows="4" cols="50" required></textarea><br><br>

        <%-- Aluno (combobox) --%>
        <label for="alunoId">Aluno:</label><br>
        <select id="alunoId" name="alunoId" required>
            <option value="">Selecione um Aluno</option>
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

        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
