<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

<div id="content">
  <div class="main">
    <form class="form">
      <div class="input">
        <input type="text" placeholder="Email" /> <br/><br/>
          <input type="password" placeholder="Mot de passe" />
      </div>
      <div class="submit">
          <button type="submit" class="btn btn-primary">Connexion</button>
      </div>
    </form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>