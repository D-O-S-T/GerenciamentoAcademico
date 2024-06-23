<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Feedback do Aluno</title>
</head>
<body>
    <h1>Formulário de Feedback do Aluno</h1>
    
    <!-- Verificar se existe uma mensagem de erro e exibi-la -->
    <c:if test="${not empty erro}">
        <p style="color:red;">${erro}</p>
    </c:if>
    
    <form action="FeedbackAlunoServlet?action=inserir" method="post">
        <!-- Título do Feedback -->
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo"><br><br>
        
        <!-- Feedback -->
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" rows="5" cols="40"></textarea><br><br>
        
        <!-- Professor ID (pode ser um select ou um campo de texto, dependendo do seu caso) -->
        <label for="professorId">ID do Professor:</label>
        <input type="text" id="professorId" name="professorId"><br><br>
        
        <!-- Campo Escondido para Aluno ID -->
        <input type="hidden" id="alunoId" name="alunoId" value="${sessionScope.alunoId}">
        
        <!-- Botão Enviar -->
        <input type="submit" value="Enviar">
    </form>
</body>
</html>

