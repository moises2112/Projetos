<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Adicionar novo Usuario</title>
</head>
<body>
    <form action="UsuarioController.do" method="post">
        <fieldset>
            <div>
                <label for="usuarioId">Usuario ID:</label> <input type="text"
                    name="usuarioId" value="<c:out value="${usuario.id}" />"
                    readonly="readonly" placeholder="Usuario ID" />
            </div>
            <div>
                <label for="nome">Nome:</label> <input type="text"
                    name="nome" value="<c:out value="${usuario.nome}" />"
                    placeholder="nome" />
            </div>
            <div>
                <label for="email">Email</label> <input type="text"
                    name="email" value="<c:out value="${usuario.email}" />"
                    placeholder="email" />
            </div>
            <div>
                <label for="senha">Senha</label> <input type="password" name="senha"
                    value="<c:out value="${usuario.senha}" />" placeholder="senha" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>