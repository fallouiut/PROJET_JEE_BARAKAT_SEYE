

<%@ include file="/WEB-INF/jsp/include.jsp" %>
  
<c:url var="cssUrl" value="/style.css" />

<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Titre</title>
  <link rel="stylesheet" href="${ cssUrl }">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div id="body">

<c:choose>
	<c:when test="${sessionScope.user != null}">
		<%@ include file="/WEB-INF/jsp/layout/session-header.jsp" %>
	</c:when>
	<c:when test="${sessionScope.user == null}">
		<%@ include file="/WEB-INF/jsp/layout/simple-header.jsp" %>
	</c:when>
</c:choose>