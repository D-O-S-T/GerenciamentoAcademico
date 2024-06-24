<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Editar Relatório de Professor</title>
</head>
<body>
	<div class="wrapper">
		<%@ include file="componentes/sidebar.jsp"%>
		<div class="form-content">
			<h2>Editar Relatório de Professor</h2>

			<form action="RelatorioProfessorServlet" method="POST">
				<input type="hidden" name="action" value="atualizar"> <input
					type="hidden" name="id" value="${relatorioProfessor.id}"> <label>Título:</label>
				<input type="text" name="titulo"
					value="${relatorioProfessor.titulo}" required><br> <br>
				<label>Relatório:</label>
				<textarea name="relatorio" rows="4" cols="50" required>${relatorioProfessor.relatorio}</textarea>
				<br> <br> <label>ID do Professor:</label> <input
					type="number" name="professor_id"
					value="${relatorioProfessor.professorId}" required><br>
				<br> <input type="submit" value="Atualizar">
			</form>

			<br> <a href="RelatorioProfessorServlet?action=listar">Cancelar</a>
		</div>

	</div>
	<%@ include file="componentes/footer.jsp"%>
</body>
</html>
