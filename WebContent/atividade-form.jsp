<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inserir Atividade</title>
</head>
<body>
    <h1>Inserir Atividade</h1>
    <form action="AtividadeServlet?action=inserir" method="post">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" required><br><br>

        <label for="conteudo">Conteúdo:</label>
        <textarea id="conteudo" name="conteudo" required></textarea><br><br>

        <label for="dataInicial">Data Inicial:</label>
        <input type="date" id="dataInicial" name="dataInicial" required><br><br>

        <label for="dataFinal">Data Final:</label>
        <input type="date" id="dataFinal" name="dataFinal" required><br><br>

        <input type="submit" value="Inserir Atividade">
    </form>
    <br>
    <a href="AtividadeServlet?action=listar">Voltar</a>
</body>
</html>
