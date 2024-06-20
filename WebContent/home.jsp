<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
    <h2>Bem-vindo</h2>
    <c:if test="${not empty sessionScope.usuarioId}">
        <p>Você está logado com o ID: ${sessionScope.usuarioId}</p>
        <a href="SomeActionServlet">Realizar alguma ação</a>
    </c:if>
</body>
</html>
