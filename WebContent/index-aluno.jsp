<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Seu arquivo HTML -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/paginaInicialAluno.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Perfil Aluno</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg fixed-top navbarScroll">
        <div class="container" >
            <div class="logo-container">
                <img src="imagens/undf.png" alt="Logo UnDF" class="logoUnDF" width="95px" height="50px">
            </div>
            <p class="heroTitle">Bem-vindo, ${sessionScope.usuarioNome}!</p>
        </div>
    </nav>
   
    <section>
        <div class="container-fluid">
            <div class="button-container">
                <button class="button-1" onclick="window.location.href='entregarAtividade.jsp'">Entregar Atividade</button>
                <button class="button-2" onclick="window.location.href='feedbackaluno-form.jsp'">Inserir Feedback</button>
                <button class="button-3" onclick="window.location.href='lerFeedback.jsp'">Ler Feedback</button>
            </div>
        </div>
    </section>
</body>
</html>
