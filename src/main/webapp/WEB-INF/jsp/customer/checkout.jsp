<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<!-- Left Column: Checkout Form -->
			<div class="col-md-6">
				<h2 class="mb-4">Checkout Form</h2>

				<!-- Normal HTML Form -->
				<form:form id="checkout-form" modelAttribute="checkoutForm">
					<form:input path="fullName" class="form-control" placeholder="Enter full name" required="true"/>
					<form:input path="mobileNumber" class="form-control" placeholder="Mobile number" required="true"/>
					<form:input path="address" class="form-control" placeholder="Address" required="true"/>
					<form:input path="pincode" type="number" class="form-control" placeholder="pincode" required="true"/>
					<form:select path="paymentMode" class="form-control" required="true">
						<form:option value="" label="Select Payment Mode" />
						<form:option value="DEBIT_CARD" label="Debit card" />
						<form:option value="COD" label="Cash on Delivery" />
						<form:option value="UPI" label="UPI" />
						<form:option value="NET_BANKING" label="Internet Banking" />
					</form:select>
				</form:form>

			</div>

			<!-- Right Column: Order Summary and Place Order Button -->
			<div class="col-md-6">
				<!-- Order Summary -->
				<c:set var="totalPrice" value="0" />

				<h4 class="mb-4">Order Summary</h4>
				<ul class="list-group mb-3">
					<c:forEach var="item" items="${cartItems}">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">
							<span>${item.product.title} (x${item.quantity})</span> <span>&#8377;
								<fmt:formatNumber value="${item.product.price * item.quantity}" />
						</span>
						</li>

						<!-- Accumulate the total price -->
						<c:set var="totalPrice"
							value="${totalPrice + (item.product.price * item.quantity)}" />
					</c:forEach>
				</ul>
				
				<h5>Total &#8377;${totalPrice}</h5>

				<!-- Place Order Button -->
				<div class="mb-3">
					<button form="checkout-form" type="submit"
						class="btn btn-primary w-100">Place Order</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS & Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
