<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Add Bootstrap CSS link -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="acceuil">ENI-Encheres</a>
		</nav>
	</header>
	<section>
		<div class="container">
			<form action="modifie_mon_profil" method="post">
				<div class="form-group">
					<label for="nom">Nom :</label> <input type="text"
						class="form-control" id="nom" name="nom"
						value="${sessionScope.utilisateurConnecte.nom}" maxlength="30">
				</div>
				<div class="form-group">
					<label for="prenom">Pr�nom :</label> <input type="text"
						class="form-control" id="prenom" name="prenom"
						value="${sessionScope.utilisateurConnecte.prenom}" maxlength="30">
				</div>
				<div class="form-group">
					<label for="email">Email :</label> <input type="text"
						class="form-control" id="email" name="email"
						value="${sessionScope.utilisateurConnecte.email}" maxlength="50">
				</div>
				<div class="form-group">
					<label for="telephone">T�l�phone :</label> <input type="text"
						class="form-control" id="telephone" name="telephone"
						value="${sessionScope.utilisateurConnecte.telephone}"
						maxlength="30">
				</div>
				<div class="form-group">
					<label for="rue">Rue :</label> <input type="text"
						class="form-control" id="rue" name="rue"
						value="${sessionScope.utilisateurConnecte.rue}" maxlength="50">
				</div>
				<div class="form-group">
					<label for="codePostal">Code postal :</label> <input type="number"
						class="form-control" id="codePostal" name="codePostal"
						value="${sessionScope.utilisateurConnecte.code_postal}"
						maxlength="10">
				</div>
				<div class="form-group">
					<label for="ville">Ville :</label> <input type="text"
						class="form-control" id="ville" name="ville"
						value="${sessionScope.utilisateurConnecte.ville}" maxlength="30">
				</div>
				<button class="btn btn-success btn-block" type="submit" name="act"
					value="modifier">Modifier</button>
				<button class="btn btn-danger btn-block" type="submit" name="act"
					value="supprimer">Supprimer le compte</button>
			</form>
		</div>
	</section>

	<!-- Add Bootstrap JavaScript and jQuery scripts (optional) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
