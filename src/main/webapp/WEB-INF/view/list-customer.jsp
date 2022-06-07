<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
</head>
<body>

	<header>
		<div class="wrapper">
			<div class="heading">
				<h1>CRM - Customer Relationship Manager</h1>
			</div>
		</div>
	</header>
	
	<main>
		<div class="container">
			<div class="wrapper-add-button">
				<a href="showFormAdd">Add Customer</a>
			</div>
			<div class="wrapper-table">
				<table>
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>						
					</thead>
					<tbody>
					
						<c:forEach var="temp" items="${customers}">
							
							<c:url var="updateLink" value="/customer/showFormUpdate">
								<c:param name="customerId" value="${temp.id}" />
							</c:url>							
						
							<tr>
								<td>${temp.firstName}</td>
								<td>${temp.lastName}</td>
								<td>${temp.email}</td>
								<td><a href="${updateLink}">Update</a></td>
							</tr>						
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</main>

</body>
</html>