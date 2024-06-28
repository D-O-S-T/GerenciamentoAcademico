<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/componentes.css">
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/pagina-padrao.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Formulário de Entrega</title>
</head>
<body>

	<%@ include file="componentes/sidebar-aluno.jsp"%>

	<div class="wrapper">
		<div class="container">
			<div class="form-container">

				<h1>Formulário de Entrega</h1>

				<form action="EntregaServlet?action=inserir" method="post">
					<input type="hidden" name="atividadeId" value="${atividadeId}">
					<!-- outros campos do formulário -->
					<label for="conteudo">Conteúdo:</label><br>
					<textarea id="conteudo" name="conteudo" rows="4" cols="50"></textarea>
					<br> <input type="submit" value="Enviar Entrega">
				</form>

				<br>
				<button class="button-custom button-secondary"
					onclick="window.location.href='AtividadeServlet?action=listarPorAluno'">Voltar</button>
			</div>
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>

</body>
</html>
