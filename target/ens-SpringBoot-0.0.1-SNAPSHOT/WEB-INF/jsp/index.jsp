<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<c:url var="cssUrl" value="stylesheet/style.css" />
    
<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Titre de la page</title>
  <link rel="stylesheet" href="${cssUrl}">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

  <div id="body">
    <div id="header">
      <div class="header-logo">
        <img src="logo_projet.png" />
      </div>
      <div class="header-log">
        <button type="button" class="btn btn-primary">Connexion</button>
      </div>
    </div>
    <div id="content">
      <div class="main">
        <form class="form">
          <div class="input">
            <input type="text" placeholder="Cherchez une personne dans l'annuaire " />
          </div>
          <div class="submit">
              <button type="submit" class="btn btn-primary">Recherche</button>
          </div>
        </form>
      </div>

    </div>
  </div>
</body>
</html>