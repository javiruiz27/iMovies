<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>iMovies</title>
<link rel="stylesheet" href="css/iMovies.css">
</head>
<body>



	<div class="centrado_inicialTit">
		<h1>iMovies</h1>
	</div>
	<div class="centrado_inicialText">
		<p>Encuentra su película favorita y mira su tráiler</p>

	</div>

	<div class="centrado_inicialText">
		<form id="" action="PeliculasController" >
			<input type="text" name="name" value=> <input
				class="button" type="submit" name="searchBtn" title="search"
				value="🔎">
		</form>
	</div>
	
	


	
	<div class="centrado_inicialText" id="">
	<form id="actualesForm" action="PeliculasActualesSearchController"
			method="post">
			<br> Películas actuales en la cartelera<br> <br> <input
				class="button" type="submit" name="" value="Ver Cartelera">
			
		</form>
	</div>
	



	<img class="logo" src="images/logo.jpeg"
		alt="Fallo en la carga de imagen">


</body>
</html>