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
<title>Editar Coordenador</title>
</head>
<body>
	
	<%@ include file="componentes/sidebar.jsp"%>
	
	<div class="wrapper">
		<div class="form-container">
			<h2>Editar Coordenador</h2>

			<form action="CoordenadorServlet" method="POST">
			
				<input type="hidden" name="action" value="atualizar"> <input
					type="hidden" name="id" value="${coordenador.id}"> 
					
				<br> <label>Nome:</label>
				<input type="text" name="nome" value="${coordenador.nome}" required><br>
				
				<br> <label>E-mail:</label> <input type="email" name="email"
					value="${coordenador.email}" required><br>
				
				<br> <label>Login:</label> <input type="text" name="login"
					value="${coordenador.login}" required><br>
				
				<br> <label>Senha:</label> <input type="password" name="senha"
					value="${coordenador.senha}" required><br>
				
				<br> <input type="submit" value="Atualizar">
			</form>

			<br> <a href="CoordenadorServlet?action=listar">Cancelar</a>
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>

</body>
</html>
