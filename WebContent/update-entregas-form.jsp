<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Entrega</title>
    <!-- Adicione seus estilos CSS, se necessário -->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Atualizar Entrega</h1>
    
    <c:if test="${not empty entrega}">
        <form action="EntregaServlet?action=atualizar" method="post">
    <input type="hidden" name="id" value="${entrega.id}" />
    
    <label for="conteudo">Conteúdo:</label><br/>
    <textarea id="conteudo" name="conteudo" rows="4" cols="50">${entrega.conteudo}</textarea><br/><br/>
    
    <input type="submit" value="Atualizar Conteúdo" />
</form>
    </c:if>
    
    <c:if test="${empty entrega}">
        <p>Entrega não encontrada ou inválida.</p>
    </c:if>
    
    <p><a href="listar-entregas.jsp">Voltar para a lista de entregas</a></p>
</body>
</html>
