<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário do Professor</title>
</head>
<body>
    <h1>Formulário do Professor</h1>
    <form action="cadastrarProfessor" method="post">
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="lattes">Lattes:</label><br>
        <input type="text" id="lattes" name="lattes"><br>
        <label for="login">Login:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="senha">Senha:</label><br>
        <input type="password" id="senha" name="senha"><br><br>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>

