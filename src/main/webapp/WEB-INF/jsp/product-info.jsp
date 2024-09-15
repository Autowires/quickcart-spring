<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Product Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container mt-5">
        <h1 class="mb-4">Product Details</h1>

        <div class="row">
            <!-- Product Details and Actions -->
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
                                            <button type="submit" class="btn btn-success mt-3">Remove from wishlist</button>
                                        </form:form>
                                    </c:when>
                                    <c:otherwise>
                                        <form:form method="post" action="/wishlist">
                                            <input type="hidden" name="productId" value="${product.id}">
                                            <button type="submit" class="btn btn-success mt-3">Add to wishlist</button>
                                        </form:form>
                                    </c:otherwise>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${inCart}">
                                        <a href="/cart">View in cart</a>
                                    </c:when>
                                    <c:otherwise>
                                        <form:form method="post" action="/cart">
                                            <input type="hidden" name="productId" value="${product.id}">
                                            <button type="submit" class="btn btn-success mt-3">Add to cart</button>
                                        </form:form>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="alert alert-danger" role="alert">Product not found.</div>
                        <a href="/products" class="btn btn-primary">Back to Products</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <!-- Reviews Section -->
        <div class="mt-5">
            <h3>Reviews</h3>
            <c:choose>
                <c:when test="${not empty reviews}">
                    <ul class="list-group">
                        <c:forEach var="review" items="${reviews}">
                            <li class="list-group-item">
                                <strong>Rating:</strong> ${review.rating} <br>
                                <strong>Comment:</strong> ${review.reviewContent} <br>
                                <small>Reviewed on: ${review.createdAt}</small>
                            </li>
                        </c:forEach>
                    </ul>
                </c:when>
                <c:otherwise>
                    <p>No reviews yet.</p>
                </c:otherwise>
            </c:choose>
        </div>

        <!-- Review Form -->
        <c:if test="${not empty product}">
            <div class="mt-4">
                <h4>Post a New Review</h4>
                <form:form method="post" action="/reviews">
                    <input type="hidden" name="productId" value="${productId}" />
                    <div class="mb-3">
                        <label for="rating" class="form-label">Rating</label>
                        <input type="number" class="form-control" id="rating" name="rating" min="1" max="5" required>
                    </div>
                    <div class="mb-3">
                        <label for="reviewContent" class="form-label">Comment</label>
                        <textarea class="form-control" id="reviewContent" name="reviewContent" rows="3" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit Review</button>
                </form:form>
            </div>
        </c:if>

    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
