<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saldo</title>
</head>
<body>
	<h1>Saldo</h1>
	<h3>O seu saldo é de ${balance}</h3>
	
	<a href="${pageContext.request.contextPath}/user">Voltar</a>
</body>
</html>