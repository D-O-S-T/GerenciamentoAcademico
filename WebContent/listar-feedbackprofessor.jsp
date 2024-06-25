<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/png" sizes="16x16" href="imagens/favicon-undf.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/pagina-padrao.css">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Listagem de Feedbacks de Professores</title>
</head>
<body>
	<%@ include file="componentes/sidebar-professor.jsp" %>
	<%@ include file="componentes/nav.jsp" %>
	
	 <div class="wrapper">
        <div class="container">
    		<h2>Listagem de Feedbacks de Professores</h2>
    		<button class="button-custom" onclick="window.location.href='feedbackprofessor-form.jsp'">Adicionar Feedback</button>
    
		    <table border="1">
		        <thead>
		            <tr>
		                <th>Título</th>
		                <th>Feedback</th>
		               
		                <th>Nome do Aluno</th>
		                <th>Ações</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="feedback" items="${listaFeedbacks}">
		                <tr>
		                    
		                    <td>${feedback.titulo}</td>
		                    <td>${feedback.feedback}</td>
		                    <td>${feedback.alunoNome}</td>                    
		                    <td>
		                        <a href="FeedbackProfessorServlet?action=editar&id=${feedback.id}">Editar</a>
		                        <a href="FeedbackProfessorServlet?action=excluir&id=${feedback.id}">Excluir</a>
		                    </td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
    		<button class="button-custom button-secondary" onclick="window.location.href='index-professor.jsp'">Voltar</button>
    	</div>
    </div>
     <%@ include file="componentes/footer.jsp" %>
</body>
</html>
