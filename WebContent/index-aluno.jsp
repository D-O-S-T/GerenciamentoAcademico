<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Seu arquivo HTML -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/index-aluno.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>Perfil Aluno</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg fixed-top navbarScroll">
        <div class="container">
            <div class="logo-container">
                <img src="imagens/undf.png" alt="Logo UnDF" class="logoUnDF" width="95px" height="50px">
            </div>
            <p class="heroTitle">Bem-vindo(a), ${sessionScope.usuarioNome}!</p>
        </div>
    </nav>
	    
	<main>
	    <section class="butoins">
	        <div class="container-fluid">
	            <div class="button-container">
	                <button class="button-1" onclick="window.location.href='AtividadeServlet?action=listarPorAluno'"><span>Entregar Atividade</span></button>
	                <button class="button-2" onclick="window.location.href='FeedbackAlunoServlet?action=listar'"><span>Feedback</span></button>
	                <button class="button-3" onclick="window.location.href='aluno-feedbackprofessor-list.jsp'"><span>Avaliar Feedback</span></button>
	            </div>
	        </div>
	    </section>
    </main>
    
    <!-- footer -->
	<footer>
	    <div class="container">
	        <div class="row">
	            <div class="col-md-8 col-sm-12 col-xs-12">
	                <h1>Universidade do Distrito Federal Professor Jorge Amaury Maia Nunes - UnDF</h1>
	                <p class="sigla">Governo do Distrito Federal</p>
	            </div>
	            <div class="col-md-4 col-sm-12 col-xs-12 logo-do-gdf">
	                <p>Residência Oficial da Granja do Torto - Parque Tecnológico de Brasília - BIOTIC, Lote 4, DF / UnDF - 2° ANDAR CEP: 70635-815</p>
	            </div>
	        </div>
	    </div>
	</footer>
</body>
</html>