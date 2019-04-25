<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busca tu cine más cercano</title>
</head>
<body>

	<h1>ENCUENTRA TU CINE MÁS CERCANO</h1>

	<div class="container">

		<p class="message"></p>

		<form action="PlacesSearchController" method="post">
			<input type="text" name="searchQuery" value=> <input
				class="submit" type="submit" name="searchBtn" title="search"
				value="Buscar">
		</form>
	</div>

</body>
</html>