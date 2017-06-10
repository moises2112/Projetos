
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Bem vindo ao Tindog</title>
</head>
<body>
	<form action="LoginController.do?action=logar" method="post">

		<fieldset>
			<div>
				<label for="email">Email</label> <input type="text" name="email"
					placeholder="email" />
			</div>
			<div>
				<label for="senha">Senha</label> <input type="password" name="senha"
					placeholder="senha" />
			</div>
			<div>
				<input type="submit" value="Login" /> <input type="button"
					value="Cadastrar" onClick="window.location.href='./cadastrar.jsp'" />

			</div>

		</fieldset>
	</form>

	<label><c:out value="${erroAoLogar}" /></label>


</body>
</html>