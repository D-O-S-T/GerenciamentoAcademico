<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Relatórios de Professores</title>
</head>
<body>
    <h2>Listagem de Relatórios de Professores</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Relatório</th>
                <th>ID do Professor</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="relatorioProfessor" items="${listaRelatorios}">
                <tr>
                    <td>${relatorioProfessor.id}</td>
                    <td>${relatorioProfessor.titulo}</td>
                    <td>${relatorioProfessor.relatorio}</td>
                    <td>${relatorioProfessor.professorId}</td>
                    <td>
                        <a href="RelatorioProfessorServlet?action=editar&id=${relatorioProfessor.id}">Editar</a>
                        <a href="RelatorioProfessorServlet?action=excluir&id=${relatorioProfessor.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <a href="relatorioprofessor-form.jsp">Adicionar Novo Relatório</a>
</body>
</html>
