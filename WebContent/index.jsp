<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>P�gina Inicial</title>
</head>
<body>
    <h1>Bem-vindo!</h1>
    <p>Por favor, selecione o tipo de usu�rio:</p>

    <!-- Verificar se existe uma mensagem de erro e exibi-la -->
    <c:if test="${not empty erroLogin}">
        <p style="color:red;">${erroLogin}</p>
    </c:if>

    <form action="IndexServlet" method="post">
        <label for="tipoUsuario">Tipo de Usu�rio:</label>
        <select id="tipoUsuario" name="tipoUsuario">
            <option value="professor">Professor</option>
            <option value="coordenador">Coordenador</option>
            <option value="aluno">Aluno</option>
        </select><br><br>
        
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"><br><br>
        
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha"><br><br>
        
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
