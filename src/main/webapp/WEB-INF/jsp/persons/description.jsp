<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

   <div id="content">
      <div class="main">
        <div class="list">
          <div class="card">
            <h2><strong><c:out value="${person.firstName.toUpperCase()}" /> <c:out value="${person.lastName.toUpperCase()}" /></strong></h2>
            <div>
	            <h3><strong>Email: </strong><c:out value="${person.email}" /></h3>
	            <h3><strong>Website: </strong><c:out value="${person.website}" /></h3>
	            <h3><strong>Date de naissance: </strong><c:out value="${person.birthday}" /></h3>
	            <h3><strong>Fais parti du groupe</strong> (<a href="/groups/<c:out value="${person.team.id}" />"><c:out value="${person.team.groupName}"/></a>)</h3>
            </div>
         
        </div>
      </div>
      
     </div>
   ZZ</div>
     

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>