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
			<a class="navbar-brand" href="/ProjetEni/acceuil">ENI-Encheres</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<c:if test="${sessionScope.utilisateurConnecte != null}">
						<li class="nav-item"><a class="nav-link dark"
							href="mon_profil"><p>Bonjour
									${sessionScope.utilisateurConnecte.pseudo}</p></a></li>
						<li class="nav-item"><a class="nav-link" href="acceuil">Enchères</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="vendre_un_article">Vendre un article</a></li>
						<li class="nav-item"><a class="nav-link" href="mon_profil">Mon
								Profil</a></li>
						<li class="nav-item"><a class="nav-link" href="deconnexion">Déconnexion</a>
						</li>
					</c:if>
					<c:if test="${sessionScope.utilisateurConnecte == null}">
						<li class="nav-item"><a class="nav-link" href="connexion">Connexion</a>
						</li>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
	<section class="container mt-5">
		<h2>Liste des enchères</h2>
		<div class="row">
			<div class="col-md-6">
				<form action="acceuil" method="post">
					<h3>Filtres:</h3>
					<div class="form-group">
						<input type="search" class="form-control" name="recherche"
							placeholder="Rechercher...">
					</div>
					<div class="form-group">
						<label for="categorie">Catégorie :</label> <select
							class="form-control" id="categorie" name="categorie">
							<option value="">aucun</option>
							<c:forEach var="cat" items="${categories}">
								<option value="${cat.no_categorie}">${cat.libelle}</option>
							</c:forEach>
						</select>
					</div>
					<c:if test="${sessionScope.utilisateurConnecte != null}">
						<div class="form-group">
							<div>
								<div>
									<input type="radio" name="achat" id="achat"
										class="form-check-input"> <label
										class="form-check-label">Achats</label>
								</div>
								<div>
									<input type="checkbox" name="enchereOuvert" id="enchereOuvert"
										class="form-check-input"> <label
										class="form-check-label">enchères ouvertes</label>
								</div>
								<div>
									<input type="checkbox" name="enchèreEnCours"
										id="enchereEnCours" class="form-check-input"> <label
										class="form-check-label">mes enchères en cours</label>
								</div>
								<div>
									<input type="checkbox" name="enchereRemporter"
										id="enchereRemporter" class="form-check-input"> <label
										class="form-check-label">mes enchères remportées</label>
								</div>
							</div>
							<div>
								<div>
									<input type="radio" id="achat2" class="form-check-input">
									<label class="form-check-label">Mes ventes</label>
								</div>
								<div>
									<input type="checkbox" name="ventEnCours" id="enchereOuvert2"
										class="form-check-input"> <label
										class="form-check-label">mes ventes en cours</label>
								</div>
								<div>
									<input type="checkbox" name="ventNonDebutees"
										id="enchereEnCours2" class="form-check-input"> <label
										class="form-check-label">ventes non débutées</label>
								</div>
								<div>
									<input type="checkbox" name="ventesTerminee"
										id="enchereRemporter2" class="form-check-input"> <label
										class="form-check-label">ventes terminées</label>
								</div>
							</div>
						</div>
					</c:if>
					<button type="submit" name="btnRechercher" value="rechercher"
						class="btn btn-primary">Rechercher</button>
				</form>
			</div>
		</div>
	</section>
	<article class="container mt-5">
		<div class="row">
			<c:forEach var="art" items="${articles}">
					<div class="col-md-4 mb-4">
						<div class="card">
						<a href="encherir/${art.no_article}"> <img
							class="card-img-top"
							src="https://picsum.photos/200?random=${art.no_article}"
							alt="Image">
						</a>
						<div class="card-body">
								<h3 class="card-title">${art.nom_article}</h3>
								<p class="card-text">Prix : ${art.prix_vente} points</p>
								<p class="card-text">Fin de l'enchère :
									${art.date_fin_encheres}</p>
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
