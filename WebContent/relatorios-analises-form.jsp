<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Relatório de Análises</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
        }
        table, th, td {
            border: 1px solid #dddddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Relatório de Análises</h1>
    <table>
        <tr>
            <td>Total de Usuários</td>
            <td>${relatorio.totalUsuarios}</td>
        </tr>
        <tr>
            <td>Total de Professores</td>
            <td>${relatorio.totalProfessores}</td>
        </tr>
        <tr>
            <td>Total de Alunos</td>
            <td>${relatorio.totalAlunos}</td>
        </tr>
        <tr>
            <td>Total de Coordenadores</td>
            <td>${relatorio.totalCoordenadores}</td>
        </tr>
        <tr>
            <td>Total de Atividades</td>
            <td>${relatorio.totalAtividades}</td>
        </tr>
        <tr>
            <td>Total de Projetos</td>
            <td>${relatorio.totalProjetos}</td>
        </tr>
        <tr>
            <td>Total de Entregas</td>
            <td>${relatorio.totalEntregas}</td>
        </tr>
    </table>
</body>
</html>



