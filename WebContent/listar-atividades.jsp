<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/png" sizes="16x16" href="imagens/favicon-undf.png">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/sidebar-coordenador.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Listagem de Atividades</title>
</head>
<body>
	<%@ include file="componentes/sidebar-aluno.jsp" %>
	<%@ include file="componentes/nav.jsp" %>
    <div class="side-bar2">
        <div class="side-bar-padrao2">
    <h2>Listagem de Atividades</h2>
    <div class="teste2">
    <button onclick="window.location.href='atividade-form.jsp'">Adicionar Nova Atividade</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Conteúdo</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Projeto</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="atividade" items="${listaAtividades}">
                <tr>
                    <td>${atividade.id}</td>
                    <td>${atividade.titulo}</td>
                    <td>${atividade.conteudo}</td>
                    <td>${atividade.dataInicial}</td>
                    <td>${atividade.dataFinal}</td>
                    <td>${atividade.projetoTitulo}</td>
                    <td>
                        <a href="AtividadeServlet?action=editar&id=${atividade.id}">Editar</a>
                        <a href="AtividadeServlet?action=excluir&id=${atividade.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <button onclick="window.location.href='index-professor.jsp'">Voltar a Página Inicial</button>
    <button onclick="window.location.href='EntregaServlet?action=listarProfessor'">Listar Entregas dos Alunos</button>
	</div>
	</div>
	</div>
	<%@ include file="componentes/footer.jsp" %>
</body>
</html>
