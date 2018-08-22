<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<h3>Category List</h3>
		<table class="table">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Category Name</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</thead>
			<tbody>
				<c:forEach items="${cat_list}" var="cat">
					<tr>
						<td>${cat.id }</td>
						<td>${cat.name }</td>

						<td><spring:url value="/cat/${cat.id }" var="updateURL" /> <a class="btn btn-primary" href="${updateURL}" role="button">Update</a></td>
						<td><spring:url value="/cat/delete/${cat.id }" var="deleteURL" /> <a class="btn btn-primary" href="${deleteURL}" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/cat/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add NeW Category</a>
	</div>
<br><br>
	<div class="container">
		<h3>Product List</h3>
		<table class="table table-striped">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Category Id</th>
				<th scope="row">Product Name</th>
				<th scope="row">Price</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</thead>
			<tbody>
				<c:forEach items="${prd_list}" var="prd">
					<tr>
						<td>${prd.id }</td>
						<td>${prd.catid }</td>
						<td>${prd.name }</td>
						<td>${prd.price }</td>
						<td><spring:url value="/prd/${prd.id }" var="updateURL" /> <a class="btn btn-primary" href="${updateURL}" role="button">Update</a></td>
						<td><spring:url value="/prd/delete/${prd.id }" var="deleteURL" /> <a class="btn btn-primary" href="${deleteURL}" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/prd/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add New Product</a>
	</div>
<br><br>
	<div class="container">
		<h3>Order List</h3>
		<table class="table table-striped">
			<thead>
				<th scope="row">#ID</th>
				<th scope="row">Product Id</th>
				<th scope="row">Quantity</th>
				<th scope="row">Contact</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</thead>
			<tbody>
				<c:forEach items="${order_list}" var="order">
					<tr>
						<td>${order.id }</td>
						<td>${order.prdid }</td>
						<td>${order.cnt }</td>
						<td>${order.phone }</td>
						<td><spring:url value="/order/${order.id }" var="updateURL" /> <a class="btn btn-primary" href="${updateURL}" role="button">Update</a></td>
						<td><spring:url value="/order/delete/${order.id }" var="deleteURL" /> <a class="btn btn-primary" href="${deleteURL}" role="button">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/order/add" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add NeW Order</a>
	</div>
</body>
</html>
