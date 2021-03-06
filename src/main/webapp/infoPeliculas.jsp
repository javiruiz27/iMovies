<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información de la película</title>
<link rel="stylesheet" href="css/iMovies.css">
</head>
<body>
<% String controller = "/googleDriveFileNew"; %>

<c:if test="${not empty file}">
    <% controller = "/googleDriveFileUpdate";%>
</c:if>


	<img alt="Poster" src="${requestScope.url2}"> 	
  
	<object
 	 type="application/x-shockwave-flash"
 	 data="${requestScope.url3}"
  	style="width: 640px; height:360px;">
 	 <param
  	  name="movie"
   	 value="${requestScope.url3}">
 	 ERROR (no puede mostrarse el video)
	</object>
	<c:if test="${requestScope.actuales=='si'}">
		<form action="PlacesSearchController" method="post">
		<p>¿En que ciudad te encuentras?</p>
			<input type="text" name="ciudad" value=> <input
				class="button" type="submit" name="searchBtn" title="search"
				value="Buscar">
		</form>
		</c:if>
		
 	<form action="/RateController" method="post">
		<p>Valora la película</p>
			<input type="hidden" name="idpelicula" value="${requestScope.imdbID}"/>
			<input type="number" name="rate" /> 
			<input	class="button" type="submit" name="searchBtn" title="search"
				value="Valorar">
	</form>
	
	<form action="<%= controller%>" method="post">
		<p>Añade la pelicula a Google Drive</p>
			<input type="hidden" name="id" value="${file.id}"/>
			<input type="hidden" name="title" id="title" value="${requestScope.titulo}">
			<input type="hidden" name="content" value="${requestScope.overview}"> 
			<input	class="button" type="submit" name="searchBtn" title="search"
				value="Añadir">
	</form>

	<fieldset>
		<legend>
			Mostrando información de "
			<c:out value="${requestScope.titulo}" />
			"
		</legend>


		<span>Fecha de estreno: <c:out
				value="${requestScope.fechaEstreno}" />
		<br>		
		</span><br /> <span>Identificador de TMDB: <c:out
				value="${requestScope.imdbID}" />
		<br>		
		</span><br /> <span>Sinopsis: <c:out value="${requestScope.overview}" />
		<br>
		</span><br />
		
	

	 <br>
			
		

	</fieldset>
	

<br></br>
	<a class="button" href="index.jsp">Inicio</a>
	

	
	<a class="button" href="javascript:history.back()"> Volver Atrás</a>
	
	
	


</body>
</html>