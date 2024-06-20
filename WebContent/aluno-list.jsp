<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Alunos</title>
</head>
<body>
    <h1>Lista de Alunos</h1>
    <a href="AlunoControllerServlet?command=ADD">Adicionar Aluno</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Matrícula</th>
                <th>Nome</th>
                <th>Curso</th>
                <th>Email</th>
                <th>Lattes</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aluno" items="${ALUNO_LIST}">
                <tr>
                    <td>${aluno.id}</td>
                    <td>${aluno.matricula}</td>
                    <td>${aluno.nome}</td>
                    <td>${aluno.curso}</td>
                    <td>${aluno.email}</td>
                    <td>${aluno.lattes}</td>
                    <td>
                        <a href="AlunoControllerServlet?command=LOAD&id=${aluno.id}">Editar</a>
                        <a href="AlunoControllerServlet?command=DELETE&id=${aluno.id}" 
                           onclick="return confirm('Tem certeza que deseja excluir este aluno?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
