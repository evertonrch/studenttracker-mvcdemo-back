<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Customer Form</title>
</head>
<body>
	<div class="container">
		<header>
			<div>
				<h1>CRM - Customer Relationship Manager</h1>
			</div>
		</header>

		<main class="mt-5">
			<section>
				<h4>Save Customer</h4>
				<form:form action="saveCustomer" modelAttribute="customer"
					method="POST">

					<form:hidden path="id" />

					<table>
						<tbody>
							<tr class="row">
								<td class="col-4"><form:label path="firstName">First Name:</form:label>
								</td>
								<td class="col-8"><form:input class="form-control"
										path="firstName" /></td>
							</tr>
							<tr class="row">
								<td class="col-4"><form:label path="lastName">Last Name:</form:label></td>
								<td class="col-8"><form:input class="form-control" path="lastName" /></td>
							</tr>
							<tr class="row">
								<td class="col-4"><form:label path="email">Email:</form:label></td>
								<td class="col-8"><form:input class="form-control" path="email" /></td>
							</tr>
							<tr>
								<td align="right" colspan="2"><button class="btn btn-sm btn-primary">Enviar</button></td>
							</tr>
						</tbody>
					</table>

					<div style="clear: both"></div>

					<div>
						<a class="text-muted text-decoration-none" href="<c:url value="/customer/list" />"> << Back To List</a>
					</div>

				</form:form>
			</section>
		</main>
	</div>


</body>
</html>