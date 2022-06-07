<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
</head>
<body>

	<header>
		<div>
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</header>

	<main>
		<section>
			<h2>Save Customer</h2>
			<form:form action="saveCustomer" modelAttribute="customer"
				method="POST">
				
				<form:hidden path="id"/>

				<table>
					<tbody>
						<tr>
							<td><form:label path="firstName">First Name:</form:label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name:</form:label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><form:label path="email">Email:</form:label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td align="right" colspan="2"><button>Enviar</button></td>
						</tr>
					</tbody>
				</table>
				
				<div style="clear:both"></div>
				
				<div>
					<a href="<c:url value="/customer/list" />">Back To List</a>
				</div>
			
			</form:form>
		</section>
	</main>


</body>
</html>