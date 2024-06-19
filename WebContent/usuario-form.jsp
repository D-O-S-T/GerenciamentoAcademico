<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Usuário</title>
</head>
<body>

    <h2>Adicionar Usuário</h2>

    <form action="UsuarioControllerServlet" method="post">
        <input type="hidden" name="command" value="ADD">
        <label for="login">Login:</label>
        <input type="text" name="login" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        <label for="senha">Senha:</label>
        <input type="password" name="senha" required><br>
        <label for="tipo_usuario">Tipo de Usuário:</label>
        <input type="text" name="tipoUsuario" required><br>
        <input type="submit" value="Adicionar Usuário">
    </form>

</body>
</html>
