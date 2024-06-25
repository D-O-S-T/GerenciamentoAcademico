<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Projeto"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO"%>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/componentes.css">
    <link rel="stylesheet" href="css/form.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Formulário de Feedback do Aluno</title>
</head>
<body>

<%@ include file="componentes/sidebar-aluno.jsp"%>

<div class="wrapper">
    <div class="form-container">
        <h1>Formulário de Feedback do Aluno</h1>

        <!-- Verificar se existe uma mensagem de erro e exibi-la -->
        <c:if test="${not empty erro}">
            <p style="color: red;">${erro}</p>
        </c:if>

        <form action="FeedbackAlunoServlet?action=inserir" method="post">
            <!-- Título do Feedback -->
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required><br>
            <br>

            <!-- Feedback -->
            <label for="feedback">Feedback:</label><br>
            <textarea id="feedback" name="feedback" rows="5" cols="40" required></textarea>
            <br>
            <br>

            <!-- Professor (combobox) -->
            <label for="professorId">Professor:</label><br>
            <select id="professorId" name="professorId" required>
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
            </select><br>
            <br>

            <!-- Campo Escondido para Aluno ID -->
            <input type="hidden" id="alunoId" name="alunoId" value="${sessionScope.usuarioId}">

            <!-- Botão Enviar -->
            <div class="button-container">
                <input type="submit" value="Enviar">
            </div>
        </form>
    </div>
</div>

<%@ include file="componentes/footer.jsp"%>

</body>
</html>
