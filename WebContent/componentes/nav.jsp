<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="navbar navbar-expand-lg fixed-top navbar-scroll">
    <div class="container">
        <div class="logo-container">
            <img src="imagens/undf.png" alt="Logo UnDF" class="logo-undf" width="95px" height="50px">
        </div>
        <p class="welcome-message">Bem-vindo(a), ${sessionScope.usuarioNome}!</p>
    </div>
</nav>