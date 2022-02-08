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
<title>MobileBuyingPage</title>
</head>

<jsp:include page="userHeader.jsp"></jsp:include>

<div class="buy_div">
	<form action="buying" method="post">
		<br>
		<h4 class="buy_h4">Hello ${sessionScope.name}</h4>
		<p>
			<label>Address Line :</label> <input autocomplete="off"
				name="address1" id="address1" required="required" pattern="[a-zA-Z0-9\s,[]]{3,40}"
				type="text"><br> <br>

		</p>
		<p>
			<label> City/Town : </label> <input autocomplete="off"
				name="address2" id="address2" required="required" pattern="[a-zA-Z0-9\s,[]]{3,40}"
				type="text"><br> <br>
		</p>
		<p>
			<label> Pincode :</label> <input autocomplete="off" name="pincode" id="pincode"
				required="required" pattern="[0-9]{6}" maxlength="6" type="text"><br>
			<br>
		</p>
		<p>
			<label> Phone Number : </label> <input autocomplete="off"
				class="c_user2" name="phone_number" id="phone_number" type="text"
				pattern="[6789]{1}+[0-9]{9}" maxlength="10"
				title="Enter only 10 digit number" required><br> <br>
		</p>
		<p>
			<label>Password : </label> <input autocomplete="off" name="password"
				required="required" id="password"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				type="password"><br> <br>
		</p>
		<p>
			<label>Quantity :</label> <input type="number" id="myInput1"
				onkeyup="myFunction()" maxlength="2" min="1" value=1
				pattern="[1-9]{1+}"><br> <br>
		</p>
		<p>
			<label> Price :</label> <input type="number" id="myInput2"
				maxlength="2" readonly value="${sessionScope.price}"
				pattern="[1-9]+{1+}"><br> <br>
		</p>


		<p>
			<label> Total Price(Discount 15%): </label> <input type="text"
				id="myInput3" readonly name="total1" value="${sessionScope.total}"><br>
			<br>
		</p>

		<p><h5 id="timehead" class="buy_h5" ></h5></p>


			<p>
				<button id="buy_btn" class="btn btn-success btn-lg"
				type="submit">Buy</button>
				<br>
				<br>
			</p>
		</form>


	</div>



	<script type="text/javascript">
	 function myFunction() {
         var Input1, Input2, sum,sum1;
         Input1 = document.getElementById("myInput1").value;
         Input2 = document.getElementById("myInput2").value;
         sum = (Input1 * Input2)*0.85;
         
			console.log(sum);
			console.log("sum");
         document.getElementById("myInput3").value = sum;
     }
	
	 console.log("sum");
	let th = document.getElementById("timehead");
	let time = 120;
	let i;
	window.addEventListener('load', () =>{
		
		 i= setInterval(() => {
			if(time > 0){
				if(time >= 30){
					
			th.innerHTML = "00 : " + time--;
			
				}else{
					th.style.color = "red";
					th.innerHTML = "00 : 0" + time--;
				}
			}else{
				clearInterval(i);
				window.location.assign("mobilePage.jsp");
			}
		},1000);
		
	});
	
			
</script></
		html>