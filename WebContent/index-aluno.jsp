<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página do Aluno</title>
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
        <button onclick="window.location.href='AtividadeServlet?action=listarPorAluno'">Entregar Atividade</button>
           <button onclick="window.location.href='FeedbackAlunoServlet?action=listar'">Inserir Feedback</button>
        <button onclick="window.location.href='lerFeedback.jsp'">Ler Feedback</button>
    </div>
</body>
</html>
