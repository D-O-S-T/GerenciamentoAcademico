<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listagem de Alunos</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.13/jspdf.plugin.autotable.min.js"></script>
    <script>
        function gerarPDF() {
            const { jsPDF } = window.jspdf;
            const doc = new jsPDF();

            doc.text("Listagem de Alunos", 10, 10);

            const headers = ["ID", "Matrícula", "Nome", "E-mail", "Lattes", "Login"];
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

            doc.save("listagem_alunos.pdf");
        }
    </script>
</head>
<body>
    <h2>Listagem de Alunos</h2>
    <button onclick="window.location.href='aluno-form.jsp'">Adicionar Novo Aluno</button>
    <button onclick="gerarPDF()">Gerar PDF</button>
    
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
    <button onclick="window.location.href='index-coordenador.jsp'">Voltar a Página Inicial</button>
</body>
</html>
