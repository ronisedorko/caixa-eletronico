<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista</title>
</head>
<body>
	<h1>Lista de Clientes</h1>
	<table class="table" border="2">
		<tr>
			<th>Usuário</th>
			<th>Papel</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="lista" method="POST">
		<p>
			<button type="submit" class="waves-effect waves-light btn green darken-3">Cadastrar novo</button>
		</p>
	</form>
</body>
</html>