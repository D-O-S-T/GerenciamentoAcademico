<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Listar Entregas</title>
    <!-- Adicione seus estilos CSS, se necessário -->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Listar Entregas</h1>
    
    <c:if test="${not empty listaEntregas}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Conteúdo</th>
                    <th>Data de Entrega</th>
                    <th>ID do Professor</th>
                    <th>ID do Aluno</th>
                    <th>ID da Atividade</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entrega" items="${listaEntregas}">
                    <tr>
                        <td>${entrega.id}</td>
                        <td>${entrega.conteudo}</td>
                        <td>${entrega.dataEntrega}</td>
                        <td>${entrega.professorId}</td>
                        <td>${entrega.alunoDaEntregaId}</td>
                        <td>${entrega.atividadeId}</td>
                        <td>
                            <a href="EntregaServlet?action=editar&id=${entrega.id}">Editar</a>
                            <a href="EntregaServlet?action=excluir&id=${entrega.id}">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty listaEntregas}">
        <p>Não há entregas registradas.</p>
    </c:if>
    
    <button onclick="window.location.href='AtividadeServlet?action=listarPorAluno'">Voltar</button>
    <%@ include file="componentes/footer.jsp" %>
</body>
</html>

