<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Wishlist</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h1 class="mb-4">Your Wishlist</h1>

		<!-- Inventory Table -->
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th scope="col">Product ID</th>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>

					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id}</td>
						<td><a href="products/${product.id}">${product.title}</a></td>
						<td>${product.description}</td>
						<td>${product.category}</td>
						<td>&#8377;${product.price}</td>

						<td><form:form method="DELETE" style="display:inline;">
								<input type="hidden" name="productId" value="${product.id}">
								<input type="submit" class="btn btn-danger btn-sm"
									value="Delete">
							</form:form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>