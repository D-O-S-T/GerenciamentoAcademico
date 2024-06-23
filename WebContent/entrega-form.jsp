<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inserir Entrega</title>
</head>
<body>
    <h1>Inserir Entrega</h1>
    <form action="EntregaServlet?action=inserir" method="post">
        <label for="conteudo">Conteúdo:</label>
        <textarea id="conteudo" name="conteudo" required></textarea><br><br>

        <label for="dataEntrega">Data de Entrega:</label>
        <input type="date" id="dataEntrega" name="dataEntrega" required><br><br>

        <label for="alunoDaEntregaId">ID do Aluno:</label>
        <input type="number" id="alunoDaEntregaId" name="alunoDaEntregaId" required><br><br>

        <label for="atividadeId">ID da Atividade:</label>
        <input type="number" id="atividadeId" name="atividadeId" required><br><br>

        <input type="submit" value="Inserir Entrega">
    </form>
    <br>
    <a href="EntregaServlet?action=listar">Voltar</a>
</body>
</html>
