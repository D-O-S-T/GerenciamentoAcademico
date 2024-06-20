<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exemplo.gerenciamentoacademico.jdbc.model.Professor" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Professores</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .add-btn {
            display: block;
            width: 150px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #5cb85c;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .add-btn:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Lista de Professores</h2>

<a href="professor-form.jsp" class="add-btn">Adicionar Professor</a>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Área de Atuação</th>
            <th>Email</th>
            <th>Lattes</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Professor> professores = (List<Professor>) request.getAttribute("professores");
            if (professores != null) {
                for (Professor professor : professores) {
        %>
        <tr>
            <td><%= professor.getId() %></td>
            <td><%= professor.getNome() %></td>
            <td><%= professor.getAreaAtuacao() %></td>
            <td><%= professor.getEmail() %></td>
            <td><%= professor.getLattes() %></td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

</body>
</html>
