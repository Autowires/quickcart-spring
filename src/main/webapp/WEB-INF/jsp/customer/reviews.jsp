<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Reviews</title>
</head>
<body>

<h2>Product Reviews for Product ID: ${productId}</h2>

<!-- List all reviews -->
<c:if test="${mode == 'list'}">
    <table border="1">
        <thead>
            <tr>
                <th>Rating</th>
                <th>Comment</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="review" items="${reviews}">
                <tr>
                    <td>${review.rating}</td>
                    <td>${review.comment}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/reviews/edit/${review.id}?productId=${productId}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/reviews/delete/${review.id}?productId=${productId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/reviews/new?productId=${productId}">Add New Review</a>
</c:if>

<!-- Form for adding a new review -->
<c:if test="${mode == 'add'}">
    <h2>Add Review for Product ID: ${productId}</h2>
    <form action="${pageContext.request.contextPath}/reviews/save" method="post">
        <input type="hidden" name="productId" value="${productId}" />
        <label for="rating">Rating:</label>
        <input type="number" name="rating" value="${productReview.rating}" required />
        <label for="comment">Comment:</label>
        <textarea name="comment">${productReview.comment}</textarea>
        <input type="submit" value="Save">
    </form>
    <a href="${pageContext.request.contextPath}/reviews/product/${productId}">Back to Reviews</a>
</c:if>

<!-- Form for editing an existing review -->
<c:if test="${mode == 'edit'}">
    <h2>Edit Review for Product ID: ${productId}</h2>
    <form action="${pageContext.request.contextPath}/reviews/update" method="post">
        <input type="hidden" name="productReview.id" value="${productReview.id}" />
        <input type="hidden" name="productId" value="${productId}" />
        <label for="rating">Rating:</label>
        <input type="number" name="rating" value="${productReview.rating}" required />
        <label for="comment">Comment:</label>
        <textarea name="comment">${productReview.comment}</textarea>
        <input type="submit" value="Update">
    </form>
    <a href="${pageContext.request.contextPath}/reviews/product/${productId}">Back to Reviews</a>
</c:if>

</body>
</html>
