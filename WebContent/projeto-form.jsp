<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Projeto</title>
</head>
<body>
    <h2>Formulário de Projeto</h2>
    <form action="ProjetoControllerServlet" method="post">
        <input type="hidden" name="command" value="ADD">
        
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required><br><br>
        
        <label for="dataInicial">Data Inicial:</label>
        <input type="date" id="dataInicial" name="dataInicial" required><br><br>
        
        <label for="dataFinal">Data Final:</label>
        <input type="date" id="dataFinal" name="dataFinal" required><br><br>
        
        <label for="qtdAulas">Quantidade de Aulas:</label>
        <input type="number" id="qtdAulas" name="qtdAulas" required><br><br>
        
        <input type="submit" value="Cadastrar Projeto">
    </form>
</body>
</html>
