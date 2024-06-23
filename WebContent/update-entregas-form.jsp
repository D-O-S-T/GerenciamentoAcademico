<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Entrega</title>
</head>
<body>
    <h2>Atualizar Entrega</h2>
    
    <form action="EntregaServlet?action=atualizar" method="post">
        <input type="hidden" name="id" value="${entrega.id}">
        Conteúdo: <textarea name="conteudo">${entrega.conteudo}</textarea><br>
        Data de Entrega: <input type="date" name="dataEntrega" value="${entrega.dataEntrega}"><br>
        Aluno: 
        <select name="alunoDaEntrega_id">
            <c:forEach var="aluno" items="${listaAlunos}">
                <option value="${aluno.id}" ${aluno.id == entrega.alunoDaEntrega_id ? 'selected' : ''}>${aluno.nome}</option>
            </c:forEach>
        </select><br>
        Atividade: 
        <select name="atividade_id">
            <c:forEach var="atividade" items="${listaAtividades}">
                <option value="${atividade.id}" ${atividade.id == entrega.atividade_id ? 'selected' : ''}>${atividade.titulo}</option>
            </c:forEach>
        </select><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <button onclick="window.location.href='EntregaServlet?action=listar'">Cancelar</button>
</body>
</html>
