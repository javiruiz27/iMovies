<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informaci�n de la pel�cula</title>
</head>
<body>

	<fieldset>
	<legend>Mostrando informaci�n de "<c:out value="${requestScope.titulo}" />" </legend>


	<span>Fecha de estreno: <c:out value="${requestScope.fechaEstreno}"/> </span><br/>
	<span>Identificador de TMDB: <c:out value="${requestScope.imdbID}"/> </span><br/>
	<span>Sinopsis: <c:out value="${requestScope.overview}"/> </span><br/>
	</fieldset>

	<a class="" href="index.jsp">Inicio</a>

	<a class="" href="/PeliculasActualesSearchController">Volver atr�s</a>


</body>
</html>