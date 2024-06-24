<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioCoordenador"%>
<%@ page
	import="com.exemplo.gerenciamentoacademico.jdbc.model.Coordenador"%>
<%@ page
	import="com.exemplo.gerenciamentoacademico.jdbc.dao.CoordenadorDAO"%>
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
<title>Editar Relatório do Coordenador</title>
</head>
<body>

	<%@ include file="componentes/sidebar.jsp"%>

	<div class="wrapper">

		<div class="form-container">

			<h2>Editar Relatório do Coordenador</h2>

			<form action="RelatorioCoordenadorServlet" method="POST">
				<input type="hidden" name="action" value="atualizar"> <input
					type="hidden" name="id" value="${relatorio.id}">

				<%-- Título --%>
				<label for="titulo">Título:</label><br> <input type="text"
					id="titulo" name="titulo" value="${relatorio.titulo}" required><br>
				<br>

				<%-- Relatório --%>
				<label for="relatorio">Relatório:</label><br>
				<textarea id="relatorio" name="relatorio" rows="4" cols="50"
					required>${relatorio.relatorio}</textarea>
				<br>
				<br>

				<%-- Coordenador (combobox) --%>
				<label for="coordenadorId">Coordenador:</label><br> <select
					id="coordenadorId" name="coordenadorId" required>
					<option value="">Selecione um Coordenador</option>
					<%
					RelatorioCoordenador relatorio = new RelatorioCoordenador();
					CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
					List<Coordenador> listaCoordenadores = coordenadorDAO.getTodosCoordenadores();
					for (Coordenador coordenador : listaCoordenadores) {
					%>
					<option value="<%=coordenador.getId()%>"
						<%=(coordenador.getId() == relatorio.getCoordenadorId()) ? "selected" : ""%>><%=coordenador.getNome()%></option>
					<%
					}
					%>
				</select><br>
				<br>

				<%-- Botão para enviar o formulário --%>
				<input type="submit" value="Atualizar">
			</form>

			<br> <a href="RelatorioCoordenadorServlet?action=listar">Cancelar</a>
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>


</body>
</html>



