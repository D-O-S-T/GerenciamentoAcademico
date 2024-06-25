<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Projeto"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProjetoDAO"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/form.css">
	<link rel="stylesheet" href="css/pagina-padrao.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Editar Feedback</title>
</head>
<body>
	<%@ include file="componentes/nav.jsp" %>
	<%@ include file="componentes/sidebar-aluno.jsp" %>
	
	<div class="wrapper">
		<div class="container">
			<div class="form-container">
				<h2>Editar Feedback</h2>
				<form action="FeedbackAlunoServlet" method="POST">
					<input type="hidden" name="action" value="atualizar"> <input type="hidden" name="id" value="${feedback.id}">
	
					<%-- Título --%>
					<label for="titulo">Título:</label><br> <input type="text"
						id="titulo" name="titulo" value="${feedback.titulo}" required>
						
					<%-- Feedback --%>
					<label for="feedback">Feedback:</label><br>
					<textarea id="feedback" name="feedback" rows="4" cols="50" required>${feedback.feedback}</textarea>
	
					<%-- Professor (combobox) --%>
					<label for="professorId">Professor:</label><br> <select
						id="professorId" name="professorId" required>
						<option value="">Selecione um Professor</option>
						<%
						ProfessorDAO professorDAO = new ProfessorDAO();
						List<Professor> listaProfessores = professorDAO.getTodosProfessores();
						for (Professor professor : listaProfessores) {
						%>
						<option value="<%=professor.getId()%>"><%=professor.getNome()%></option>
						<%
						}
						%>
					</select>
					
					<!-- (TO-DO) Espaçamento entre combobox e botão feito com <br> por enquanto. Consertar depois -->
					<br/><br/>
	
					<%-- Botão para enviar o formulário --%>
					<input type="submit" value="Atualizar"> 
					<button class="button-custom button-secondary" onclick="window.location.href='FeedbackAlunoServlet?action=listar'">Cancelar</button>
				</form>
			</div>
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>
</body>
</html>
