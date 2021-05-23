<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer CRM</title>
<!-- Reference css style -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM-Customer Relationship Manager</h1>
		</div>
		<div id="container">
			<div id="content">
				<!-- put new button to add customer -->
				<input type="button" value="Add customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />
				<!-- add html table -->
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<c:forEach var="tempCustomer" items="${customers}">
						<!-- Constructor an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email }</td>
							<!-- Display update link -->
							<!-- Delete link -->
							<td><a href="${updateLink}">Update</a> | | <a
								href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a>
							</td>

							<td></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>