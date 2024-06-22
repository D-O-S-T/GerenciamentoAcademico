<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página do Professor</title>
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
        <button onclick="window.location.href='inserirFeedback.jsp'">Inserir Feedback</button>
        <button onclick="window.location.href='RelatorioProfessorServlet?action=listar'" onclick="window.location.href='listar-relatorioprofessor.jsp'">Relatórios</button>
        <button onclick="window.location.href='gestaoAtividades.jsp'">Gestão de Atividades</button>
    </div>
</body>
</html>
