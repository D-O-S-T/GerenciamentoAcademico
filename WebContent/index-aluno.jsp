<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/cssInicial.css" type="text/css">
    <title>Perfil Aluno</title>
</head>
<body>
    <h1>Bem-vindo, ${sessionScope.usuarioNome}!</h1>

    <div class="button-container">
        <button onclick="window.location.href='entregarAtividade.jsp'">Entregar Atividade</button>
        <button onclick="window.location.href='feedbackaluno-form.jsp'">Inserir Feedback</button>
        <button onclick="window.location.href='lerFeedback.jsp'">Ler Feedback</button>
    </div>
</body>
</html>
