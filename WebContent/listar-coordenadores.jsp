<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Listagem de Coordenadores</title>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
	<link rel="stylesheet" href="css/pagina-padrao.css">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- Lógica do PDF -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
	<script>
	        function gerarPDF() {
	            const { jsPDF } = window.jspdf;
	            const doc = new jsPDF();
	
	            doc.text("Listagem de Coordenadores", 10, 10);
	
	            const headers = ["ID", "Nome", "E-mail", "Login"];
	            let data = [];
	            const rows = document.querySelectorAll("table tbody tr");
	
	            rows.forEach(row => {
	                const cells = row.querySelectorAll("td");
	                let rowData = [];
	                cells.forEach(cell => {
	                    rowData.push(cell.innerText);
	                });
	                data.push(rowData);
	            });
	
	            doc.autoTable({
	                head: [headers],
	                body: data,
	            });
	
	            doc.save("listagem_coordenadores.pdf");
	        }
    </script>
</head>
<body>
	<%@ include file="componentes/sidebar-coordenador.jsp"%>

	<div class="wrapper">
		<div class="container">
			<h2>Listagem de Coordenadores</h2>  
			<button onclick="window.location.href='coordenador-form.jsp'">Adicionar Novo Coordenador</button>
			<button onclick="gerarPDF()">Gerar PDF</button>
			<button onclick="window.location.href='index-coordenador.jsp'">Voltar à Página Inicial</button>
	
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Login</th>
						<th>Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="coordenador" items="${listaCoordenadores}">
						<tr>
							<td>${coordenador.id}</td>
							<td>${coordenador.nome}</td>
							<td>${coordenador.email}</td>
							<td>${coordenador.login}</td>
							<td><a
								href="CoordenadorServlet?action=editar&id=${coordenador.id}">Editar</a>
								<a href="CoordenadorServlet?action=excluir&id=${coordenador.id}">Excluir</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="componentes/footer.jsp"%>
</body>
</html>
