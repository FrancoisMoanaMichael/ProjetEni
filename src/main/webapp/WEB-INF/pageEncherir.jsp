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
	<h2 class="text-center">Détail Vente</h2>

	<div class="row p-5">
		<div class="col-md-6">
			 <img
				src="https://t3.ftcdn.net/jpg/05/17/82/24/360_F_517822417_cW17ljcETUNX8BylhlNesxWyhxHXO3Nc.jpg"
				alt="${enchere.article.nom_article}" class="img-fluid" /> 
		</div>
		<div class="col-md-6">

			<h3 class="text-uppercase">${article.nom_article}</h3>
			<p>Description : ${article.description}</p>
			<p>Catégorie : ${article.nomCat}</p>
			<p>Meilleur offre : ${article.prix_vente} pts par
				${article.nomUtilisateur}</p>
			<p>Mise à prix : ${article.prix_initial} points</p>
			<p>Fin de l'enchère : ${article.date_fin_encheres}</p>
			<p>Retrait : ${article.retrait.rue}, ${article.retrait.code_postal } ${article.retrait.ville }  </p>
			<p>Vendeur : ${article.nomUtilisateur}</p>
 
			<form id="formEncherir" method="post">
				<div class="form-group">
					<label for="montant">Ma proposition:</label> <input type="number"
						value=${article.prix_vente}
						min=${article.prix_vente
						} class="form-control"
						id="montant" name="montant"> <input type="hidden"
						name="id_enchere" value="${article.no_article}">
				</div>
				<button type="submit" class="btn btn-primary">Enchérir</button>
			</form>


		</div>
	</div>

	</div>

</body>
</html>
