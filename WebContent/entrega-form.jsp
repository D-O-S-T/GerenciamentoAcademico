<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Entrega</title>
</head>
<body>
    <h2>Formulário de Entrega</h2>
    
    <form action="EntregaServlet?action=inserir" method="post">
        <input type="hidden" name="atividadeId" value="${atividadeId}">
        <!-- outros campos do formulário -->
        <label for="conteudo">Conteúdo:</label><br>
        <textarea id="conteudo" name="conteudo" rows="4" cols="50"></textarea><br>
        
        <input type="submit" value="Enviar Entrega">
    </form>

    <br>
    <button onclick="window.location.href='AtividadeServlet?action=listarPorAluno'">Voltar</button>
</body>
</html>
