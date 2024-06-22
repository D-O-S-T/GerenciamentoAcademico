<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Feedbacks de Aluno</title>
</head>
<body>
    <h2>Listagem de Feedbacks de Aluno</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Feedback</th>
                <th>Aluno</th>
                <th>Professor</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${listaFeedbacks}">
                <tr>
                    <td>${feedback.id}</td>
                    <td>${feedback.titulo}</td>
                    <td>${feedback.feedback}</td>
                    <td>${feedback.alunoNome}</td>
                    <td>${feedback.professorNome}</td>
                    <td>
                        <a href="FeedbackAlunoServlet?action=editar&id=${feedback.id}">Editar</a>
                        <a href="FeedbackAlunoServlet?action=excluir&id=${feedback.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <a href="feedbackaluno-form.jsp">Adicionar Novo Feedback de Aluno</a>
</body>
</html>
