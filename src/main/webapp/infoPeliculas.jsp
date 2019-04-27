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


<img alt="Poster" src="${requestScope.url2}"> 	

<object
  type="application/x-shockwave-flash"
  data="${requestScope.url3}"
  style="width: 640px; height:360px;">
  <param
    name="movie"
    value="${requestScope.url3}">
  ERROR (no puede mostrarse el objeto)
</object>



	<fieldset>
		<legend>
			Mostrando informaci�n de "
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
	

	
	<a href="javascript:history.back()"> Volver Atr�s</a>
	
	
	


</body>
</html>