<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Atividade</title>
</head>
<body>
    <h2>Editar Atividade</h2>

    <form action="AtividadeServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${atividade.id}">

        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" value="${atividade.titulo}" required><br><br>

        <%-- Conteúdo --%>
        <label for="conteudo">Conteúdo:</label><br>
        <input type="text" id="conteudo" name="conteudo" value="${atividade.conteudo}" required><br><br>

        <%-- Data Inicial --%>
        <label for="dataInicial">Data Inicial:</label><br>
        <input type="date" id="dataInicial" name="dataInicial" value="${atividade.dataInicial}" required><br><br>

        <%-- Data Final --%>
        <label for="dataFinal">Data Final:</label><br>
        <input type="date" id="dataFinal" name="dataFinal" value="${atividade.dataFinal}" required><br><br>

        <%-- Professor (combobox) --%>
        <label for="professorId">Professor:</label><br>
        <select id="professorId" name="professorId" required>
            <option value="">Selecione um Professor</option>
            <c:forEach var="professor" items="${listaProfessores}">
                <option value="${professor.id}" ${professor.id == atividade.professorId ? 'selected' : ''}>${professor.nome}</option>
            </c:forEach>
        </select><br><br>

        <%-- Aluno Bolsista (combobox) --%>
        <label for="alunoBolsistaId">Aluno Bolsista:</label><br>
        <select id="alunoBolsistaId" name="alunoBolsistaId">
            <option value="">Selecione um Aluno Bolsista</option>
            <c:forEach var="aluno" items="${listaAlunos}">
                <option value="${aluno.id}" ${aluno.id == atividade.alunoBolsistaId ? 'selected' : ''}>${aluno.nome}</option>
            </c:forEach>
        </select><br><br>

        <%-- Aluno Voluntário (combobox) --%>
        <label for="alunoVoluntarioId">Aluno Voluntário:</label><br>
        <select id="alunoVoluntarioId" name="alunoVoluntarioId">
            <option value="">Selecione um Aluno Voluntário</option>
            <c:forEach var="aluno" items="${listaAlunos}">
                <option value="${aluno.id}" ${aluno.id == atividade.alunoVoluntarioId ? 'selected' : ''}>${aluno.nome}</option>
            </c:forEach>
        </select><br><br>

        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Atualizar">
    </form>

    <br>
    <a href="AtividadeServlet?action=listar">Cancelar</a>
</body>
</html>

