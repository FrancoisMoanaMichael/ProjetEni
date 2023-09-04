<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a class="navbar-brand" href="acceuil">ENI-Encheres</a>
		</nav>
	</header>
	<section>
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-6 mx-auto">
					<div class="card">
						<div class="card-body">
							<label for="nom">Pseudo :</label>
							<p class="card-title">${sessionScope.utilisateurConnecte.pseudo }</p>
							<form action="mon_profil" method="post">
								<div class="form-group">
									<label for="nom">Nom :</label> <input type="text"
										class="form-control" id="nom" name="nom" value="${sessionScope.utilisateurConnecte.nom}" maxlength="30">
								</div>
								<div class="form-group">
									<label for="prenom">Prénom :</label> <input type="text"
										class="form-control" id="prenom" name="prenom" value="${sessionScope.utilisateurConnecte.prenom}" maxlength="30">
								</div>
								<div class="form-group">
									<label for="email">Email :</label> <input type="text"
										class="form-control" id="email" name="email" value="${sessionScope.utilisateurConnecte.email}" maxlength="50">
								</div>
								<div class="form-group">
									<label for="telephone">Téléphone :</label> <input type="text"
										class="form-control" id="telephone" name="telephone"
										value="${sessionScope.utilisateurConnecte.telephone}" maxlength="30">
								</div>
								<div class="form-group">
									<label for="rue">Rue :</label> <input type="text"
										class="form-control" id="rue" name="rue" value="${sessionScope.utilisateurConnecte.rue}" maxlength="50">
								</div>
								<div class="form-group">
									<label for="codePostal">Code postal :</label> <input
										type="number" class="form-control" id="codePostal"
										name="codePostal" value="${sessionScope.utilisateurConnecte.code_postal}" maxlength="10">
								</div>
								<div class="form-group">
									<label for="ville">Ville :</label> <input type="text"
										class="form-control" id="ville" name="ville" value="${sessionScope.utilisateurConnecte.ville}" maxlength="30">
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
