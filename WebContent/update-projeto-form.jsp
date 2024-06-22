<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Projeto</title>
</head>
<body>
    <h2>Editar Projeto</h2>
    
    <form action="ProjetoServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${projeto.id}">
        
        <label>Título:</label>
        <input type="text" name="titulo" value="${projeto.titulo}" required><br><br>
        
        <label>Data Inicial:</label>
        <input type="date" name="dataInicial" value="${projeto.dataInicial}" required><br><br>
        
        <label>Data Final:</label>
        <input type="date" name="dataFinal" value="${projeto.dataFinal}" required><br><br>
        
        <label>ID Professor:</label>
        <input type="number" name="professorId" value="${projeto.professorId}" required><br><br>
        
        <label>ID Aluno Bolsista:</label>
        <input type="number" name="alunoBolsistaId" value="${projeto.alunoBolsistaId}" required><br><br>
        
        <label>ID Aluno Voluntário:</label>
        <input type="number" name="alunoVoluntarioId" value="${projeto.alunoVoluntarioId}" required><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="ProjetoServlet?action=listar">Cancelar</a>
</body>
</html>
