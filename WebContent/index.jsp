<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<title>Início</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/componentes.css">
<link rel="stylesheet" href="css/login.css">
<link rel="icon" type="image/png" sizes="16x16" href="imagens/favicon-undf.png">
</head>
<body>
    <div class="diamond-shapes">
        <div class="diamond"></div>
        <div class="diamond"></div>
		<div class="diamond"></div>
		<div class="diamond"></div>
		<div class="diamond"></div>                             
    </div>
    
	<div class="wrapper">
		<img src="imagens/undf.png" alt="Logo UnDF" class="logo" />
		<h1>SGA-IC</h1>
		<p>Bem-vindo(a) ao hub de pesquisa da UnDF.</p>
		<p>Escolha uma ação abaixo:</p>

		<!-- (LOGIN) Verificar se existe uma mensagem de erro e exibi-la -->
		<c:if test="${not empty erroLogin}">
			<p class="error-message">${erroLogin}</p>
		</c:if>
		
		<!-- (REDEFINIR SENHA) Verificar se existe uma mensagem de sucesso e exibi-la -->
		<c:if test="${not empty mensagemSucesso}">
		    <p class="success-message">${mensagemSucesso}</p>
		</c:if>
		
		<!-- (REDEFINIR SENHA) Verificar se existe uma mensagem de erro e exibi-la -->
		<c:if test="${not empty erroRedefinicao}">
		    <p class="error-message">${erroRedefinicao}</p>
		</c:if>

		<div class="form-container">

			<div class="slide-controls">
				<input type="radio" name="slider" id="login" checked></input> 
				<input type="radio" name="slider" id="senha"></input> 
					<label for="login" class="slide login">Login</label> 
					<label for="senha" class="slide senha">Nova senha</label>
				<div class="slide-tab"></div>
			</div>

			<div class="form-inner">
				<!-- LOGIN FORM -->
				<form action="IndexServlet" method="post" class="login">
					<!-- Tag escondida utilizada para passar informações adicionais no formulário sem que o usuário veja ou modifique -->
					<!-- Quando o usuário submete o formulário de login, o servlet execute a lógica de login -->
					<input type="hidden" name="action" value="login">

					<label for="tipoUsuario">Tipo de Usuário:</label>
					<div class="field">
						<select id="tipoUsuario" name="tipoUsuario">
							<option value="professor">Professor</option>
							<option value="coordenador">Coordenador</option>
							<option value="aluno">Aluno</option>
						</select>
					</div>

					<label for="login">Login:</label>
					<div class="field">
						<input type="text" id="login" name="login" placeholder="Usuário" required>
					</div>

					<label for="senha">Senha:</label>
					<div class="field">
						<input type="password" id="senha" name="senha" placeholder="Senha" required>
					</div>

					<div class="senha-link">
						<a href="#">Esqueceu a senha?</a>
					</div>

					<input type="submit" class="submit-acessar" value="Acessar">
				</form>

				<!-- SENHA FORM -->
				<form action="IndexServlet" method="post" class="senha">
					<!-- Tag escondida utilizada para passar informações adicionais no formulário sem que o usuário veja ou modifique -->
					<!-- Quando o usuário submete o formulário de redefinição de senha, o servlet execute a lógica de redefinição de senha -->
					<input type="hidden" name="action" value="redefinirSenha">
				
					<label for="tipoUsuarioRedefinir">Tipo de Usuário:</label>
				    <div class="field">
				        <select id="tipoUsuarioRedefinir" name="tipoUsuario">
				            <option value="professor">Professor</option>
				            <option value="coordenador">Coordenador</option>
				            <option value="aluno">Aluno</option>
				        </select>
				    </div>
    
					<label for="user">Usuário:</label>
					<div class="field">	
						<input type="text" id="user" name="user" placeholder="Usuário" required>
					</div>

					<label for="novaSenha">Digite sua nova senha:</label>
				    <div class="field">
				        <input type="password" id="novaSenha" name="novaSenha" placeholder="Nova senha" required>
				    </div>
				
					<label for="confirmarSenha">Confirme sua nova senha:</label>
				    <div class="field">
				        <input type="password" id="confirmarSenha" name="confirmarSenha" placeholder="Confirmar senha" required>
				    </div>

					<input type="submit" class="submit-redefinir" value="Redefinir">
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="scripts/login.js"></script>
</body>
</html>
