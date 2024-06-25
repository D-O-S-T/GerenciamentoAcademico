<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Projetos</title>
    <link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<div class="wrapper">
	<%@ include file="componentes/sidebar.jsp" %>
	<div class="main-content">
	
    <h2>Listagem de Projetos</h2>
    <button onclick="window.location.href='projeto-form.jsp'">Adicionar Novo Projeto</button>
    
    <table class="tabela" border="1">
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
    </div>
    </div>
    
    <%@ include file="componentes/footer.jsp" %>
</body>
</html>

