<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

<div id="content">
  <div class="main">
    <form class="form">
      <div class="input">
        <input type="text" placeholder="Cherchez une personne dans l'annuaire " />
      </div>
      
      <% System.out.println("okok"); %>
      <% System.out.println(request.getSession().getAttribute("user")); %>
		
      <div class="submit">
          <button type="submit" class="btn btn-primary">Recherche</button>
      </div>
    </form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>