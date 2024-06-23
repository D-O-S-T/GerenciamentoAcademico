<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Aluno</title>
</head>
<body>
    <h2>Editar Aluno</h2>
    
    <form action="AlunoServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${aluno.id}">
        
        <label>Matrícula:</label>
        <input type="text" name="matricula" value="${aluno.matricula}" required><br><br>
        
        <label>Nome:</label>
        <input type="text" name="nome" value="${aluno.nome}" required><br><br>
        
        <label>E-mail:</label>
        <input type="email" name="email" value="${aluno.email}" required><br><br>
        
        <label>Lattes:</label>
        <input type="text" name="lattes" value="${aluno.lattes}"><br><br>
        
        <label>Login:</label>
        <input type="text" name="login" value="${aluno.login}" required><br><br>
        
        <label>Senha:</label>
        <input type="password" name="senha" value="${aluno.senha}" required><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="AlunoServlet?action=listar">Cancelar</a>
</body>
</html>
