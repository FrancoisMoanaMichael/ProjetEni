<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vente d'article</title>
<!-- Inclure les fichiers CSS de Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">ENI-Encheres</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="acceuil">Enchères</a>
						<a class="nav-link" href="vendre_un_article">Vendre un article</a>
						<a class="nav-link" href="mon_profil">Mon Profil</a>
						<a class="nav-link" href="deconnexion">Déconnexion</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<h4 style="color:red">${message}</h4>
	<h2>Mettre un article en vente</h2>
	<div class="row">
		<div class="col-md-6">
			<form action="vendre_un_article" method="post">
				<div class="form-group">
				    <label for="categorie">Catégorie :</label>
				    <select class="form-control" id="categorie" name="categorie">
				        <option value=""></option>
				        <c:forEach items="${categories}" var="c">
				            <option value="${c.no_categorie}"><c:out value="${c.libelle}"/></option>
				        </c:forEach>
				    </select>
				</div>
				<div class="form-group">
					<label for="nom_article">Nom de l'article :</label>
					<input type="text" class="form-control" id="nom_article" name="nom_article" maxlength="30">
				</div>
				<div class="form-group">
					<label for="description">Description :</label>
					<textarea class="form-control" id="description" name="description" maxlength="300"></textarea>
				</div>
				<div class="form-group">
					<label for="date_debut_encheres">Date de début d'enchères :</label>
					<input type="date" class="form-control" id="date_debut_encheres" name="date_debut_encheres">
				</div>
				<div class="form-group">
					<label for="date_fin_encheres">Date de fin d'enchères :</label>
					<input type="date" class="form-control" id="date_fin_encheres" name="date_fin_encheres">
				</div>
				<div class="form-group">
					<label for="prix_initial">Prix initial :</label>
					<input type="number" class="form-control" id="prix_initial" name="prix_initial">
				</div>
				<h3>Modalités du retrait</h3>
				<div class="form-group">
					<label for="rue">Rue :</label>
					<input type="text" class="form-control" id="rue" name="rue" maxlength="30">
				</div>
				<div class="form-group">
					<label for="code_postal">Nom de l'article :</label>
					<input type="text" class="form-control" id="code_postal" name="code_postal" maxlength="15">
				</div>
				<div class="form-group">
					<label for="ville">Nom de l'article :</label>
					<input type="text" class="form-control" id="ville" name="ville" maxlength="30">
				</div>
				<button type="submit" class="btn btn-primary">Vendre</button>
			</form>
		</div>
	</div>
</body>
</html>
