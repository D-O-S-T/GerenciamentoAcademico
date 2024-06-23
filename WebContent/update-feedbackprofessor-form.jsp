<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Feedback do Professor</title>
</head>
<body>
    <h2>Atualizar Feedback do Professor</h2>
    
    <form action="FeedbackProfessorServlet?action=atualizar" method="post">
        <input type="hidden" name="id" value="${feedback.id}">
        
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="${feedback.titulo}"><br><br>
        
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" rows="5" cols="50">${feedback.feedback}</textarea><br><br>
        
        <label for="alunoId">Aluno:</label>
        <select id="alunoId" name="alunoId">
            <c:forEach var="aluno" items="${listaAlunos}">
                <option value="${aluno.id}" ${aluno.id == feedback.alunoId ? 'selected' : ''}>${aluno.nome}</option>
            </c:forEach>
        </select><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="FeedbackProfessorServlet?action=listar">Voltar para a Listagem</a>
</body>
</html>
