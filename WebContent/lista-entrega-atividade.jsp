<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
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
    
    
    <%@ include file="componentes/footer.jsp" %>
</body>
</html>
