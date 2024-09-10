<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Product details</title>
</head>
<body>

	<div class="container mt-5">
		<h1 class="mb-4">Product Details</h1>

		<div class="row">

			<!-- Product Details and Reviews Section (Right Side) -->
			<div class="col-md-8">
				<c:choose>
					<c:when test="${not empty product}">
						<div class="card mb-4">
							<div class="card-body">
								<h2 class="card-title">${product.title}</h2>
								<p class="card-text">${product.description}</p>
								<p class="card-text">
									<strong>Category:</strong> ${product.category}
								</p>
								<p class="card-text">
									<strong>Price:</strong> &#8377;${product.price}
								</p>

								<c:choose>
									<c:when test="${wishlisted}">
										<form:form method="delete" action="/wishlist">
											<input type="hidden" name="productId" value="${product.id}">
											<button type="submit" class="btn btn-success mt-3">Remove
												from wishlist</button>
										</form:form>
									</c:when>
									<c:otherwise>
										<form:form method="post" action="/wishlist">
											<input type="hidden" name="productId" value="${product.id}">
											<button type="submit" class="btn btn-success mt-3">Add
												to wishlist</button>
										</form:form>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger" role="alert">Product not
							found.</div>
						<a href="/products" class="btn btn-primary">Back to Products</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>