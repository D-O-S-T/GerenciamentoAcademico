<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/pagina-padrao.css">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Lista de Entregas dos Alunos</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<%@ include file="componentes/sidebar-professor.jsp" %>
	<%@ include file="componentes/nav.jsp" %>
    <div class="wrapper">
        <div class="container">
        
		    <h2>Lista de Entregas dos Alunos</h2>

			    <table border="1">
			        <thead>
			            <tr>
			                <th>Conteúdo</th>
			                <th>Data de Entrega</th>
			                <th>ID do Aluno</th>
			                <th>ID da Atividade</th>
			            </tr>
			        </thead>
			        
			        <tbody>
			            <c:forEach var="entrega" items="${listaEntregas}">
			                <tr>
			                    <td>${entrega.conteudo}</td>
			                    <td>${entrega.dataEntrega}</td>
			                    <td>${entrega.alunoDaEntregaId}</td>
			                    <td>${entrega.atividadeId}</td>
			                </tr>
			            </c:forEach>
			        </tbody>
			    </table>
			    <button class="button-custom button-secondary" onclick="window.location.href='AtividadeServlet?action=listar'">Voltar</button>
    	</div>
    </div>
    <%@ include file="componentes/footer.jsp" %>
</body>
</html>
