<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<head>
<meta charset="UTF-8">
<title>iMovies</title>
<link rel="stylesheet" href="css/iMovies.css">
</head>
<% String controller = "/googleDriveFileNew"; %>

<c:if test="${not empty file}">
    <% controller = "/googleDriveFileUpdate";%>
</c:if>

<div class="container">

    <p class="message">${message}</p>

    <form action="<%= controller%>" method="post">
        <c:if test="${not empty file}">
            <input type="hidden" name="id" value="${file.id}">
        </c:if>
        <label for="title">File name:</label>
        <input type="text" name="title" id="title"
               <c:if test="${not empty file}">
                   disabled="true" 
                   value="${file.title}"
               </c:if>
               />
        <label for="content">Content:</label>
        <textarea id="content" name="content">${content}</textarea>

        <div class="bottom_links">
            <button type="submit" class="button">Submit</button>
            <button type="button" onClick="javascript:window.location.href = '/'" class="button">Cancel</button>
        </div>
    </form>
</div>

