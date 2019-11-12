<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<h2>Preencha os campos corretamente</h2>
	</c:if> 
	<h1>Cadastro de novo usuário</h1>
	<form action="cadastro" method="POST">
		<div class="row">
			<div class="input-field col s12">
				<label for="name" class="active">Nome:</label>
				<input id="name" type="text" name="name" />
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<label for="password" class="active">Senha:</label>
				<input id="password" type="text" name="password" />
			</div>
		</div>
		<p>
			<button type="submit" class="waves-effect waves-light btn green darken-3">Salvar</button>
		</p>
	</form>
	<a href="${pageContext.request.contextPath}/admin/lista">Voltar</a>
</body>
</html>