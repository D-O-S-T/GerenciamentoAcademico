<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usu�rios</title>
</head>
<body>
    <h1>Lista de Usu�rios</h1>
    <a href="UsuarioControllerServlet?command=ADD">Adicionar Usu�rio</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Email</th>
                <th>Tipo de Usu�rio</th>
                <th>A��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="usuario" items="${USUARIO_LIST}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.login}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.tipoUsuario}</td>
                    <td>
                        <a href="UsuarioControllerServlet?command=LOAD&id=${usuario.id}">Editar</a>
                        <a href="UsuarioControllerServlet?command=DELETE&id=${usuario.id}" 
                           onclick="return confirm('Tem certeza que deseja excluir este usu�rio?');">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

