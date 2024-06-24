<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Entregas dos Alunos</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Lista de Entregas dos Alunos</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Conteúdo</th>
                <th>Data de Entrega</th>
                <th>ID do Aluno</th>
                <th>ID da Atividade</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entrega" items="${listaEntregas}">
                <tr>
                    <td>${entrega.id}</td>
                    <td>${entrega.conteudo}</td>
                    <td>${entrega.dataEntrega}</td>
                    <td>${entrega.alunoDaEntregaId}</td>
                    <td>${entrega.atividadeId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button onclick="window.location.href='AtividadeServlet?action=listar'">Voltar a Página de Atividades</button>
</body>
</html>
