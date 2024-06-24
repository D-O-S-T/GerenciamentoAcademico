<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
    <meta charset="UTF-8">
    <title>Feedbacks do Aluno</title>
</head>
<body>
    <h2>Feedbacks do Aluno</h2>

    <c:choose>
        <c:when test="${not empty listaFeedbacksAluno}">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Feedback</th>
                        <th>Nome do Professor</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="feedback" items="${listaFeedbacksAluno}">
                        <tr>
                            <td>${feedback.id}</td>
                            <td>${feedback.titulo}</td>
                            <td>${feedback.feedback}</td>
                            <td>${feedback.professorNome}</td>
                            <td>
                                <a href="FeedbackAlunoServlet?action=editar&id=${feedback.id}">Editar</a>
                                <a href="FeedbackAlunoServlet?action=excluir&id=${feedback.id}">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>Nenhum feedback encontrado para este aluno.</p>
        </c:otherwise>
    </c:choose>

    <br>
    <button onclick="window.location.href='feedbackaluno-form.jsp'">Adicionar Novo Feedback</button>
    <button onclick="window.location.href='index-aluno.jsp'">Voltar</button>
</body>
</html>
