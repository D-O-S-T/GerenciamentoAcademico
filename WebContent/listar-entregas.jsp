<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
</body>
</html>

