<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Información de la película</title>
</head>
<body>


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
				class="submit" type="submit" name="searchBtn" title="search"
				value="Buscar">
		</form>
		</c:if>



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
	



	<a class="" href="index.jsp">Inicio</a>
	

	
	<a href="javascript:history.back()"> Volver Atrás</a>
	
	
	


</body>
</html>