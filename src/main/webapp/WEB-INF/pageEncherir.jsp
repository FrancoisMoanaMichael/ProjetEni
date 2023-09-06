<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détail Vente</title>
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
					<li class="nav-item"><a class="nav-link" href="acceuil">Enchères</a>
						<a class="nav-link" href="vendre_un_article">Vendre un article</a>
						<a class="nav-link" href="mon_profil">Mon Profil</a> <a
						class="nav-link" href="acceuil">Déconnexion</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<h2 class="text-center">Détail Vente</h2>

	<div class="row p-5">
		<div class="col-md-6">
			<img
				src="https://t3.ftcdn.net/jpg/05/17/82/24/360_F_517822417_cW17ljcETUNX8BylhlNesxWyhxHXO3Nc.jpg"
				alt="${enchere.article.nom_article}" class="img-fluid" />
		</div>
		<div class="col-md-6">

			<h3 class="text-uppercase">${enchere.article.nom_article}</h3>
			<p>Description : ${enchere.article.description}</p>
			<p>Catégorie : ${enchere.article.categorie}</p>
			<p>Meilleur offre : ${enchere.montant_enchere} pts par
				${enchere.utilisateur.pseudo}</p>
			<p>Mise à prix : ${enchere.article.prix_initial} points</p>
			<p>Fin de l'enchère : ${enchere.article.date_fin_encheres}</p>
			<p>Retrait : ${enchere.article.retrait}</p>
			<p>Vendeur : ${enchere.article.utilisateur}</p>

			<form id="formEncherir" method="post">
				<div class="form-group">
					<label for="montant">Ma proposition:</label> <input type="number"
						value=${enchere.montant_enchere }
						min=${enchere.montant_enchere
						} class="form-control"
						id="montant" name="montant"> <input type="hidden"
						name="id_enchere" value="${enchere.no_enchere}">
				</div>
				<button type="submit" class="btn btn-primary">Enchérir</button>
			</form>


		</div>
	</div>

	</div>

</body>
</html>
