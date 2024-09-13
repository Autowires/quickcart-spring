<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Products</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.product-card {
	border: 1px solid #dee2e6;
	border-radius: .375rem;
	padding: 15px;
	margin-bottom: 20px;
	text-align: center;
	transition: transform 0.2s;
}

.product-card:hover {
	transform: scale(1.05);
}

.product-card img {
	max-width: 100%;
	height: auto;
	margin-bottom: 15px;
}

.price {
	font-size: 1.25rem;
	font-weight: bold;
	color: #007bff;
}

.category {
	font-size: 0.875rem;
	color: #6c757d;
}

.sidebar {
	padding: 15px;
	border-right: 1px solid #dee2e6;
}

.sidebar h5 {
	margin-top: 1rem;
	margin-bottom: 0.5rem;
}

.sidebar ul {
	padding-left: 0;
	list-style-type: none;
}

.sidebar ul li {
	margin-bottom: 0.5rem;
}

@media ( max-width : 768px) {
	.product-card {
		margin-bottom: 15px;
	}
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">OUR PRODUCTS</h1>
		<div class="row">
			<!-- Sidebar -->
			<div class="col-md-3">
				<div class="sidebar">
					<input type="text" class="form-control mb-4"
						placeholder="Search products" />

					<h5>Category</h5>
					<ul class="list-group">
						<li><a href="/products">All products</a></li>

						<c:forEach var="category" items="${categories}">
							<c:choose>
								<c:when
									test="${not empty param.category && param.category eq category}">
									<li class="list-group-item active">${category}</li>
							</c:when>
							<c:otherwise>
							<li
								class="list-group-item">
								<a href="products?category=${category}"
								class="text-decoration-none d-flex justify-content-between align-items-center">
									${category} <!-- Optional Badge to show selected status --> <span
									class="badge bg-primary rounded-pill d-none">Selected</span>
							</a>
							</c:otherwise>
							</c:choose>

							</li>
						</c:forEach>
					</ul>

				</div>
			</div>

			<!-- Main Content -->
			<div class="col-md-9">
				<div class="row">
					<c:forEach var="product" items="${producs}">
						<div class="col-12 col-sm-6 col-md-4">
							<div class="product-card shadow-sm">
								<img src="path-to-your-product-image.jpg" alt="${product.title}" />
								<h3 class="h5">${product.title}</h3>
								<p>${product.description}</p>
								<p class="price">₹${product.price}</p>
								<p class="category">${product.category}</p>

								<!-- Random Rating Logic -->
								<%
								// Generate a random rating between 1 and 5
								int randomRating = (int) (Math.random() * 5) + 1;
								%>
								<p class="rating">
									<%
									for (int i = 0; i < randomRating; i++) {
										out.print("★"); // Print star based on random rating
									}
									for (int i = randomRating; i < 5; i++) {
										out.print("☆"); // Print empty stars for the remaining
									}
									%>
									<span>(${randomRating} / 5)</span>
								</p>

								<a href="products/${product.id}" class="btn btn-primary">View
									details</a>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- No Products View -->
				<!-- <c:if test="${empty products}">
                    <div class="no-products-view text-center mt-5">
                        <img src="https://assets.ccbp.in/frontend/react-js/nxt-trendz/nxt-trendz-no-products-view.png" class="no-products-img" alt="no products" />
                        <h1 class="no-products-heading">No Products Found</h1>
                        <p class="no-products-description">We could not find any products. Try other filters.</p>
                    </div>
                </c:if>-->
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
