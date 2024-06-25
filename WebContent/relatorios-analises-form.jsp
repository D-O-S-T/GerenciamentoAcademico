<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="relatorioAnalises" scope="request" class="com.exemplo.gerenciamentoacademico.jdbc.model.RelatorioAnalises" />

<html>
<head>
    <title>Relatório de Análises</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
    <script>
        function gerarPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Relatório de Análises", 10, 10);
            doc.text("Total de Usuários: " + "<%= relatorioAnalises.getTotalUsuarios() %>", 10, 20);
            doc.text("Total de Professores: " + "<%= relatorioAnalises.getTotalProfessores() %>", 10, 30);
            doc.text("Total de Alunos: " + "<%= relatorioAnalises.getTotalAlunos() %>", 10, 40);
            doc.text("Total de Coordenadores: " + "<%= relatorioAnalises.getTotalCoordenadores() %>", 10, 50);
            doc.text("Total de Atividades: " + "<%= relatorioAnalises.getTotalAtividades() %>", 10, 60);
            doc.text("Total de Projetos: " + "<%= relatorioAnalises.getTotalProjetos() %>", 10, 70);
            doc.text("Total de Entregas: " + "<%= relatorioAnalises.getTotalEntregas() %>", 10, 80);

            doc.save("relatorio-analises.pdf");
        }
    </script>
</head>
<body>
    <h1>Relatório de Análises</h1>
    <p>Total de Usuários: ${relatorioAnalises.totalUsuarios}</p>
    <p>Total de Professores: ${relatorioAnalises.totalProfessores}</p>
    <p>Total de Alunos: ${relatorioAnalises.totalAlunos}</p>
    <p>Total de Coordenadores: ${relatorioAnalises.totalCoordenadores}</p>
    <p>Total de Atividades: ${relatorioAnalises.totalAtividades}</p>
    <p>Total de Projetos: ${relatorioAnalises.totalProjetos}</p>
    <p>Total de Entregas: ${relatorioAnalises.totalEntregas}</p>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
    <button onclick="gerarPDF()">Gerar PDF</button>
</body>
</html>
