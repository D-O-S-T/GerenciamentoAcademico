<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Relatório do Professor</title>
</head>
<body>
    <h2>Formulário de Relatório do Professor</h2>
    <form action="RelatorioProfessorServlet?action=inserir" method="post">
        
        <%-- Título --%>
        <label for="titulo">Título:</label><br>
        <input type="text" id="titulo" name="titulo" required><br><br>
        
        <%-- Relatório --%>
        <label for="relatorio">Relatório:</label><br>
        <textarea id="relatorio" name="relatorio" rows="4" cols="50" required></textarea><br><br>
        
        <%-- Professor ID --%>
        <label for="professor_id">ID do Professor:</label><br>
        <input type="number" id="professor_id" name="professor_id" required><br><br>
        
        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
