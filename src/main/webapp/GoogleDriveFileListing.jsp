<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html><head>
<meta charset="UTF-8">
<title>iMovies</title>
<link rel="stylesheet" href="css/iMovies.css">
</head>
<body>

<h1>Ficheros en Google Drive</h1>

<div class="container">

    <p class="message">${message}</p>

    <table border=1  id="files">
        <tr class="bg-primary">
            <th>Name</th>
            <th>Size</th>
            <th>Last modification date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.files.items}" var="file">
            <tr class="bg-success">
                <td class="bg-primary"><c:out value="${file.title}"/></td>
                <td class="bg-success"><c:out value="${file.fileSize}"/></td>
                <td class="bg-primary"><c:out value="${file.modifiedDate}"/></td>
                <td class="bg-success">
                    <a href="/googleDriveFileUpdate?id=${file.id}"><img src="./images/edit.png" width="30px"></a>
                </td>
                <td class="bg-primary">
                    <a href="/googleDriveFileDelete?id=${file.id}"><img src="./images/delete.png" width="30px"></a>
                </td>
            </tr>
        </c:forEach>			
    </table>
    <p>
        <button type="button" onClick="javascript:window.location.href = '/'" class="button">Back</button>
</div>

</body>
</html>

