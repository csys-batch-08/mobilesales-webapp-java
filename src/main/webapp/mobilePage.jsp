
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
<title>MobilePage</title>
</head>


<body>
	<jsp:include page="userHeader.jsp"></jsp:include>


	<div class="body_main1">
		<br>

		<h4 class="mar1">New Smartphone Offer Available upto 15% Discount</h4>
		
		<h5 style="margin-left: 200px;">Welcome :${sessionScope.name}</h5>
		<h5 style="margin-left: 200px;">Wallet
			Amount: Rs : ${sessionScope.wallet}</h5>
	
	<br>
	


		<table aria-describedby="Show All home places">
			<tbody>
				
				<tr>

					<c:set var="count" value="1" />
					<c:forEach items="${sessionScope.productList}" var="productList">
						<td>
							<table aria-describedby="Show All home places" id="mobile">
								<tbody>
									
									<tr>
										<th><img src="${productList.url}" alt="mobileImage"></th>


										<td>


											<p>${productList.productName}</p>

											<p>Rs. ${productList.listCost}</p>

											<p>
												<a
													style="border-radius: 20px; position: relative; left: 10px; top: 10px;"
													id="but_id" class="btn btn-primary"
													href="MobileInfo?productId=${productList.id }">View</a>
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

	</div>
</body>

</html>
