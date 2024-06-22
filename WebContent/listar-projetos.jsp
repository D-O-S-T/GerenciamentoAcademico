<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listar Projetos</title>
</head>
<body>
    <h2>Listar Projetos</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Título</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Professor</th>
                <th>Aluno Bolsista</th>
                <th>Aluno Voluntário</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="projeto" items="${listaProjetos}">
                <tr>
                    <td>${projeto.titulo}</td>
                    <td>${projeto.dataInicial}</td>
                    <td>${projeto.dataFinal}</td>
                    <td>${projeto.professor.nome}</td>
                    <td>${projeto.alunoBolsista.nome}</td>
                    <td>${projeto.alunoVoluntario.nome}</td>
                    <td>
                        <a href="ProjetoServlet?action=editar&id=${projeto.id}">Editar</a> |
                        <a href="ProjetoServlet?action=excluir&id=${projeto.id}" onclick="return confirm('Tem certeza que deseja excluir este projeto?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

