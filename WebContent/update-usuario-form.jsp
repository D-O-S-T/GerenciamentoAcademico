<!-- update-usuario-form.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Usuário</title>
</head>
<body>
    <h2>Atualizar Usuário</h2>
    <form action="UsuarioServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${usuario.id}">
        
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" value="${usuario.login}">
        <br>
        
        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" value="${usuario.email}">
        <br>
        
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" value="${usuario.senha}">
        <br>
        
        <label for="tipoUsuario">Tipo de Usuário:</label>
        <input type="text" id="tipoUsuario" name="tipoUsuario" value="${usuario.tipoUsuario}">
        <br>
        
        <input type="submit" value="Atualizar">
    </form>
</body>
</html>

