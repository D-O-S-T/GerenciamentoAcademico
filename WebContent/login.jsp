<!-- login.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- login.jsp -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="LoginControllerServlet" method="post">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" required><br>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br>

        <label for="tipoUsuario">Tipo de Usuário:</label>
        <select id="tipoUsuario" name="tipoUsuario" required>
            <option value="aluno">Aluno</option>
            <option value="professor">Professor</option>
            <option value="administrador">Administrador</option>
        </select><br>

        <input type="submit" value="Login">
    </form>

    <c:if test="${not empty mensagemErro}">
        <div style="color: red;">
            ${mensagemErro}
        </div>
    </c:if>
</body>
</html>
