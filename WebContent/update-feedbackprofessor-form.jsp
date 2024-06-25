<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="imagens/favicon-undf.png">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/componentes.css">
<link rel="stylesheet" href="css/form.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Atualizar Feedback do Professor</title>
</head>
<body>

	<!-- COLOCAR A SIDEBAR REFERENTE A PROFESSOR -->

	<div class="wrapper">

		<div class="form-container">

			<h2>Atualizar Feedback do Professor</h2>

			<form action="FeedbackProfessorServlet?action=atualizar"
				method="post">
				<input type="hidden" name="id" value="${feedback.id}"> <label
					for="titulo">Título:</label> <input type="text" id="titulo"
					name="titulo" value="${feedback.titulo}"><br>
				<br> <label for="feedback">Feedback:</label><br>
				<textarea id="feedback" name="feedback" rows="5" cols="50">${feedback.feedback}</textarea>
				<br>
				<br> <label for="alunoId">Aluno:</label> <select id="alunoId"
					name="alunoId">
					<c:forEach var="aluno" items="${listaAlunos}">
						<option value="${aluno.id}"
							${aluno.id == feedback.alunoId ? 'selected' : ''}>${aluno.nome}</option>
					</c:forEach>
				</select><br>
				<br> <input type="submit" value="Atualizar">
			</form>

			<br> <a href="FeedbackProfessorServlet?action=listar">Voltar
				para a Listagem</a>
		</div>
	</div>
		<%@ include file="componentes/footer.jsp"%>
</body>
</html>
