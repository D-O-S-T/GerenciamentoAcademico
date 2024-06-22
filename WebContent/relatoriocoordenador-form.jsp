<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Coordenador" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.CoordenadorDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Relatório de Coordenador</title>
</head>
<body>
    <h2>Formulário de Relatório de Coordenador</h2>
    <form action="RelatorioCoordenadorServlet?action=inserir" method="post">
        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>

        <%-- Relatório --%>
        <label for="relatorio">Relatório:</label><br>
        <textarea id="relatorio" name="relatorio" rows="4" cols="50" required></textarea><br><br>

        <%-- Coordenador (combobox) --%>
        <label for="coordenadorId">Coordenador:</label><br>
        <select id="coordenadorId" name="coordenadorId" required>
            <option value="">Selecione um Coordenador</option>
            <%
                CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
                List<Coordenador> listaCoordenadores = coordenadorDAO.getTodosCoordenadores();
                for (Coordenador coordenador : listaCoordenadores) {
            %>
                <option value="<%= coordenador.getId() %>"><%= coordenador.getNome() %></option>
            <%
                }
            %>
        </select><br><br>

        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
