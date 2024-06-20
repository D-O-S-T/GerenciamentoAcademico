<!-- usuario-form.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Usuário</title>
</head>
<body>
    <h2>Formulário de Usuário</h2>
    <form action="UsuarioControllerServlet" method="post">
        <input type="hidden" name="command" value="ADD">
        
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br><br>
        
        <label for="tipoUsuario">Tipo de Usuário:</label>
        <select id="tipoUsuario" name="tipoUsuario">
            <option value="Aluno">Aluno</option>
            <option value="Professor">Professor</option>
            <option value="Administrador">Administrador</option>
        </select><br><br>
        
        <input type="submit" value="Cadastrar Usuário">
    </form>
</body>
</html>

