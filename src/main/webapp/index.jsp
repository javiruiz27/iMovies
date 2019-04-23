<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iMovies</title>
<link rel="stylesheet" href="css/iMovies.css">
</head>
<body>

	<div class=btn_face>
		<tr></tr>
		<td><a href="/editPost.jsp"><img src="images/facebook.png"
				alt="Conecta con Facebook"></a></td>
		</tr>
	</div>

	<div class="centrado_inicialTit">
		<h1>iMovies</h1>
	</div>
	<div class="centrado_inicialText">
		<p>Find your favorite movie, watch the trailer and find your
			nearest cinema</p>


	</div>

	<div class="centrado_inicialbtn">
		<form id=action=>
			<input type="text" name="searchQuery" value=> <input
				class="submit" type="submit" name="searchBtn" title="search"
				value="Buscar">
		</form>
	</div>

	<div id="actualesDiv">
		<form id="actualesForm" action="PeliculasActualesSearchController"
			method="post">

			<br> Current movies on the billboard<br> <br> <input
				type="submit" name="" value="Ver Cartelera">
		</form>
	</div>



	<img class="logomd" src="images/logo.jpeg"
		alt="Fallo en la carga de imagen">


</body>
</html>