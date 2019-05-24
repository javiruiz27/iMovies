<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de cines</title>
<link rel="stylesheet" href="css/places.css">
</head>
<body>

	<fieldset>
		<legend>
			Lista de cines en "
			<c:out value="${requestScope.lugar}" />
			"
		</legend>

		<c:forEach items="${requestScope.cines}" var="cine" end="8">
			<span><c:out value="${cine.name}" /> Coordenadas: <c:out
					value="${cine.geometry.location.lat}"></c:out>-  
					<c:out value="${cine.geometry.location.lng}"></c:out> </span>
					
			<br />
		</c:forEach>
</fieldset>

<h3>Este es el tiempo que har� durante los pr�ximos 5 d�as en <c:out value="${requestScope.lugar}"></c:out></h3>

<div id=grande>

	<div id=izquierda>
	
	 
	  <table border="1">
        <tr>
            <th>Fecha</th>
        
        </tr>
       
        <c:forEach items="${requestScope.fechas}" var="fecha">
            <tr align="center">
                <td> <c:out value=" ${fecha} "/> </td>
                </tr>
                 </c:forEach>

          </table>
    </div>
    
    	<div id=centroIzquierda>

	  <table  border="1" >
        <tr>
            
            <th>Descripci�n</th>
        
        </tr>
       
        <c:forEach items="${requestScope.description}" var="description">
            <tr align="center">
                <td>  <c:out value="${description} "/> </td> 
               
                </tr>
                 </c:forEach>

          </table>
    </div>
    
    <div id=centroDerecha>

	  <table  border="1" >
        <tr>
          <th>Iconos </th>
   
        </tr>
       
        <c:forEach items="${requestScope.urls}" var="url">
            <tr align="center">
                <td>  <img src="${url}" height="14" width="40"> </td> 
               
                </tr>
                 </c:forEach>

          </table>
    </div>
    
      <div id=derecha>

	  <table  border="1" >
        <tr>
          <th>Temperatura </th>
   
        </tr>
       
        <c:forEach items="${requestScope.temperatura}" var="temperatura">
            <tr align="center">
                <td>    <c:out value="${temperatura} "/> �C   </td> 
               
                </tr>
                 </c:forEach>

          </table>
    </div>
    
    </div>
    
</body>




</html>