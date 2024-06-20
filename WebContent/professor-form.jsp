<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Professor</title>
</head>
<body>

    <h2>Adicionar Professor</h2>

    <form action="ProfessorControllerServlet" method="post">
        <input type="hidden" name="command" value="ADD">
        
        <h3>Dados do Usuário</h3>
        <label for="login">Login:</label>
        <input type="text" name="login" required><br>
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        <label for="senha">Senha:</label>
        <input type="password" name="senha" required><br>
        
        <h3>Dados do Professor</h3>
        <label for="areaAtuacao">Área de Atuação:</label>
        <input type="text" name="areaAtuacao" required><br>
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required><br>
        <label for="emailProfessor">Email do Professor:</label>
        <input type="email" name="emailProfessor" required><br>
        <label for="lattes">Currículo Lattes:</label>
        <input type="text" name="lattes" required><br>

        <input type="submit" value="Adicionar Professor">
    </form>

</body>
</html>

