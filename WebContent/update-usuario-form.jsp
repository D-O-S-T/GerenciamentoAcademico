<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Usuario</title>
</head>
<body>
    <h2>Update Usuario</h2>
    <form action="UsuarioControllerServlet" method="post">
    <input type="hidden" name="command" value="UPDATE">
    <input type="hidden" name="id" value="${THE_USUARIO.id}">
    
    <label>Login:</label>
    <input type="text" name="login" value="${THE_USUARIO.login}">
    <br>
    
    <label>Email:</label>
    <input type="text" name="email" value="${THE_USUARIO.email}">
    <br>
    
    <label>Senha:</label>
    <input type="password" name="senha" value="${THE_USUARIO.senha}">
    <br>
    
    <label>Tipo Usuário:</label>
    <input type="text" name="tipoUsuario" value="${THE_USUARIO.tipoUsuario}">
    <br>
    
    <input type="submit" value="Update">
</form>

</body>
</html>

