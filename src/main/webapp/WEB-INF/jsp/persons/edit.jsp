<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
  <div class="main">
        
        
    <form:form class="form" style="height: inherit;" method="POST" modelAttribute="person">
    
      <h2><strong>Modifier votre description</strong></h2>
      <div class="input">
      	<h3>Prénom</h3>
        <form:input class="form_input" path="firstName"  type="text" placeholder="Prénom" />
        <form:errors path="firstName" cssClass="alert alert-danger" element="div" />

      	<h3>Nom</h3>
        <form:input class="form_input" path="lastName"  type="text" placeholder="Nom" />
        <form:errors path="lastName" cssClass="alert alert-danger" element="div" />
        
      	<h3>Site internet</h3>
        <form:input class="form_input" path="website"  type="text" placeholder="Site internet" />
        <form:errors path="website" cssClass="alert alert-danger" element="div" />
                
      	<h3>Email</h3>
        <form:input class="form_input" path="email" type="text" placeholder="Email" />
        <form:errors path="email" cssClass="alert alert-danger" element="div" />        
      </div>
      
      <div class="submit">
          <input class="form_submit" type="submit" class="btn btn-primary"></input>
      </div>
      
    </form:form>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>