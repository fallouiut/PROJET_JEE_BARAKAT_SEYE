<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
  <div class="main">
        
    <form:form method="post" modelAttribute="user">
    
      <div class="input">
        <form:input class="form_input" path="email"  type="text" placeholder="Email" />
        <form:input class="form_input" path="password" type="password" placeholder="Mot de passe" />
      </div>
      
      <div class="submit">
          <input class="form_submit" type="submit" class="btn btn-primary"></input>
      </div>
      
    </form:form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>