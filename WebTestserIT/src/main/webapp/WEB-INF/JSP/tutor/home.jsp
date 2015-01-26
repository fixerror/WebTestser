<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
	<div class="row" id="header">
		<div class="span12">
			<h2 style="text-align: center;">Tutor List</h2>
		</div>
	</div>
	<div class="row" id="content">
		<div class="span3 sidebar">
			<h3 style="text-align: center;">Menu</h3>
			<a href="${context}/logout" class="btn btn-mini btn-danger btn-block">Exit</a>
			<!-- Button to trigger modal  -->
			<a href="#myModal" role="button" class="btn btn-mini btn-primary btn-block" data-toggle="modal">Create
				Test</a>
		</div>
		<div class="span9 contentformtable">
			<div class="modal hide fade" id="myModal"  data-backdrop="false" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">Create Test</h3>
				</div>
				<div class="modal-body">
					<form:form method="post" action="${context}/tutor/create" modelAttribute="createTestForm" class="form-horizontal">
						<form:label path="nametest"><spring:message code="label.nametest" /></form:label>
						<form:input type="text" placeholder="Name" path="nametest" />
						<form:label path="description"><spring:message code="label.description" /></form:label>
						<form:input type="text" placeholder="Description" path="description" />
						<form:label path="time"><spring:message code="label.time" /></form:label>
						<form:input type="text" placeholder="30" path="time" />
                        <input type="submit" class="btn btn-primary" value="<spring:message code="label.addcreate" />">
					</form:form>
				</div>
				<div class="modal-footer"></div>
			</div>
			<h3 style="text-align: center;">Test</h3>
			<c:if test="${!empty listTests}">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
						    <th>id</th>
							<th>Name</th>
							<th>Description</th>
							<th>Time</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listTests}" var="listTests">
							<tr>
								<td>${listTests.idTest}</td>
								<td>${listTests.nametest}</td>
								<td>${listTests.description}</td>
								<td>${listTests.time}</td>
								<td><a href="delete/${listTests.idTest}" class="btn btn-danger">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if> 
		</div>
	</div>
	<div class="row" id="footer">
		<div class="span12">
			<h5>
				&#169; Radchenko Aleksandr </br> radchenkoaas@gmail.com
			</h5>
		</div>
	</div>
</div>
