<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.objis.gestionformationssession.metier.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<head>
		<meta charset="ISO-8859-1">
		<title>Accueil</title>
	</head>
	<body>
		
		<div class="w3-container w3-blue">
  		<h2>Bienvenue, vous êtes sur la page d'accueil</h2>
	</div>
		<form action="AuthentificationServlet" method="post">
		
			<p>
  			<label>Email</label>
			<input disabled class="w3-input" name="login" placeholder="<c:out value="${utilisateur.login}"/>" ></p>
			<p>
		  	<label>Mot de passe</label>
		  	<input disabled class="w3-input" name="password" placeholder="<c:out value="${utilisateur.password}"/>"></p>
		 	<p>
			<label>ID de la session</label>
			<input disabled class="w3-input" name="id" placeholder="<c:out value="${pageContext.session.id}"/>"></p>
		
		</form>
	</body>
</html>