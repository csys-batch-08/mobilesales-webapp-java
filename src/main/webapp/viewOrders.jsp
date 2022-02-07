<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="assets/css/user.css">

<script type="text/javascript" src="assets/javascript/orderScript.js"></script>
<title>ViewOrders</title>
</head>
<body>
	<jsp:include page="userHeader.jsp"></jsp:include>
	<br>
	<div class="searchPro">
		<form action="SearchOrder">
			<input type="date" id="search" name="OrderDate" required>
			<button class="btn btn-primary" type="submit">Search</button>
		</form>
	</div>
	<br>
	<br>
	<br>
	<script type="text/javascript">
		let today = new Date().toISOString().slice(0, 10);

		console.log(today);
		document.getElementById("search").max = today;
	</script>
	<c:if test="${sessionScope.userId1!=null}">
		<table aria-describedby="Show All home places" id="product"
			class="table table-hover table-striped">
			<tr style="background-color: cornflowerblue">
				<th>Serial No</th>
				<th>Product</th>
				<th>Order Status</th>
				<th>Price</th>
				<th>Order Date</th>
				<th>Delivery Address</th>
				<th>Cancel Order</th>
			</tr>
			<c:set var="serialNumber" value="1" scope="page"></c:set>
			<c:forEach items="${sessionScope.orderList}" var="orderList">
				<tr>
					<td>${serialNumber}</td>
					<td><img width="110px;" alt="${orderList.productId}"
						src="${orderList.url}"></td>
					<td>${orderList.status}</td>
					<td> &#x20b9;${orderList.price }</td>
					<td><fmt:parseDate value="${orderList.date}"
							pattern="yyyy-MM-dd'T'HH:mm" var="orderDate" type="both" /> <fmt:formatDate
							pattern="dd-MM-yyyy HH:mm" value="${orderDate}" /></td>
					<td>${orderList.address}</td>
					<td>
						<div class="container mt-3">


							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal" data-bs-target="#myModal_${serialNumber}">Cancel
							</button>
						</div>
						<div class="modal fade" id="myModal_${serialNumber}">
							<div class="modal-dialog">
								<div class="modal-content">

									<div class="modal-header">
										<h4 class="modal-title">Cancel Order</h4>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal"></button>
									</div>
									<div class="modal-body">
										<div><form action="">
											<input type="hidden" name="cancelId"
												value="${orderList.orderId }" readonly><br>

											<p>Do you want to cancel your order(${orderList.orderId }) ?</p>
											<button class="btn btn-success" type="submit"
												onclick="Cancel('${orderList.status}','${orderList.orderId }','${orderList.price }','${orderList.userId}')"
												class="btn_add">Confirm</button>
										</form>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-bs-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div>

					</td>
				</tr>
				<c:set var="serialNumber" value="${serialNumber+1 }" scope="page"></c:set>
			</c:forEach>

		</table>
	</c:if>
	<c:if test="${sessionScope.userId1==null}">
		<h1 style="color: red; margin-left: 500px; margin-top: 150px">Order
			is not placed yet</h1>
	</c:if>

</body>
</html>