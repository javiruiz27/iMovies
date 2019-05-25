<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Películas Actuales</title>
<link rel="stylesheet" href="css/Cartelera.css">
</head>
<body>



	<fieldset id="tmdbCartelera">
		<legend>Cartelera </legend>
		<c:forEach items="${requestScope.pelActuales}" var="pelicula" end="7">
			<span>Pelicula: <c:out value="${pelicula.title}" /> (<c:out
					value="${pelicula.voteAverage}" />)
			</span>


			<form action="InfoController" method="post">


				<input name="titulo" type="hidden" value="${pelicula.title}">
				<input name="id" type="hidden" value="${pelicula.id}"> <input
					name="actuales" type="hidden" value="${requestScope.actuales}">


	


				<button class="button2" type="submit" class="button">Más
					información</button>

			</form>

			<br />


		</c:forEach>
	</fieldset>


	<a class="button" href="index.jsp">Volver al inicio</a>



</body>
</html>