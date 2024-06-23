<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Relatório de Professor</title>
</head>
<body>
    <h2>Editar Relatório de Professor</h2>
    
    <form action="RelatorioProfessorServlet" method="POST">
        <input type="hidden" name="action" value="atualizar">
        <input type="hidden" name="id" value="${relatorioProfessor.id}">
        
        <label>Título:</label>
        <input type="text" name="titulo" value="${relatorioProfessor.titulo}" required><br><br>
        
        <label>Relatório:</label>
        <textarea name="relatorio" rows="4" cols="50" required>${relatorioProfessor.relatorio}</textarea><br><br>
        
        <label>ID do Professor:</label>
        <input type="number" name="professor_id" value="${relatorioProfessor.professorId}" required><br><br>
        
        <input type="submit" value="Atualizar">
    </form>
    
    <br>
    <a href="RelatorioProfessorServlet?action=listar">Cancelar</a>
</body>
</html>
