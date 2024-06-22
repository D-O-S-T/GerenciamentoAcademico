<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        
        <%-- Data Inicial --%>
        <label for="dataInicial">Data Inicial:</label><br>
        <input type="date" id="dataInicial" name="dataInicial" required><br><br>
        
        <%-- Data Final --%>
        <label for="dataFinal">Data Final:</label><br>
        <input type="date" id="dataFinal" name="dataFinal" required><br><br>
        
        <%-- Seleção de Professor --%>
        <label for="professorId">Selecione o Professor:</label><br>
        <select id="professorId" name="professorId" required>
            <option value="" disabled selected>Escolha um professor</option>
            <c:forEach var="professor" items="${listaProfessores}">
                <option value="${professor.id}">${professor.nome}</option>
            </c:forEach>
        </select><br><br>
        
        <%-- Seleção de Aluno Bolsista --%>
        <label for="alunoBolsistaId">Selecione o Aluno Bolsista:</label><br>
        <select id="alunoBolsistaId" name="alunoBolsistaId" required>
            <option value="" disabled selected>Escolha um aluno bolsista</option>
            <c:forEach var="aluno" items="${listaAlunosBolsistas}">
                <option value="${aluno.id}">${aluno.nome}</option>
            </c:forEach>
        </select><br><br>
        
        <%-- Seleção de Aluno Voluntário --%>
        <label for="alunoVoluntarioId">Selecione o Aluno Voluntário:</label><br>
        <select id="alunoVoluntarioId" name="alunoVoluntarioId" required>
            <option value="" disabled selected>Escolha um aluno voluntário</option>
            <c:forEach var="aluno" items="${listaAlunosVoluntarios}">
                <option value="${aluno.id}">${aluno.nome}</option>
            </c:forEach>
        </select><br><br>
        
        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
