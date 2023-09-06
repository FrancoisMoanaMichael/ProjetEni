<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Liste des enchères</title>
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
		                        <a class="nav-link" href="connexion">Connection</a>
		                    </li> 
				</ul>
			</div>
		</nav>
	</header>
	<section class="container mt-5">
		<h2>Liste des enchères</h2>
		<div class="row">
			<div class="col-md-6">
				<form action="connexion" method="post">
					<h3>Filtres:</h3>
					<div class="form-group">
						<input type="search" class="form-control" name="recherche"
							placeholder="Rechercher...">
					</div>
					<div class="form-group">
						<label for="categorie">Catégorie :</label> <select
							class="form-control" id="categorie" name="categorie">
							<option value=""></option>
							<option value="informatique">Informatique</option>
							<option value="ameublement">Ameublement</option>
							<option value="vetement">Vêtement</option>
							<option value="sportLoisirs">Sport & Loisirs</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Rechercher</button>
				</form>
			</div>
		</div>
	</section>
	<article class="container mt-5">
		<div class="row">
			<c:forEach var="art" items="${articles}" >
				<div class="col-md-4 mb-4">
					<div class="card">
						<img class="card-img-top" src="https://picsum.photos/200?random=${art.no_article}" alt="Image">
						<div class="card-body">
							<h3 class="card-title">${art.nom_article}</h3>
							<p class="card-text">Prix : ${art.prix_vente} points</p>
							<p class="card-text">Fin de l'enchère : ${art.date_fin_encheres}</p>
							<p class="card-text">Vendeur : ${art.utilisateur.pseudo}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</article>

	<!-- Inclure les fichiers JavaScript de Bootstrap (jQuery et Popper.js requis) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
