<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Professor</title>
</head>
<body>
    <h2>Editar Professor</h2>
    
    <form action="ProfessorServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${professor.id}">
        
        <label>Nome:</label>
        <input type="text" name="nome" value="${professor.nome}" required><br><br>
        
        <label>E-mail:</label>
        <input type="email" name="email" value="${professor.email}" required><br><br>
        
        <label>Lattes:</label>
        <input type="text" name="lattes" value="${professor.lattes}" required><br><br>
        
        <label>Login:</label>
        <input type="text" name="login" value="${professor.login}" required><br><br>
        
        <label>Senha:</label>
        <input type="password" name="senha" value="${professor.senha}" required><br><br>
        
        <label>Área de Atuação:</label>
        <input type="text" name="areaAtuacao" value="${professor.areaAtuacao}" required><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="ProfessorServlet?action=listar">Cancelar</a>
</body>
</html>
