<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Relatórios de Coordenador</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
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

            // Adicionando o título "Listagem de Relatórios de Coordenador"
            doc.setFontSize(14);
            doc.text("Listagem de Relatórios de Coordenador", 105, 30, { align: "center" });

            // Obtendo os dados da tabela para o corpo do PDF
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

            // Configurando a tabela automática no PDF
            doc.autoTable({
                head: [["ID", "Título", "Relatório", "Coordenador"]],
                body: data,
                startY: 40, // Posição inicial do corpo da tabela abaixo do cabeçalho
            });

            // Adicionando "Brasília" e a data atual no rodapé
            const dataAtual = new Date().toLocaleDateString('pt-BR');
            doc.setFontSize(10);
            doc.text("Brasília, " + dataAtual, 105, doc.internal.pageSize.height - 10, { align: "center" });

            // Salvando o PDF com o nome específico
            doc.save("listagem_relatorios_coordenador.pdf");
        }
    </script>
</head>
<body>
    <h2>Listagem de Relatórios de Coordenador</h2>
    <button onclick="window.location.href='relatoriocoordenador-form.jsp'">Adicionar Novo Relatório</button>
    <button onclick="gerarPDF()">Gerar PDF</button>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Relatório</th>
                <th>Coordenador</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="relatorio" items="${listaRelatorios}">
                <tr>
                    <td>${relatorio.id}</td>
                    <td>${relatorio.titulo}</td>
                    <td>${relatorio.relatorio}</td>
                    <td>${relatorio.coordenadorId}</td> <!-- Exemplo: exibindo apenas o ID do coordenador -->
                    <td>
                        <a href="RelatorioCoordenadorServlet?action=editar&id=${relatorio.id}">Editar</a>
                        <a href="RelatorioCoordenadorServlet?action=excluir&id=${relatorio.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br>
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar à Página Inicial</button>
</body>
</html>

