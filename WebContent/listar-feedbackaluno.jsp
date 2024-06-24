<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Feedbacks do Aluno</title>
</head>
<body>
<div style="display:flex; justify-content">
	<%@ include file="componentes/sidebar.jsp" %>
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
     </div>
     <%@ include file="componentes/footer.jsp" %>
</body>
</html>
