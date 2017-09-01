<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>JDTLサンプル</title>
</head>
<body>

<h2>条件分岐のサンプル</h2>
<c:if test="${sample == 'sample'}">
	<p>サンプル</p>
</c:if>
<c:if test="${sample == 'sample2'}">
	<p>サンプル2</p>
</c:if>



<h2>繰り返しのサンプル</h2>
<c:forEach var="item" items="${sampleList}">
	<c:out value="${item}" />
</c:forEach>
</body>
</html>