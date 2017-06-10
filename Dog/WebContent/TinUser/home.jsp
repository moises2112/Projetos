<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label>Bem vindo:<c:out value="${usuarioLogado.nome}" /></label>
	<input type="button" value="Logout"
		onClick="window.location.href='LoginController.do?action=logout'" />
	<div>
		<fieldset>
			<h2>Meus cachorros</h2>
			<table border=2>
				<tr>
					<td>Nome</td>
					<td>Ra�a</td>
					<td>Sexo</td>
				</tr>

				<c:forEach items="${myDogs}" var="dog">
					<tr>
						<td><c:out value="${dog.nome}" /></td>
						<td><c:out value="${dog.raca}" /></td>
						<td><c:out value="${dog.sexo}" /></td>
						<td><Button>Editar</Button></td>
						<td><Button>Remover</Button></td>
					</tr>
				</c:forEach>

			</table>
		</fieldset>
	</div>
	<div id="cadastroDog">
		<form
			action="CachorroController.do?action=cadastrar&Usuario=<c:out value="${usuarioLogado}"/>"
			method="post">
			<div>
				<label for="nome">Nome</label> <input type="text" name="nome"
					placeholder="Peludinho" />
			</div>
			<div>
				<label for="raca">Raca</label> <input type="text" name="raca"
					placeholder="Yorkshine" />
			</div>
			<div>
				<label for="sexo">Sexo</label> <input type="text" name="sexo"
					placeholder="M ou F" />
			</div>
			<div>
				<label for="idade">Idade</label> <input type="number" name="idade"
					placeholder="Idade em anos" />
			</div>
			<div>
				<input type="submit" value="Cadastrar Dog" />

			</div>
		</form>
	</div>

</body>
</html>