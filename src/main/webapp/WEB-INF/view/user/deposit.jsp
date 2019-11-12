<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Depósito</title>
</head>
<body>
	<c:if test="${param.sucess != null}">
		<h2>Seu depósito foi realizado com sucesso</h2>
	</c:if> 
	<h1>Depósito</h1>
	<form action="${pageContext.request.contextPath}/user/deposito" method="POST">
		<div class="row">
			<div class="input-field col s12">
				<label for="deposit" class="active">Depósito:</label>
				<input id="deposit" type="text" name="deposit" />
			</div>
		</div>
		<p>
			<button type="submit" class="waves-effect waves-light btn green darken-3">Depositar</button>
		</p>
	</form>
	
	<a href="${pageContext.request.contextPath}/user">Voltar</a>
</body>
</html>