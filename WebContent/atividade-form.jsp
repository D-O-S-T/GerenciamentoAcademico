<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Projeto" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Atividade</title>
</head>
<body>
    <h2>Formulário de Atividade</h2>
    <form action="AtividadeServlet?action=inserir" method="post">
        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>

        <%-- Conteúdo --%>
        <label for="conteudo">Conteúdo:</label><br>
        <textarea id="conteudo" name="conteudo" rows="4" cols="50" required></textarea><br><br>

        <%-- Data Inicial --%>
        <label for="dataInicial">Data Inicial:</label><br>
        <input type="date" id="dataInicial" name="dataInicial" required><br><br>

        <%-- Data Final --%>
        <label for="dataFinal">Data Final:</label><br>
        <input type="date" id="dataFinal" name="dataFinal" required><br><br>

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
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
