<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Alunos</title>
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
</head>
<body>
	<div class="wrapper">
	<%@ include file="componentes/sidebar.jsp" %>
	<div class="main-content">
    <h2>Listagem de Alunos</h2>
    <button onclick="window.location.href='aluno-form.jsp'">Adicionar Novo Aluno</button>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Matrícula</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Lattes</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${listaAlunos}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.matricula}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.email}</td>
                    <td>${aluno.lattes}</td>
                    <td>${aluno.login}</td>
                    <td>
                        <a href="AlunoServlet?action=editar&id=${aluno.id}">Editar</a>
                        <a href="AlunoServlet?action=excluir&id=${aluno.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    
    </div>
    </div>
    <%@ include file="componentes/footer.jsp" %>
</body>
</html>
