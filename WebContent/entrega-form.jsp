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
        
        <label for="dataEntrega">Data de Entrega:</label><br>
        <input type="date" id="dataEntrega" name="dataEntrega"><br>
        
        <label for="alunoDaEntregaId">ID do Aluno:</label><br>
        <input type="number" id="alunoDaEntregaId" name="alunoDaEntregaId"><br>
        
        <input type="submit" value="Enviar Entrega">
    </form>

    <br>
    <button onclick="window.location.href='index-aluno.jsp'">Voltar a Página Inicial</button>
</body>
</html>
