<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
<!-- Ajoutez les liens vers les fichiers CSS de Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
					<li class="nav-item">
						<a class="nav-link" href="enchaeres">Enchères</a>
						<a class="nav-link" href="vendre_un_article">Vendre un article</a>
						<a class="nav-link" href="mon_profil">Mon Profil</a>
						<a class="nav-link" type="deconexion" href="acceuil">Déconnexion</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<section>
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-6 mx-auto">
					<div class="card">
						<div class="card-body">
							<form action="mon_profil" method="post">
								<label for="nom">Pseudo :</label>
								<p class="card-title">${sessionScope.utilisateurConnecte.pseudo}</p>
								<div class="form-group">
									<label for="nom">Nom
										:${sessionScope.utilisateurConnecte.nom}</label>
								</div>
								<div class="form-group">
									<label for="prenom">Prénom
										:${sessionScope.utilisateurConnecte.prenom}</label>
								</div>
								<div class="form-group">
									<label for="email">Email
										:${sessionScope.utilisateurConnecte.email}</label>
								</div>
								<div class="form-group">
									<label for="telephone">Téléphone
										:${sessionScope.utilisateurConnecte.telephone}</label>
								</div>
								<div class="form-group">
									<label for="rue">Rue
										:${sessionScope.utilisateurConnecte.rue}</label>
								</div>
								<div class="form-group">
									<label for="codePostal">Code postal
										:${sessionScope.utilisateurConnecte.code_postal}</label>
								</div>
								<div class="form-group">
									<label for="ville">Ville
										:${sessionScope.utilisateurConnecte.ville}</label>
								</div>
								<button class="btn btn-success btn-block" type="submit">Modifier</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Ajoutez les liens vers les fichiers JavaScript de Bootstrap (optionnel) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
