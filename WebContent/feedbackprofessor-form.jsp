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
    <title>Formulário de Feedback do Professor</title>
</head>
<body>
    <h1>Formulário de Feedback do Professor</h1>
    
    <!-- Verificar se existe uma mensagem de erro e exibi-la -->
    <c:if test="${not empty erro}">
        <p style="color:red;">${erro}</p>
    </c:if>
    
    <form action="FeedbackProfessorServlet?action=inserir" method="post">
        <!-- Título do Feedback -->
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo"><br><br>
        
        <!-- Feedback -->
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback" rows="5" cols="40"></textarea><br><br>
        
     
        
         <%-- Aluno (combobox) --%>
        <label for="alunoId">Aluno:</label><br>
        <select id="alunoId" name="alunoId" required>
            <option value="">Selecione um Aluno</option>
            <%
                AlunoDAO alunoDAO = new AlunoDAO();
            	
                List<Aluno> listaAlunos = alunoDAO.getTodosAlunos();
                for (Aluno aluno : listaAlunos) {
            %>
                <option value="<%= aluno.getId() %>"><%= aluno.getNome() %></option>
            <%
                }
            %>
        </select><br><br>
        
        <!-- Campo Escondido para Professor ID -->
        <input type="hidden" id="professorId" name="professorId" value="${sessionScope.usuarioId}">
        
        <!-- Botão Enviar -->
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
