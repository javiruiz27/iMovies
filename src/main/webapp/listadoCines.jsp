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

		<c:forEach items="${requestScope.cines}" var="cine" end="4">
			<span>Lugar: <c:out value="${cine.formattedAddress}" />
			</span>
			<br />
		</c:forEach>


	</fieldset>

</body>
</html>