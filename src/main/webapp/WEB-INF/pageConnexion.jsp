<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
</head>

<body>
	<h1>Connexion</h1>
	<form action="loginServlet" method="post">
	
		login:<input type="text" name="login"/>
		
		password:<input type="password" name="password"/>
		<input type="submit" value="Connexion"/>
		<input type="checkbox" value="Se souvenire de moi">
		<!-- <a  href="recoverLoginServlet">Mot de passe oublié</a> --> 	
	</form>
	${message}
		<button onclick="pagesCreeCompte">Créer un compte</button>	
</body>
</html>