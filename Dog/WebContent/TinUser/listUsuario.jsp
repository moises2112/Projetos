<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apresentar todos os Usuarios</title>
</head>
<body>
<label>Bem vindo:<c:out value="${usuarioLogado.nome}" /></label>
<br>
<br>
	<h2>Lista de Usuários:</h2>

    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>email</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaDeUsuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.idUsuario}" /></td>
                    <td><c:out value="${usuario.nome}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><c:out value="${usuario.senha}" /></td>
                    <td><a
                        href="UsuarioController.do?action=editar&usuarioId=<c:out value="${usuario.idUsuario}"/>">editar</a></td>
                    <td><a
                        href="UsuarioController.do?action=remover&usuarioId=<c:out value="${usuario.idUsuario}"/>">remover</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="UsuarioController.do?action=inserir">Adicionar Usuario</a>
    </p>
</body>
</html>