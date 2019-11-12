<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Extrato</title>
</head>
<body>
	<h1>Extrato</h1>
	<table class="table" border="2">
		<tr>
			<th>Data</th>
			<th>Tipo</th>
			<th>Valor</th>
		</tr>
		<c:forEach var="transaction" items="${transactions}">
			<tr>
				<td>${transaction.date}</td>
				<td>${transaction.type}</td>
				<td>${transaction.value}</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="${pageContext.request.contextPath}/user">Voltar</a></p>
</body>
</html>