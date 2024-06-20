<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Projeto</title>
</head>
<body>
    <h2>Update Projeto</h2>
    <form action="ProjetoControllerServlet" method="post">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="id" value="${THE_PROJETO.id}">
        
        <label>Título:</label>
        <input type="text" name="titulo" value="${THE_PROJETO.titulo}">
        <br>
        
        <label>Data Inicial:</label>
        <input type="date" name="dataInicial" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${THE_PROJETO.dataInicial}" />">
        <br>
        
        <label>Data Final:</label>
        <input type="date" name="dataFinal" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${THE_PROJETO.dataFinal}" />">
        <br>
        
        <label>Quantidade de Aulas:</label>
        <input type="number" name="qtdAulas" value="${THE_PROJETO.qtdAulas}">
        <br>
        
        <input type="submit" value="Update">
    </form>
</body>
</html>
