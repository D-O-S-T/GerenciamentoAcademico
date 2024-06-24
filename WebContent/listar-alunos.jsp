<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Alunos</title>
</head>
<body>
    <h2>Listagem de Alunos</h2>
    <button onclick="window.location.href='aluno-form.jsp'">Adicionar Novo Aluno</button>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Matrícula</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Lattes</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${listaAlunos}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.matricula}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.email}</td>
                    <td>${aluno.lattes}</td>
                    <td>${aluno.login}</td>
                    <td>
                        <a href="AlunoServlet?action=editar&id=${aluno.id}">Editar</a>
                        <a href="AlunoServlet?action=excluir&id=${aluno.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
</body>
</html>
