<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banco</title>
</head>
<body>
	<h1>Bem vindo ${name}</h1>
	<p><a href="${pageContext.request.contextPath}/user/saque">Saque</a></p>
	<p><a href="${pageContext.request.contextPath}/user/deposito">Depósito</a></p>
	<p><a href="${pageContext.request.contextPath}/user/saldo">Saldo</a></p>
	<p><a href="${pageContext.request.contextPath}/user/extrato">Extrato</a></p>
</body>
</html>