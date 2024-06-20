<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Atualizar Professor</title>
</head>
<body>
    <h2>Atualizar Professor</h2>
    <form action="ProfessorControllerServlet" method="post">
        <input type="hidden" name="command" value="UPDATE">
       
     
        
        <label>Área de Atuação:</label>
        <input type="text" name="areaAtuacao" value="${THE_PROFESSOR.areaAtuacao}" required>
        <br>
        
        <label>Nome:</label>
        <input type="text" name="nome" value="${THE_PROFESSOR.nome}" required>
        <br>
        
        <label>Email:</label>
        <input type="email" name="email" value="${THE_PROFESSOR.email}" required>
        <br>
        
        <label>Lattes:</label>
        <input type="text" name="lattes" value="${THE_PROFESSOR.lattes}" required>
        <br>
        
        <input type="submit" value="Atualizar">
    </form>
</body>
</html>
