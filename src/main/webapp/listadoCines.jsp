<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de cines</title>
</head>
<body>
	<fieldset>
		<legend>
			Lista de cines de "
			<c:out value="${requestScope.lugar}" />
			"
		</legend>

		<c:forEach items="${requestScope.cines}" var="cine" end="8">
			<span><c:out value="${cine.name}" /> - <c:out
					value="${cine.geometry.location.lat}"></c:out>-  
					<c:out value="${cine.geometry.location.lng}"></c:out> </span>
					- <c:out value="${cine.opening_hours.open_now}"></c:out>
			<br />
		</c:forEach>


	</fieldset>

</body>
</html>