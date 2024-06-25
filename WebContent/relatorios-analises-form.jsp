<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="relatorioAnalises" scope="request"
	class="com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises" />

<html>
<head>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/componentes.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Relatório de Análises</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
<script>
        function gerarPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            // Adicionando a barra azul claro no cabeçalho
            doc.setFillColor(204, 229, 255); // Cor azul claro (RGB)
            doc.rect(0, 0, 210, 20, 'F'); // Desenha um retângulo azul claro de largura total no topo

            // Adicionando o cabeçalho "Universidade do Distrito Federal"
            doc.setFontSize(16);
            doc.setTextColor(0, 0, 0); // Cor do texto: preto
            doc.text("Universidade do Distrito Federal", 105, 15, { align: "center" });

            // Adicionando os detalhes do relatório
            doc.setFontSize(12);
            doc.text("Relatório de Análises", 105, 30, { align: "center" });
            doc.text("Total de Usuários: " + "<%=relatorioAnalises.getTotalUsuarios()%>", 10, 50);
            doc.text("Total de Professores: " + "<%=relatorioAnalises.getTotalProfessores()%>", 10, 60);
            doc.text("Total de Alunos: " + "<%=relatorioAnalises.getTotalAlunos()%>", 10, 70);
            doc.text("Total de Coordenadores: " + "<%=relatorioAnalises.getTotalCoordenadores()%>", 10, 80);
            doc.text("Total de Atividades: " + "<%=relatorioAnalises.getTotalAtividades()%>", 10, 90);
            doc.text("Total de Projetos: " + "<%=relatorioAnalises.getTotalProjetos()%>", 10, 100);
            doc.text("Total de Entregas: " + "<%=relatorioAnalises.getTotalEntregas()%>", 10, 110);

            // Adicionando "Brasília" e a data atual no rodapé
            const dataAtual = new Date().toLocaleDateString('pt-BR');
            doc.setFontSize(10);
            doc.text("Brasília, " + dataAtual, 105, 280, { align: "center" });

            doc.save("relatorio-analises.pdf");
        }
    </script>
</head>
<body>

	<%@ include file="componentes/sidebar.jsp"%>

	<div class="analise">
		<div class="analise-container">
		<h1>Relatório de Análises</h1>
		<p>Total de Usuários: ${relatorioAnalises.totalUsuarios}</p>
		<p>Total de Professores: ${relatorioAnalises.totalProfessores}</p>
		<p>Total de Alunos: ${relatorioAnalises.totalAlunos}</p>
		<p>Total de Coordenadores: ${relatorioAnalises.totalCoordenadores}</p>
		<p>Total de Atividades: ${relatorioAnalises.totalAtividades}</p>
		<p>Total de Projetos: ${relatorioAnalises.totalProjetos}</p>
		<p>Total de Entregas: ${relatorioAnalises.totalEntregas}</p>
		<button onclick="window.location.href='index-coordenador.jsp'">Voltar
			a Página Inicial</button>
		<button onclick="gerarPDF()">Gerar PDF</button></div>
		
	</div>
	
	<%@ include file="componentes/footer.jsp"%>

</body>
</html>
