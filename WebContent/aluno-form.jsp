<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Aluno</title>
</head>
<body>

    <h2>Adicionar Aluno</h2>

    <form action="AlunoControllerServlet" method="post">
        <input type="hidden" name="command" value="ADD">
        
        <label for="matricula">Matrícula:</label>
        <input type="text" name="matricula" required><br>
        
        <label for="curso">Curso:</label>
        <input type="text" name="curso" required><br>
        
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required><br>
        
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        
        <label for="lattes">Lattes:</label>
        <input type="text" name="lattes"><br>
        
        <input type="submit" value="Adicionar Aluno">
    </form>

</body>
</html>
