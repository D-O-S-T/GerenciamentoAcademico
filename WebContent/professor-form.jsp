<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Professor</title>
</head>
<body>
    <h2>Formulário de Professor</h2>
    <form action="ProfessorServlet?action=inserir" method="post">
        <%-- Nome --%>
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <%-- E-mail --%>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <%-- Lattes --%>
        <label for="lattes">Lattes:</label><br>
        <input type="text" id="lattes" name="lattes" required><br><br>
        
        <%-- Login --%>
        <label for="login">Login:</label><br>
        <input type="text" id="login" name="login" required><br><br>
        
        <%-- Senha --%>
        <label for="senha">Senha:</label><br>
        <input type="password" id="senha" name="senha" required><br><br>
        
        <%-- Área de Atuação --%>
        <label for="areaAtuacao">Área de Atuação:</label><br>
        <input type="text" id="areaAtuacao" name="areaAtuacao" required><br><br>
        
        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
