<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Zap Shopping App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="style1.css">
<style>
h2 {
	font-size: 16px;
	margin-bottom: 5px;
}

p {
	font-size: 12px;
	margin: 0;
}

 .bg-clr{
        background-color:#f1faee;
        }
 
        
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-clr">
		<div class="container">
			<a class="navbar-brand fs-1 fw-medium " href="#">Zap Shopping Web App</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="home">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="viewProducts">All
							Products</a></li>
					<li class="nav-item"><a class="nav-link" href="shippedOrders">All
							Orders</a></li>
					<li class="nav-item"><a class="nav-link"
						href="home">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
    <h2>Shopping Cart</h2>
    <p>Product: ${product.name}</p>
    <p>Price: ${product.price}</p>
    <form action="${pageContext.request.contextPath}/buyNow" method="post">
        <input type="hidden" name="productId" value="${product.id}" />
        Quantity: <input type="number" name="quantity" value="1" min="1" /><br>
        <input type="submit" value="Buy Now" />
    </form>
    <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>