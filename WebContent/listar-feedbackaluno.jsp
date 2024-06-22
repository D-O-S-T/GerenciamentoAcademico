<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.FeedbackAluno" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedbacks do Aluno</title>
</head>
<body>
    <h2>Feedbacks do Aluno</h2>
    
    <%
        // Recupera a lista de feedbacks da requisição
        List<FeedbackAluno> listaFeedbacks = (List<FeedbackAluno>) request.getAttribute("listaFeedbacks");
        
        if (listaFeedbacks != null && !listaFeedbacks.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Feedback</th>
                <th>Professor</th>
            </tr>
            <%
                // Itera sobre a lista de feedbacks e exibe cada um
                for (FeedbackAluno feedback : listaFeedbacks) {
            %>
            <tr>
                <td><%= feedback.getId() %></td>
                <td><%= feedback.getTitulo() %></td>
                <td><%= feedback.getFeedback() %></td>
                <td><%= feedback.getProfessorNome() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>Nenhum feedback encontrado para este aluno.</p>
    <%
        }
    %>

    <br>
    <a href="feedbackaluno-form.jsp">Adicionar Novo Feedback</a>
</body>
</html>

