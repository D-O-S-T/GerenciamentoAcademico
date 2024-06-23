<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Aluno" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Projeto" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.AlunoDAO" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.dao.ProfessorDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Feedback do Aluno</title>
</head>
<body>
    <h1>Formulário de Feedback do Aluno</h1>
    
    <!-- Verificar se existe uma mensagem de erro e exibi-la -->
    <c:if test="${not empty erro}">
        <p style="color:red;">${erro}</p>
    </c:if>
    
    <form action="FeedbackAlunoServlet?action=inserir" method="post">
        <!-- Título do Feedback -->
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo"><br><br>
        
        <!-- Feedback -->
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" rows="5" cols="40"></textarea><br><br>
        
       <%-- Professor (combobox) --%>
        <label for="professorId">Professor:</label><br>
        <select id="professorId" name="professorId" required>
            <option value="">Selecione um Professor</option>
            <%
                ProfessorDAO professorDAO = new ProfessorDAO();
                List<Professor> listaProfessores = professorDAO.getTodosProfessores();
                for (Professor professor : listaProfessores) {
            %>
                <option value="<%= professor.getId() %>"><%= professor.getNome() %></option>
            <%
                }
            %>
        </select><br><br>
        
        <!-- Campo Escondido para Aluno ID -->
        <input type="hidden" id="alunoId" name="alunoId" value="${sessionScope.usuarioId}">
        
        <!-- Botão Enviar -->
        <input type="submit" value="Enviar">
    </form>
</body>
</html>

