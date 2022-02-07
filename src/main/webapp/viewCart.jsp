<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/user.css">

<title>ViewCartItems</title>
</head>

<body>
<jsp:include page="userHeader.jsp"></jsp:include>
	<br>
	<c:if test="${userId!=null}">
		<table aria-describedby="Show All home places">
			<tbody>
				<tr>
				</tr>
				<tr>
					<c:set var="count" value="1" />
					<c:forEach items="${sessionScope.listCart}" var="listCarts">
						<td>
							<table aria-describedby="Show All home places" id="mobile">
								<tbody>

									<tr>
										<th><img src="${listCarts.url}" alt="mobileImage"></th>


										<td>


											<p>${listCarts.productName}</p>

											<p>Rs.${listCarts.price}</p>

											<p>
												<a class="btn btn-secondary"
													href="MobileInfo?productId=${listCarts.productId}">View
												</a>
											</p>
											<p>
												<a class="btn btn-danger"
													href="cartDelete?product_id=${listCarts.productId}&userId=${listCarts.userId}">Delete
												</a>
											</p>
										</td>

									</tr>
								</tbody>
							</table>
						</td>
						<c:choose>
							<c:when test="${count==2}">
								<c:set var="count" value="1" />
				</tr>
				<tr>
					</c:when>
					<c:otherwise>
						<c:set var="count" value="2" />
					</c:otherwise>
					</c:choose>
					</c:forEach>
				</tr>
			</tbody>
		</table>

	</c:if>
	<c:if test="${userId==null}">
		<h1 style="color: red; margin-left: 500px; margin-top: 150px">Cart
			is Empty</h1>
	</c:if>








</body>
</html>