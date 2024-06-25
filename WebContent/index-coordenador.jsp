<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/componentes.css">
    <link rel="stylesheet" href="css/pagina-inicial.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Página do Coordenador</title>
 </head>
<body>
	<%@ include file="componentes/nav.jsp" %>
	
	<main>
	<section class="buttons">
	        <div class="container-fluid">
	            <div class="button-group">
	            <button class="button button-1" onclick="window.location.href='RelatorioAnalisesServlet?action=visualizar'">Relatórios e Análises</button>
        		<button class="button button-1" onclick="window.location.href='AlunoServlet?action=listar'" onclick="window.location.href='listar-alunos.jsp'">Gestão de Alunos</button>
        		<button class="button button-1" onclick="window.location.href='ProjetoServlet?action=listar'" onclick="window.location.href='listar-projetos.jsp'">Gestão de Projetos</button>
        		<button class="button button-1" onclick="window.location.href='ProfessorServlet?action=listar'" onclick="window.location.href='index-professor.jsp'">Gestão de Professores</button>
        		<button class="button button-1" onclick="window.location.href='CoordenadorServlet?action=listar'" onclick="window.location.href='listar-coordenadores.jsp'">Gestão de Coordenadores</button>
        		<button class="button button-1" onclick="window.location.href='RelatorioCoordenadorServlet?action=listar'" onclick="window.location.href='listar-relatoriocoordenador.jsp'">Inserir Relatório</button>
	            </div>
	        </div>
	</section>
	</main>
	
	<%@ include file="componentes/footer.jsp" %>
</body>
</html>
