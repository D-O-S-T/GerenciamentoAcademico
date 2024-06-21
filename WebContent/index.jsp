<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
</head>
<body>
    <h1>Bem-vindo!</h1>
    <p>Por favor, selecione o tipo de usuário:</p>
    <form action="selecaoUsuario.jsp" method="post">
        <input type="radio" id="professor" name="tipoUsuario" value="professor">
        <label for="professor">Professor</label><br>
        <input type="radio" id="coordenador" name="tipoUsuario" value="coordenador">
        <label for="coordenador">Coordenador</label><br>
        <input type="radio" id="aluno" name="tipoUsuario" value="aluno">
        <label for="aluno">Aluno</label><br><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
