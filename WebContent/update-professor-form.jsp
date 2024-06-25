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
<title>Editar Professor</title>
</head>
<body>

	<%@ include file="componentes/sidebar.jsp"%>

	<div class="wrapper">

		<div class="form-container">

			<h2>Editar Professor</h2>

			<form action="ProfessorServlet" method="POST">
				<input type="hidden" name="action" value="atualizar"> <input
					type="hidden" name="id" value="${professor.id}"> <label>Nome:</label>
				<input type="text" name="nome" value="${professor.nome}" required><br>
				<br> <label>E-mail:</label> <input type="email" name="email"
					value="${professor.email}" required><br>
				<br> <label>Lattes:</label> <input type="text" name="lattes"
					value="${professor.lattes}" required><br>
				<br> <label>Login:</label> <input type="text" name="login"
					value="${professor.login}" required><br>
				<br> <label>Senha:</label> <input type="password" name="senha"
					value="${professor.senha}" required><br>
				<br> <label>Área de Atuação:</label> <input type="text"
					name="areaAtuacao" value="${professor.areaAtuacao}" required><br>
				<br> <input type="submit" value="Atualizar">
			</form>

			<br> <a href="ProfessorServlet?action=listar">Cancelar</a>
		</div>
	</div>
	<%@ include file="componentes/footer.jsp"%>

</body>
</html>
