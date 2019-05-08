<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<p>Encuentra tu película favorita y mira su tráiler</p>

	</div>

	<div class="centrado_inicialbtn">
		<form id="" action="PeliculasController" >
			<input type="text" name="name" value=> <input
				class="submit" type="submit" name="searchBtn" title="search"
				value="Buscar">
		</form>
	</div>
	
	

	<div id="actualesDiv">
		<form id="actualesForm" action="PeliculasActualesSearchController"
			method="post">

			<br> Películas actuales en la cartelera.<br> <br> <input
				type="submit" name="" value="Ver Cartelera">
		</form>
	</div>
	
	<div id="">
		<form id="" action="ListCalendarSearchController"
			method="post">

			<br> Id de tu calendario.<br> <br> <input
				type="submit" name="" value="Calendario">
		</form>
	</div>



	<img class="logomd" src="images/logo.jpeg"
		alt="Fallo en la carga de imagen">


</body>
</html>