<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Products</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-card {
            border: 1px solid #dee2e6;
            border-radius: .375rem;
            padding: 15px;
            margin-bottom: 20px;
            text-align: center;
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
        .container {
            max-width: 1200px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">PRODUCTS</h1>
        <div class="row">
            <c:forEach var="product" items="${producs}">
                <div class="col-md-4">
                    <div class="product-card shadow-sm">
                        <h3 class="h5">${product.title}</h3>
                        <p>${product.description}</p>
                        <p class="price">₹${product.price}</p>
                        <p class="category">${product.category}</p>
                        <a href="products/${product.id}">View details</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
