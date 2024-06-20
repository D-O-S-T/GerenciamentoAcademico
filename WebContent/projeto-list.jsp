<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Projetos</title>
</head>
<body>
    <h1>Lista de Projetos</h1>
    <a href="ProjetoControllerServlet?command=ADD">Adicionar Projeto</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Data Inicial</th>
                <th>Data Final</th>
                <th>Quantidade de Aulas</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="projeto" items="${PROJETO_LIST}">
                <tr>
                    <td>${projeto.id}</td>
                    <td>${projeto.titulo}</td>
                    <td>${projeto.dataInicial}</td>
                    <td>${projeto.dataFinal}</td>
                    <td>${projeto.qtdAulas}</td>
                    <td>
                        <a href="ProjetoControllerServlet?command=LOAD&id=${projeto.id}">Editar</a>
                        <a href="ProjetoControllerServlet?command=DELETE&id=${projeto.id}" 
                           onclick="return confirm('Tem certeza que deseja excluir este projeto?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
