<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Aluno</title>
</head>
<body>
    <h2>Update Aluno</h2>
    <form action="AlunoControllerServlet" method="post">
        <input type="hidden" name="command" value="UPDATE">
        <input type="hidden" name="id" value="${THE_ALUNO.id}">
        
        <label>Usuário ID:</label>
        <input type="text" name="usuarioId" value="${THE_ALUNO.usuarioId}" readonly>
        <br>
        
        <label>Matrícula:</label>
        <input type="text" name="matricula" value="${THE_ALUNO.matricula}">
        <br>
        
        <label>Curso:</label>
        <input type="text" name="curso" value="${THE_ALUNO.curso}">
        <br>
        
        <label>Nome:</label>
        <input type="text" name="nome" value="${THE_ALUNO.nome}">
        <br>
        
        <label>Email:</label>
        <input type="text" name="email" value="${THE_ALUNO.email}">
        <br>
        
        <label>Lattes:</label>
        <input type="text" name="lattes" value="${THE_ALUNO.lattes}">
        <br>
        
        <input type="submit" value="Update">
    </form>
</body>
</html>
