<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Coordenador</title>
</head>
<body>
    <h2>Formulário de Coordenador</h2>
    <%-- Formulário para inserção e edição de coordenadores --%>
    <form action="CoordenadorServlet?action=inserir" method="post">
    
        <%-- Nome --%>
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <%-- E-mail --%>
        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        
        <%-- Login --%>
        <label for="login">Login:</label><br>
        <input type="text" id="login" name="login" required><br><br>
        
        <%-- Senha --%>
        <label for="senha">Senha:</label><br>
        <input type="password" id="senha" name="senha" required><br><br>
        
        <%-- Botão para enviar o formulário --%>
        <input type="submit" value="Salvar">
    </form>
</body>
</html>
