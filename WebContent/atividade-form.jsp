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
<title>Inserir Atividade</title>
</head>
<body>
	<%@ include file="componentes/sidebar-coordenador.jsp"%>
	<%@ include file="componentes/nav.jsp"%>

	<div class="wrapper">
		<div class="container">
			<div class="form-container">
				<h1>Inserir Atividade</h1>
				<form action="AtividadeServlet?action=inserir" method="post">
					<label for="titulo">Título:</label> <input type="text" id="titulo"
						name="titulo" required><br>
					<br> <label for="conteudo">Conteúdo:</label>
					<textarea id="conteudo" name="conteudo" required></textarea>
					<br>
					<br> <label for="dataInicial">Data Inicial:</label> <input
						type="date" id="dataInicial" name="dataInicial" required><br>
					<br> <label for="dataFinal">Data Final:</label> <input
						type="date" id="dataFinal" name="dataFinal" required><br>
					<br> <input type="submit" value="Inserir Atividade">
				</form>
				<a class="button-custom button-secondary" href="AtividadeServlet?action=listar">Voltar</a>
			</div>
		</div>
	</div>
	
	<%@ include file="componentes/footer.jsp" %>
</body>
</html>
