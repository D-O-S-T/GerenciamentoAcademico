<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt">
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
    <link rel="stylesheet" href="css/index-aluno.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Página do Professor</title>
</head>
<body>
	<%@ include file="componentes/nav.jsp" %>
    <h1>Bem-vindo(a), ${sessionScope.usuarioNome}!</h1>

    <div class="button-container">
        <button onclick="window.location.href='FeedbackProfessorServlet?action=listar'">Inserir Feedback</button>
        <button onclick="window.location.href='RelatorioProfessorServlet?action=listar'" onclick="window.location.href='listar-relatorioprofessor.jsp'">Relatórios</button>
        <button onclick="window.location.href='AtividadeServlet?action=listar'" onclick="window.location.href='listar-atividades.jsp'">Gestão de Atividades</button>
    </div>
</body>
</html>
