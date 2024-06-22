<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>P�gina do Coordenador</title>
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
        <button onclick="window.location.href='relatoriosAnalises.jsp'">Relat�rios e An�lises</button>
        <button onclick="window.location.href='acompanhamentoProjetos.jsp'">Acompanhamento dos Projetos</button>
        <button onclick="window.location.href='gestaoAlunos.jsp'">Gest�o de Alunos</button>
        <button onclick="window.location.href='gestaoProjetos.jsp'">Gest�o de Projetos</button>
        <button onclick="window.location.href='gestaoProfessores.jsp'">Gest�o de Professores</button>
        <button onclick="window.location.href='gestaoCoordenadores.jsp'">Gest�o de Coordenadores</button>
        <button onclick="window.location.href='inserirRelatorio.jsp'">Inserir Relat�rio</button>
    </div>
</body>
</html>
