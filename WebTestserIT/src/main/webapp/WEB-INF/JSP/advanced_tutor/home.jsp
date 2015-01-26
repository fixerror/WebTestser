<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="row" id="header">
		<div class="span12">
			<h2 style="text-align: center;">Tutor List</h2>
		</div>
	</div>
	<div class="row" id="content">
		<div class="span3 sidebar">
			<h3 style="text-align: center;">Menu</h3>
			<a href="${context}/logout"  class="btn btn-mini btn-danger btn-block">Exit</a>
		</div>
		<div class="span9 contentformtable" >
			<h3 style="text-align: center;">Test</h3>
			<c:if test="${!empty listAllActiveTest}">
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
						<c:forEach items="${listAllActiveTest}" var="listTests">
							<tr>
								<td>${listTests.idTest}</td>
								<td>${listTests.name}</td>
								<td>${listTests.description}</td>
								<td>${listTests.time}</td>
								<%-- <td><a href="delete/${contact.id}" class="btn btn-danger">delete</a></td> --%>
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
					&#169; Radchenko Aleksandr </br>
					 radchenkoaas@gmail.com
				</h5>
			</div>
		</div>
		</div>
