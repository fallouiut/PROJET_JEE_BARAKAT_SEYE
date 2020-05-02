<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

   <div id="content">
      <div class="main">
        <div class="list">
          <div class="card">
            <h2><strong> Fiche de groupe </strong></h2>
            <div>
	        	<h2><strong>Nom:</strong> <c:out value="${group.groupName.toUpperCase()}" /> </h2>
                <h3><strong>Personnes appartenant au groupe:</strong> <c:out value="${group.persons.size()}" /> personnes</h3>


				<c:forEach items="${ group.persons }" var="person">
            		<h3><c:out value="${person.firstName.toUpperCase()}" /> <c:out value="${person.lastName.toUpperCase()}" /></strong> (<a href="/persons/${person.id}">voir</a>)</h3>
					
				</c:forEach> 


          </div>
        </div>
      </div>
      
      </div>
     </div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>