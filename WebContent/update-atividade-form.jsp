<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Projeto" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO" %>
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
        <textarea id="conteudo" name="conteudo" rows="4" cols="50" required>${atividade.conteudo}</textarea><br><br>

        <%-- Data Inicial --%>
        <label for="dataInicial">Data Inicial:</label><br>
        <input type="date" id="dataInicial" name="dataInicial" value="${atividade.dataInicial}" required><br><br>

        <%-- Data Final --%>
        <label for="dataFinal">Data Final:</label><br>
        <input type="date" id="dataFinal" name="dataFinal" value="${atividade.dataFinal}" required><br><br>
 <%-- Projeto (combobox) --%>
        <label for="projetoId">Projeto:</label><br>
        <select id="projetoId" name="projetoId" required>
            <option value="">Selecione um Projeto</option>
            <%
                ProjetoDAO projetoDAO = new ProjetoDAO();
                List<Projeto> listaProjetos = projetoDAO.getTodosProjetos();
                for (Projeto projeto : listaProjetos) {
            %>
                <option value="<%= projeto.getId() %>"><%= projeto.getTitulo() %></option>
            <%
                }
            %>
        </select><br><br>

        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Atualizar">
    </form>

    <br>
    <a href="AtividadeServlet?action=listar">Cancelar</a>
</body>
</html>

