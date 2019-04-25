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

	<!--  	<div class="">
			<input class="" type="button" value="Ver trailer"
				onclick="if (this.parentNode.nextSibling.childNodes[0].style.display != '') { this.parentNode.nextSibling.childNodes[0].style.display = ''; this.value = 'Ocultar'; } else { this.parentNode.nextSibling.childNodes[0].style.display = 'none'; this.value = 'Ver trailer'; }" />
		</div>
		<div>
			<div class="" style="display: none;">
				<iframe width="420" height="345"
					src="https://www.youtube.com/embed/<c:out value="${requestScope.url}"/>">
				</iframe>
			</div>
		</div>-->
		

	</fieldset>



	<a class="" href="index.jsp">Inicio</a>

	<a class="" href="/PeliculasActualesSearchController">Volver atr�s</a>


</body>
</html>