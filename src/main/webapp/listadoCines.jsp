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
	<div>
	
	 <legend>
			Tiempo en  "
			<c:out value="${requestScope.lugar}" />
			"
		</legend>
	  <table width="575" border="1" cellspacing="2">
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
    <div>
     <table width="575" border="1" cellspacing="2">
        <tr>
           
            <th>Descripción</th>
        </tr>    
              <c:forEach items="${requestScope.tiempo}" var="tiempo">
            <tr align="center">
              <c:forEach items="${tiempo.weather}" var="weather">
              
              <td> <c:out value="${weather.description}" /> 
              </c:forEach>
              </tr>
		</c:forEach>
                
            <!--    <td><img src="https://openweathermap.org/themes/openweathermap/assets/vendor/owm/img/widgets/02n.png" alt="Smiley face" height="42" width="42"> </td>-->
                 
           		
    </table>
	</div>
		
	<!--  	Fecha<c:out value="${requestScope.fechas}"/>
 	<c:forEach items="${requestScope.tiempo}" var="tiempo">
 	

 		<c:forEach items="${tiempo.weather}" var="weather">
		<c:out value="${weather.description}" /> 
			<br />
		</c:forEach>
		</c:forEach>


	</fieldset>
	-->
<div id="openweathermap-widget-15"></div>
<script>window.myWidgetParam ? window.myWidgetParam : window.myWidgetParam = [];  window.myWidgetParam.push({id: 15,cityid: '6361046',appid: '4812afad37956a4a23bc9cd4e9878b7c',units: 'metric',containerid: 'openweathermap-widget-15', lang: 'es'  }); 
(function() {var script = document.createElement('script');script.async = true;script.charset = "utf-8";script.src = "//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/weather-widget-generator.js";
var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(script, s);  })();</script>

</body>




</html>