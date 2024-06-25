<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.FeedbackProfessorDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/pagina-padrao.css">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Listagem de Feedbacks de Professores</title>
</head>
<body>
    <h2>Feedbacks recebidos de Professores</h2>
   
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Feedback</th>
                <th>Professor</th>
                <th>Aluno</th>
             
            </tr>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${listaFeedbacksProfessor}">
                <tr>
                    <td>${feedback.id}</td>
                    <td>${feedback.titulo}</td>
                    <td>${feedback.feedback}</td>
                    <td>${feedback.professorNome}</td>
                    <td>${feedback.alunoNome}</td>
                    <td> 
           
          
            </td>
                    
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
</body>
</html>
