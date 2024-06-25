<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    
    <meta charset="UTF-8">
    <title>Listagem de Feedbacks de Professores</title>
</head>
<body>
<div class="content-wrapper">
        <%@ include file="componentes/sidebar-aluno.jsp" %>
        <div class="main-content">
            <h2 class="">Listagem de Feedbacks de Professores</h2>
            <table class="tabela" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Feedback</th>
                        <th>ID do Professor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="feedback" items="${listaFeedbacksProfessor}">
                        <tr>
                            <td>${feedback.id}</td>
                            <td>${feedback.titulo}</td>
                            <td>${feedback.feedback}</td>
                            <td>${feedback.professorId}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <button onclick="window.location.href='index-aluno.jsp'">Voltar à Página Inicial</button>
        </div>
    </div>
    <%@ include file="componentes/footer.jsp" %>
    </body>
</html>
