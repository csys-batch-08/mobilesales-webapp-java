<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

 <title>AdminPage</title>

    <style>
        .h2_1 {
            text-align: center;
            background-color: bisque;
        }
        
    
        
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: brown;
        }
        
        li {
            float: left;
        }
        
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 12px 16px;
            text-decoration: none;
        }
        
        li a:hover {
            background-color: goldenrod;
        }
        
        .active {
            background-color: grey;
        }
        .add_inputs1{
         border-top: none;
    border-left: none;
    border-right: none;
    width: 300px;
    height: 25px;
        }
        .add_con{
        position:absolute;
        left:300px;
	margin: 80px;
        }
        *{
    	margin: 0;
    	padding: 0;
		}
	
		.btn_add:hover {
		background-color: cornflowerblue;
	}
	form  { display: table;      }
p     { display: table-row;  }
label { display: table-cell;  }
input { display: table-cell;position: absolute;left: 120px; }
	body{
background-color:cornsilk;
}
}
    </style>

</head>

<body bgcolor="cornsilk">
    <h2 class="h2_1">Mobile Sales App</h2>

    <div style="position: relative;top: -10px;" class="top_nav">

        <ul>
           
           
            <li style="float: right;"><a href="logOut">Logout</a></li>
            <li style="float: right;"><a class="active" href="AdminMain.jsp">Admin</a></li>
          
            

        </ul>


    </div>
	<img style="border-radius: 100px;position: absolute;top:0px;left: 500px; " width="40px" alt="" src="assets/images/mobile112.png">
	
    <div class="body_main1">
        <br>
        
<div class="add_con">
        <form action="addproduct" method="post"><br>
       
			<h2 style="margin-left : 70px;">Add product</h2><br>
			<p>
            <label class="lable">Product Name :</label>
            <input type="text" name="product_name"  pattern="[a-zA-Z0-9\s,[]]{3,40}" id="brand_textbox" required class="add_inputs1"><br><br>
			</p>
			<p>
            <label class="add_label1">Description :</label>
            <input type="text" name="description" id="brand_textbox" pattern="[a-zA-Z\s]{3,60}" required class="add_inputs1"><br><br>
            </p>
            <p>
            <label class="add_label1">Standard_cost :</label>
            <input type="text" name="standard_cost" id="brand_textbox" pattern="[0-9]{1,8}" maxlength="8" required class="add_inputs1"><br><br>
			</p>
			<p>
            <label class="add_label2">List Price :</label>
            <input type="text" name="list_price" id="brand_textbox"  pattern="[0-9]{1,8}" maxlength="8" required class="add_inputs1"><br><br>
			</p>
            <button type="submit" style="margin-left: 100px" class="btn btn-success">Add</button><br><br>
            
            <%if(session.getAttribute("product")!=null){ %>
            <h4 style="color: green"><%=session.getAttribute("product") %></h4>
            <%} %>
        </form><br>
     	
         <br>
		
			
</div>
  </div>
         <%session.removeAttribute("product"); %> 
  
 
</body>
</html>