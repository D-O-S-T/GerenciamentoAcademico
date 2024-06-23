<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Professores</title>
</head>
<body>
    <h2>Listagem de Professores</h2>
    <button onclick="window.location.href='professor-form.jsp'">Adicionar Novo Professor</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Lattes</th>
                <th>Área de Atuação</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="professor" items="${listaProfessores}">
                <tr>
                    <td>${professor.id}</td>
                    <td>${professor.nome}</td>
                    <td>${professor.email}</td>
                    <td>${professor.lattes}</td>
                    <td>${professor.areaAtuacao}</td>
                    <td>
                        <a href="ProfessorServlet?action=editar&id=${professor.id}">Editar</a>
                        <a href="ProfessorServlet?action=excluir&id=${professor.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
</body>
</html>
