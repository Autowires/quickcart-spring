<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h1 class="mb-4 text-center">Customer registration</h1>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form action="/register" method="post">
					<!-- Username -->
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" class="form-control" id="username" name="username"
							required>
					</div>

					<!-- Username -->
					<div class="mb-3">
						<label for="email" class="form-label">Email address</label> <input
							type="text" class="form-control" id="email" name="email" required>
					</div>

					<!-- Password -->
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" required>
					</div>

					<c:if test="${not empty errorMessage}">
						<div class="alert alert-danger" role="alert">${errorMessage}
						</div>
					</c:if>
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary w-100">Sign
						Up</button>
				</form>
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