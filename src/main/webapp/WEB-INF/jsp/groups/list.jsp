<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/layout/head.jsp" %>

<div id="content">
      <div class="main">
        <div class="list">

          <h1>Liste de tous les groupes</h1>

			<c:forEach items="${groups}" var="group">
	          <ul id="${group.id}" class="elem" style="margin-top: 20px">
	            <div class="list-elem-name"><c:out value="${group.groupName.toUpperCase()}" /></div>
	            
	            <c:if test="${group.persons.size() > 0}">
	            	<div class="list-elem-name">Personnes associées: <c:out value="${group.persons.size()}"></c:out></div>
	             </c:if>
	             
    	         <li><a href="/groups/${group.id}">Voir détail du groupe</a></li>
	             
				
	          </ul>
          	</c:forEach>

        </div>
      </div>

<%@ include file="/WEB-INF/jsp/layout/foot.jsp" %>