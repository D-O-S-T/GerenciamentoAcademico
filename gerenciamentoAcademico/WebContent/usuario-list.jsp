<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Usuários</title>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>Adicionar usuário</h2>
        </div>
    </div>

    <!-- put new button: Add User -->
    <input type="button" value="Adicionar Usuário"
        onclick="window.location.href='usuario-form.jsp'; return false;"
        class="add-user-button" />
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Tipo de Usuário</th>
            <th>Ações</th>
        </tr>
        <c:forEach var="tempUsuario" items="${USUARIO_LIST}">
            <tr>
                <td>${tempUsuario.id}</td>
                <td>${tempUsuario.login}</td>
                <td>${tempUsuario.email}</td>
                <td>${tempUsuario.senha}</td>
                <td>${tempUsuario.tipoUsuario}</td>
                <td>
                    <a href="UsuarioControllerServlet?command=LOAD&usuarioId=${tempUsuario.id}">Update</a>
                    <a href="UsuarioControllerServlet?command=DELETE&usuarioId=${tempUsuario.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
