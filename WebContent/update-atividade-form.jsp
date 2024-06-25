<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Atualizar Atividade</title>
</head>
<body>


	<div class="wrapper">

		<div class="form-container">

			<h2>Atualizar Atividade</h2>

			<form action="AtividadeServlet?action=atualizar" method="post">
				<input type="hidden" name="id" value="${atividade.id}">
				Título: <input type="text" name="titulo" value="${atividade.titulo}"><br>
				Conteúdo:
				<textarea name="conteudo">${atividade.conteudo}</textarea>
				<br> Data Inicial: <input type="date" name="dataInicial"
					value="${atividade.dataInicial}"><br> Data Final: <input
					type="date" name="dataFinal" value="${atividade.dataFinal}"><br>

				<input type="submit" value="Atualizar">
				<br>
				 <a href="FeedbackAlunoServlet?action=listar">Cancelar</a>
			</form>
			
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>

</body>
</html>


