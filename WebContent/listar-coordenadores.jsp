<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Listagem de Coordenadores</title>
    <link rel="stylesheet" href="css/componentes.css">
</head>
<body>
	<div style="display:flex; justify-content">
	<%@ include file="componentes/sidebar.jsp" %>
    <h2>Listagem de Coordenadores</h2>
    <button onclick="window.location.href='coordenador-form.jsp'">Adicionar Novo Coordenador</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coordenador" items="${listaCoordenadores}">
                <tr>
                    <td>${coordenador.id}</td>
                    <td>${coordenador.nome}</td>
                    <td>${coordenador.email}</td>
                    <td>${coordenador.login}</td>
                    <td>
                        <a href="CoordenadorServlet?action=editar&id=${coordenador.id}">Editar</a>
                        <a href="CoordenadorServlet?action=excluir&id=${coordenador.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
    </div>
</body>
</html>
