<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

<div id="content">
      <div class="main">
        <div class="list">

          <h1>Liste de toutes les personnes</h1>

			<c:forEach items="${persons}" var="person">
	          <ul id="${person.id}" class="elem">
	            <div class="list-elem-name"><c:out value="${person.firstName.toUpperCase()}" /> <c:out value="${person.lastName.toUpperCase()}" /></div>
      
	            <li><a href="/persons/${person.id}">Voir détail de la personne</a></li>

	          </ul>
          	</c:forEach>

        </div>
      </div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>