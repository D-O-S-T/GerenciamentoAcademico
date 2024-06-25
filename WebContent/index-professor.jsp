<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
    <link rel="stylesheet" href="css/pagina-inicial.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

    <title>P�gina do Professor</title>
</head>
<body>
	<%@ include file="componentes/nav.jsp" %>
	
	<main>
	<section class="buttons">
	        <div class="container-fluid">
	            <div class="button-group">
	            <button class="button button-1" onclick="window.location.href='FeedbackProfessorServlet?action=listar'"><span>Inserir Feedback</span></button>
        		<button class="button button-2" onclick="window.location.href='RelatorioProfessorServlet?action=listar'" ><span>Relat�rios</span></button>
       			<button class="button button-3" onclick="window.location.href='AtividadeServlet?action=listar'"><span>Gest�o de Atividades</span></button>
	            </div>
	         </div>
	</section>
	</main>
	<%@ include file="componentes/footer.jsp" %>
</body>
</html>
