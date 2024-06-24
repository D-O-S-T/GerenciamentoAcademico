<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Atividades</title>
</head>
<body>
    <h2>Listagem de Atividades</h2>
    
    <form action="AtividadeServlet" method="GET">
        <button type="submit">Adicionar Nova Atividade</button>
        <input type="hidden" name="action" value="mostrarFormInsercao">
    </form>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Conteúdo</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Projeto</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="atividade" items="${listaAtividades}">
                <tr>
                    <td>${atividade.id}</td>
                    <td>${atividade.titulo}</td>
                    <td>${atividade.conteudo}</td>
                    <td><fmt:formatDate value="${atividade.dataInicial}" pattern="dd/MM/yyyy" /></td>
                    <td><fmt:formatDate value="${atividade.dataFinal}" pattern="dd/MM/yyyy" /></td>
                    <td>${atividade.projetoTitulo}</td>
                    <td>
                        <a href="AtividadeServlet?action=editar&id=${atividade.id}">Editar</a>
                        <a href="AtividadeServlet?action=excluir&id=${atividade.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <button onclick="window.location.href='index-professor.jsp'">Voltar a Página Inicial</button>
</body>
</html>
