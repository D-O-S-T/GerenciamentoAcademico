<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Feedbacks de Professores</title>
</head>
<body>
    <h2>Listagem de Feedbacks de Professores</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Feedback</th>
                <th>Aluno</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${listaFeedbacks}">
                <tr>
                    <td>${feedback.id}</td>
                    <td>${feedback.titulo}</td>
                    <td>${feedback.feedback}</td>
                    <td>${feedback.alunoNome}</td> <!-- Mostra o nome do aluno -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <a href="index-coordenador.jsp">Voltar</a>
</body>
</html>
