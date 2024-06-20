<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Professores</title>
</head>
<body>
    <h1>Lista de Professores</h1>
    <a href="ProfessorControllerServlet?command=ADD">Adicionar Professor</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>ID do Usuário</th>
                <th>Área de Atuação</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Lattes</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="professor" items="${PROFESSOR_LIST}">
                <tr>
                    <td>${professor.id}</td>
                    <td>${professor.usuarioId}</td>
                    <td>${professor.areaAtuacao}</td>
                    <td>${professor.nome}</td>
                    <td>${professor.email}</td>
                    <td>${professor.lattes}</td>
                    <td>
                        <a href="ProfessorControllerServlet?command=LOAD&id=${professor.id}">Editar</a>
                        <a href="ProfessorControllerServlet?command=DELETE&id=${professor.id}" 
                           onclick="return confirm('Tem certeza que deseja excluir este professor?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
