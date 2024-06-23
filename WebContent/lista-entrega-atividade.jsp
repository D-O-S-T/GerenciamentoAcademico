<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Entregas de Atividades</title>
</head>
<body>
    <h2>Entregas de Atividades</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Conteúdo</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="atividade" items="${listaAtividades}">
    <tr>
        <td>${atividade.id}</td>
        <td>${atividade.titulo}</td>
        <td>${atividade.conteudo}</td>
        <td>${atividade.dataInicial}</td>
        <td>${atividade.dataFinal}</td>
        <td>
            <form action="EntregaServlet?action=mostrarFormEntrega" method="post" style="display:inline;">
                <input type="hidden" name="atividadeId" value="${atividade.id}">
                <input type="submit" value="Entregar">
            </form>
        </td>
    </tr>
</c:forEach>
            
        </tbody>
    </table>
    <br>
    <button onclick="window.location.href='index-aluno.jsp'">Voltar a Página Inicial</button>
    <button onclick="window.location.href='EntregaServlet?action=listar'">Vizualizar suas Entregas</button>
</body>
</html>
