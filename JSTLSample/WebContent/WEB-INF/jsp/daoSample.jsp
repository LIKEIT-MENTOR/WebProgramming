<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Daoサンプル</title>
</head>
<body>


<form action="DaoSample" method="POST">
	<p>login_id<input name="login_id" type="text"></p>
	<p>name:<input name="name" type="text"></p>
	<p>birth_date_from:<input name="birth_date_from" type="date"></p>
	<p>birth_date_to:<input name="birth_date_to" type="date"></p>
	<button type="submit" name="action">検索</button>

</form>



<table>
	<tr>
		<th>ID</th>
		<th>LoinID</th>
		<th>Name</th>
		<th>birthDate</th>
	</tr>
	<tr>
		<c:forEach var="user" items="${userList}">
			<td>
				<c:out value="${user.id}" />
			</td>
			<td>
				<c:out value="${user.loginId}" />
			</td>
			<td>
				<c:out value="${user.name}" />
			</td>
			<td>
				<c:out value="${user.birthDate}" />
			</td>
		</c:forEach>
	</tr>
</table>
</body>
</html>