<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="content">
  <div class="main">

	<c:url var="url" value="/search/use" />
      <form:form class="form" method="POST" action="${url}" modelAttribute="searchQuery">
          	<c:if test="${searchError != null}">
    		<div class="alert alert-danger">${searchError}</div>
    	</c:if>
      
      <div class="input">
        <form:input class="form_input" path="query" type="text" placeholder="Tapez le nom des personnes que vous recherchez" />
        <form:errors path="query" name="query" cssClass="alert alert-danger" element="div" />
      </div>

      <div class="submit">
          <input class="form_submit" type="submit" class="btn btn-primary"></input>
      </div>
    </form:form>

    <div class="list" style="padding: 0; margin: 0;">

		<c:if test="${ persons.size() > 0 }">
          <h2 style="text-align: center;"><c:out value="${persons.size()}"/> résultat(s) de la recherche '<c:out value="${lastQuery}" />'</h2>
		</c:if>
		<c:if test="${ persons.size() <= 0 }">
          <h2 style="text-align: center;">Aucun résultat pour '<c:out value="${lastQuery}" />'</h2>
		</c:if>
		
		<c:forEach items="${persons}" var="person">
      	  <ul id="${person.id}" class="elem">
            <div class="list-elem-name"><c:out value="${person.firstName.toUpperCase()}" /> <c:out value="${person.lastName.toUpperCase()}" /></div>     
            <li><a href="/persons/${person.id}">Voir détail de la personne</a></li>
	      </ul>
        </c:forEach>
     </div>        

  </div>
</div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>