<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<title>Página Inicial</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/componentes.css">
<link rel="stylesheet" href="css/login.css">
<link rel="icon" type="image/png" sizes="16x16" href="imagens/favicon-undf.png">
</head>

<body>
	<div class="wrapper">
		<img src="imagens/undf.png" alt="Logo UnDF" class="logo" />
		<h1>Bem-vindo(a)!</h1>
		<p>Por favor, selecione o tipo de usuário:</p>

		<!-- Verificar se existe uma mensagem de erro e exibi-la -->
		<c:if test="${not empty erroLogin}">
			<p class="error-message">${erroLogin}</p>
		</c:if>

		<div class="form-container">

			<div class="slide-controls">
				<input type="radio" name="slider" id="login" checked></input> <input
					type="radio" name="slider" id="senha"></input> <label for="login"
					class="slide login">Login</label> <label for="senha"
					class="slide senha">Nova senha</label>
				<div class="slide-tab"></div>
			</div>

			<div class="form-inner">
				<!-- LOGIN FORM -->
				<form action="IndexServlet" method="post" class="login">

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
						<input type="text" id="login" name="login" placeholder="Usuário"
							required>
					</div>

					<label for="senha">Senha:</label>
					<div class="field">
						<input type="password" id="senha" name="senha" placeholder="Senha"
							required>
					</div>

					<div class="senha-link">
						<a href="#">Esqueceu a senha?</a>
					</div>

					<input type="submit" value="Acessar">
				</form>

				<!-- SENHA FORM -->
				<form action="#" method="post" class="senha">

					<div class="field">
						<input type="password" placeholder="Nova senha" required>
					</div>

					<div class="field">
						<input type="password" placeholder="Confirmar senha" required>
					</div>

					<div class="senha-link">
						<a href="#">Esqueceu a senha?</a>
					</div>

					<input type="submit" value="Redefinir">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
