<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Entregas</title>
</head>
<body>
    <h2>Listagem de Entregas</h2>
    <button onclick="window.location.href='entrega-form.jsp'">Adicionar Nova Entrega</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Conteúdo</th>
                <th>Data de Entrega</th>
                <th>Aluno</th>
                <th>Atividade</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entrega" items="${listaEntregas}">
                <tr>
                    <td>${entrega.id}</td>
                    <td>${entrega.conteudo}</td>
                    <td>${entrega.dataEntrega}</td>
                    <td>${entrega.alunoNome}</td>
                    <td>${entrega.atividadeTitulo}</td>
                    <td>
                        <a href="EntregaServlet?action=editar&id=${entrega.id}">Editar</a>
                        <a href="EntregaServlet?action=excluir&id=${entrega.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <button onclick="window.location.href='index-aluno.jsp'">Voltar a Página Inicial</button>
</body>
</html>
