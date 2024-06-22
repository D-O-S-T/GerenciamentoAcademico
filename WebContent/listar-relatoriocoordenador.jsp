<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Relatórios de Coordenador</title>
</head>
<body>
    <h2>Listagem de Relatórios de Coordenador</h2>
    <button onclick="window.location.href='relatoriocoordenador-form.jsp'">Adicionar Novo Relatório</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Relatório</th>
                <th>Coordenador</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="relatorio" items="${listaRelatorios}">
                <tr>
                    <td>${relatorio.id}</td>
                    <td>${relatorio.titulo}</td>
                    <td>${relatorio.relatorio}</td>
                    <td>${relatorio.coordenadorId}</td> <!-- Exemplo: exibindo apenas o ID do coordenador -->
                    <td>
                        <a href="RelatorioCoordenadorServlet?action=editar&id=${relatorio.id}">Editar</a>
                        <a href="RelatorioCoordenadorServlet?action=excluir&id=${relatorio.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar à Página Inicial</button>
</body>
</html>






