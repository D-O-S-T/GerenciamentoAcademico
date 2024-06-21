<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Coordenador</title>
</head>
<body>
    <h2>Editar Coordenador</h2>
    
    <form action="CoordenadorServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${coordenador.id}">
        
        <label>Nome:</label>
        <input type="text" name="nome" value="${coordenador.nome}" required><br><br>
        
        <label>E-mail:</label>
        <input type="email" name="email" value="${coordenador.email}" required><br><br>
        
        <label>Login:</label>
        <input type="text" name="login" value="${coordenador.login}" required><br><br>
        
        <label>Senha:</label>
        <input type="password" name="senha" value="${coordenador.senha}" required><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="CoordenadorServlet?action=listar">Cancelar</a>
</body>
</html>
