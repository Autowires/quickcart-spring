<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<h2 class="text-center mb-4">Login</h2>


				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger" role="alert">${errorMessage}
					</div>
				</c:if>

				<form action="/login" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Username</label> <input
							type="text" class="form-control" id="username" name="username"
							required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" required>
					</div>
					<button type="submit" class="btn btn-primary w-100">Login</button>
				</form>

				<!-- Optional link to a sign-up page -->
				<div class="text-center mt-3">
					<p>
						Don't have an account? <a href="/register">Sign Up</a>
					</p>
				</div>
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