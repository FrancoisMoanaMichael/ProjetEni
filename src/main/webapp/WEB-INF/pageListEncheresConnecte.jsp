<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listes des ench�res</title>
</head>
<body>
	<header>
		<h1>ENI-Encheres</h1>
		<a href="connexion">D�connexion</a>
	</header>
	<section>
		<h2>Listes des ench�res</h2>
		<div>
			<form action="connexion" method="post">
				<h3>Filtres:</h3>
				<input type="search" class="form-control" name="recherche">
				<div class="form-group">
					<label for="login">Cat�gorie : </label> <select name="categorie">
						<option value="">
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">V�tement</option>
						<option value="sportLoisirs">Sport&Loisirs</option>
					</select>
					<button>Rechercher</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>