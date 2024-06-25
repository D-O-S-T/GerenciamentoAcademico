<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Formulário de Relatório do Professor</title>
</head>
<body>
	<%@ include file="componentes/sidebar.jsp"%>
	<div class="wrapper">

		<div class="form-container">
			<h2>Formulário de Relatório do Professor</h2>
			<form action="RelatorioProfessorServlet?action=inserir" method="post">

				<%-- Título --%>
				<label for="titulo">Título:</label><br> <input type="text"
					id="titulo" name="titulo" required><br>
				<br>

				<%-- Relatório --%>
				<label for="relatorio">Relatório:</label><br>
				<textarea id="relatorio" name="relatorio" rows="4" cols="50"
					required></textarea>
				<br>
				<br>

				<%-- Botão para enviar o formulário --%>
				<input type="submit" value="Salvar">
			</form>
		</div>
	</div>
</body>
</html>
