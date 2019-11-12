<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<h2>Usuário ou senha inválidos</h2>
	</c:if> 
	<h1>Login</h1>
	<form action="login" method="POST">
		<div class="row">
			<div class="input-field col s12">
				<label for="username" class="active">Usuário:</label>
				<input id="username" type="text" name="username" />
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<label for="password" class="active">Senha:</label>
				<input id="password" type="password" name="password" />
			</div>
		</div>
		<p>
			<button type="submit" class="waves-effect waves-light btn green darken-3">Enviar</button>
		</p>
	</form>
</body>
</html>