<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.suni.springdemo.util.SortUtils"%>
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

				<!-- construct a sort link for first name -->
				<c:url var="sortLinkForFirstName" value="/customer/list">
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.FIRST_NAME) %>"/>
				</c:url>

				<c:url var="sortLinkForLastName" value="/customer/list">
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.LAST_NAME) %>"/>
				</c:url>
				<c:url var="sortLinkForEmail" value="/customer/list">
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.EMAIL)%>"/>
				</c:url>


				<table>
					<tr>
						<th><a href="${sortLinkForFirstName}"> First Name </a></th>
						<th><a href="${sortLinkForLastName}"> Last Name </a></th>
						<th><a href="${sortLinkForEmail}"> Email</a></th>
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