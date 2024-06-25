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
<title>Formulário de Coordenador</title>
</head>
<body>

	<%@ include file="componentes/sidebar-coordenador.jsp"%>

	<div class="wrapper">

		<div class="form-container">

			<h2>Formulário de Coordenador</h2>
			<%-- Formulário para inserção e edição de coordenadores --%>
			<form action="CoordenadorServlet?action=inserir" method="post">

				<%-- Nome --%>
				<label for="nome">Nome:</label><br> <input type="text"
					id="nome" name="nome" required><br> <br>

				<%-- E-mail --%>
				<label for="email">E-mail:</label><br> <input type="email"
					id="email" name="email" required><br> <br>

				<%-- Login --%>
				<label for="login">Login:</label><br> <input type="text"
					id="login" name="login" required><br> <br>

				<%-- Senha --%>
				<label for="senha">Senha:</label><br> <input type="password"
					id="senha" name="senha" required><br> <br>

				<%-- Botão para enviar o formulário --%>
				<input type="submit" value="Salvar">
			</form>
		</div>
	</div>
	
		<%@ include file="componentes/footer.jsp"%>
	
</body>
</html>
