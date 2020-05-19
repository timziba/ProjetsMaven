<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="com.objis.gestionformationssession.metier.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<head>
		<meta charset="ISO-8859-1">
		<title>users</title>
	</head>
	<body>
		
		<ul>
		<c:forEach items="${utilisateurs}" var="utilisateur" varStatus="status">
			<li><c:out value="${status.count}"/> <c:out value="${utilisateur.login}"/></li>
		</c:forEach>
		</ul>
		<div class="w3-container w3-blue">
  		<h2>Listes des utilisateurs </h2>
  		

  	
	</div>

	</body>
</html>