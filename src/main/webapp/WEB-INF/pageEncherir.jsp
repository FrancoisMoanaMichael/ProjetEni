<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<li class="nav-item">
						<a class="nav-link" href="acceuil">Enchères</a>
						<a class="nav-link" href="vendre_un_article">Vendre un article</a>
						<a class="nav-link" href="mon_profil">Mon Profil</a>
						<a class="nav-link" href="acceuil">Déconnexion</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<h2>Détail Vente</h2>
	<div class="row">
    <div class="col-md-6">
        <h3>Informations sur l'enchère</h3>
         <ul>
            <li><strong>ID de l'enchère : </strong> ${enchere.no_enchere}</li>
            <li><strong>Date de l'enchère : </strong> ${enchere.date_enchere}</li>
            <li><strong>Montant de l'enchère : </strong> ${enchere.montant_enchere}</li>
            <li><strong>Utilisateur : </strong> ${enchere.utilisateur.pseudo}</li>
            <li><strong>Email de l'utilisateur : </strong> ${enchere.utilisateur.email}</li>
            <li><strong>Article : </strong> ${enchere.article.nom_article}</li>
            <li><strong>Date de début des enchères pour l'article : </strong> ${enchere.article.date_debut_encheres}</li>
            <li><strong>Date de fin des enchères pour l'article : </strong> ${enchere.article.date_fin_encheres}</li>
        </ul>
    </div>
</div>

</body>
</html>
