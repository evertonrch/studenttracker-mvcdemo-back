<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>List Customer</title>
</head>
<body>

	<header>
		<div class="container">
			<div class="heading">
				<h1 class="fw-bold">CRM - Customer Relationship Manager</h1>
			</div>
		</div>
	</header>

	<main class="mt-5">
		<div class="container">
			<div class="row mb-4">
				<div class="col-6">
					<a class="btn btn-primary" href="showFormAdd">Add Customer</a>
				</div>
				<div class="col-6">
					<div>
						<form:form action="search" method="GET"> 
							<div class="row d-flex align-items-center">
								<div class="col-auto">
									<label>Search customer:</label>
								</div>
								<div class="col-auto">
									<input class="form-control" type="text" name="searchName" />
								</div>
								<div class="col-auto">
									<button class="btn btn-primary">Buscar</button>
								</div>
							</div>	
						</form:form>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">

							<c:forEach var="temp" items="${customers}">

								<c:url var="updateLink" value="/customer/showFormUpdate">
									<c:param name="customerId" value="${temp.id}" />
								</c:url>

								<c:url var="deleteLink" value="/customer/delete">
									<c:param name="customerId" value="${temp.id}" />
								</c:url>

								<tr>
									<td>${temp.id}</td>
									<td>${temp.firstName}</td>
									<td>${temp.lastName}</td>
									<td>${temp.email}</td>
									<td>
									<a class="badge text-bg-warning text-decoration-none" href="${updateLink}">Update</a> 
									| 
									<a class="badge text-bg-danger text-decoration-none" href="${deleteLink}">Delete</a>									
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
</body>
</html>