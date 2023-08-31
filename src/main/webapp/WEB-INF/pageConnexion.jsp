<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion</title>
  <!-- Ajoutez le lien vers Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>

<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <h1 class="card-title text-center">Connexion</h1>
            <form action="connexion" method="post">
              <div class="form-group">
                <label for="login">Identifiant:</label>
                <input type="text" class="form-control" id="login" name="login">
              </div>
              <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" class="form-control" id="password" name="password">
              </div>
              <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="rememberMe" value="true" name="rememberMe">
                <label class="form-check-label" for="rememberMe">Se souvenir de moi</label>
              </div>
              <button type="submit" class="btn btn-primary btn-block">Connexion</button>
            </form>
            ${message}
            <p class="mt-3"><a href="recoverLoginServlet">Mot de passe oublié</a></p>
            <input class="btn btn-success btn-block" type="button" value="Créer un compte" onclick="window.location='/ProjetEni/creeUnCompte'" >
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Ajoutez le lien vers Bootstrap JS (facultatif) -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
