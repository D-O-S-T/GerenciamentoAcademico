<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Projetos</title>
</head>
<body>
    <h2>Listagem de Projetos</h2>
    <button onclick="window.location.href='projeto-form.jsp'">Adicionar Novo Projeto</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Conteúdo</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Professor</th>
                <th>Aluno Bolsista</th>
                <th>Aluno Voluntário</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="projeto" items="${listaProjetos}">
                <tr>
                    <td>${projeto.id}</td>
                    <td>${projeto.titulo}</td>
                    <td>${projeto.conteudo}</td>
                    <td>${projeto.dataInicial}</td>
                    <td>${projeto.dataFinal}</td>
                    <td>${projeto.professorNome}</td>
                    <td>${projeto.alunoBolsistaNome}</td>
                    <td>${projeto.alunoVoluntarioNome}</td>
                    <td>
                        <a href="ProjetoServlet?action=editar&id=${projeto.id}">Editar</a>
                        <a href="ProjetoServlet?action=excluir&id=${projeto.id}">Excluir</a>
                        <a href="ProjetoServlet?action=&id=${projeto.id}">Exibir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
</body>
</html>

