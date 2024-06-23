<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Atividade</title>
</head>
<body>
    <h2>Atualizar Atividade</h2>
    
    <form action="AtividadeServlet?action=atualizar" method="post">
        <input type="hidden" name="id" value="${atividade.id}">
        Título: <input type="text" name="titulo" value="${atividade.titulo}"><br>
        Conteúdo: <textarea name="conteudo">${atividade.conteudo}</textarea><br>
        Data Inicial: <input type="date" name="dataInicial" value="${atividade.dataInicial}"><br>
        Data Final: <input type="date" name="dataFinal" value="${atividade.dataFinal}"><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <button onclick="window.location.href='AtividadeServlet?action=listar'">Cancelar</button>
</body>
</html>


