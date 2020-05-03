<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
  <div class="main">
     
	<c:url var="url" value="/connect" />
    <form:form class="form" method="POST" action="${url}" modelAttribute="user">
    
    	<c:if test="${loginError != null}">
    		<div class="alert alert-danger">${loginError}</div>
    	</c:if>
    
      <div class="input">
        <form:input class="form_input" path="email"  type="text" placeholder="Email" />
        <form:errors path="email" cssClass="alert alert-danger" element="div" />
        
        <form:input class="form_input" path="password" type="password" placeholder="Mot de passe" />
        <form:errors path="password" cssClass="alert alert-danger" element="div" />        
      </div>
      
      <div class="submit">
          <input class="form_submit" type="submit" class="btn btn-primary"></input>
      </div>
      
    </form:form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>