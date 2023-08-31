<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer un compte</title>
<!-- Lien vers les fichiers CSS de Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<!-- Inclure ici votre fichier de styles personnalisé -->
</head>
<body>
	<div class="container">
		<h1 class="mt-4">Mon Profil</h1>
		<div>
			<form action="creeUnCompte" method="post">
							<h2>Informations Personnelles</h2>
				<div class="row">
					<div class="col-md-6">
						<div class="form-section">
							<div class="form-group">
								<label for="pseudo">Pseudo :</label> <input type="text"
									class="form-control" name="pseudo">
							</div>
							<div class="form-group">
								<label for="prenom">Prénom :</label> <input type="text"
									class="form-control" name="prenom">
							</div>
							<div class="form-group">
								<label for="telephone">Téléphone :</label> <input type="text"
									class="form-control" name="telephone">
							</div>
							<div class="form-group">
								<label for="codePostal">Code postal :</label> <input
									type="number" class="form-control" name="codePostal">
							</div>
							<div class="form-group">
								<label for="motDePasse">Mot de passe :</label> <input
									type="password" class="form-control" name="motDePasse">
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-section">
							<div class="form-group">
								<label for="nom">Nom :</label> <input type="text"
									class="form-control" name="nom">
							</div>
							<div class="form-group">
								<label for="email">Email :</label> <input type="text"
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label for="rue">Rue :</label> <input type="text"
									class="form-control" name="rue">
							</div>
							<div class="form-group">
								<label for="ville">Ville :</label> <input type="text"
									class="form-control" name="ville">
							</div>
							<div class="form-group">
								<label for="confirmation">Confirmation :</label> <input
									type="password" class="form-control" name="confirmation">
							</div>
						</div>
					</div>
				</div>
				<div class="form-actions mt-3">
              		<button class="btn btn-success" type="submit" class="btn btn-primary btn-block">Créer</button>
					<!-- <input class="btn btn-success" type="submit" value="Créer"> -->
					<input class="btn btn-secondary" type="button" value="Annuler"  onclick="window.location='/ProjetEni/connexion'" >
				</div>
				${message}
			</form>
		</div>
	</div>

	<!-- Lien vers le script JavaScript de Bootstrap (optionnel) -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
