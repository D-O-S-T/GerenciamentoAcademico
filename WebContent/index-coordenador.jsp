<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página do Coordenador</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container button {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .button-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Bem-vindo, ${sessionScope.usuarioNome}!</h1>

    <div class="button-container">
        <button onclick="window.location.href='RelatorioAnalisesServlet?action=listar'" onclick="window.location.href='relatorios-analises-form.jsp'">Relatórios e Análises</button>
        <button onclick="window.location.href='acompanhamentoProjetos.jsp'">Acompanhamento dos Projetos</button>
        <button onclick="window.location.href='AlunoServlet?action=listar'" onclick="window.location.href='listar-alunos.jsp'">Gestão de Alunos</button>
        <button onclick="window.location.href='ProjetoServlet?action=listar'" onclick="window.location.href='listar-projetos.jsp'">Gestão de Projetos</button>
        <button onclick="window.location.href='ProfessorServlet?action=listar'" onclick="window.location.href='index-professor.jsp'">Gestão de Professores</button>
        <button onclick="window.location.href='CoordenadorServlet?action=listar'" onclick="window.location.href='listar-coordenadores.jsp'">Gestão de Coordenadores</button>
        <button onclick="window.location.href='RelatorioCoordenadorServlet?action=listar'" onclick="window.location.href='listar-relatoriocoordenador.jsp'">Inserir Relatório</button>
    </div>
</body>
</html>
