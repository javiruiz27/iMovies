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
	<div id =places>
	<div id =cines>
		<c:forEach items="${requestScope.cines}" var="cine" end="8">
			<c:out value="${cine.name}" /><br><br>
			</c:forEach>
			</div>
		<div id =urlCines>
		<c:forEach items="${requestScope.urlCine}" var="url" end="8">
		<a href="${url}"><c:out value="${url}"/></a><br><br>
			</c:forEach>
			</div>
			
			</div>
			
			
					
			<br />
		
</fieldset>

<h3>Este es el tiempo que hará durante los próximos 5 días en <c:out value="${requestScope.lugar}"></c:out></h3>

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
            
            <th>Descripción</th>
        
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
                <td>    <c:out value="${temperatura} "/> ºC   </td> 
               
                </tr>
                 </c:forEach>

          </table>
    </div>
    
    </div>
    
<div id=volver>
<br><a class ="button" href="javascript:history.back()"> Volver Atrás</a>
 </div>
    
</body>




</html>