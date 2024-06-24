<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Relatórios de Coordenador</title>
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<div style="display: flex">
	<%@ include file="componentes/sidebar.jsp" %>
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
    </div>
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar à Página Inicial</button>
    
    <%@ include file="componentes/footer.jsp" %>
    
</body>
</html>






