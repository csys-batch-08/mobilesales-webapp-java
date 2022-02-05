function updateProfile(){
		
		var userName=document.getElementById("userName").value;
		var userPhone=document.getElementById("userPhone").value;
		var userEmail=document.getElementById("userEmail").value;
		console.log(userPhone);
		console.log(userName);
			var url = "updateUser?userName="+userName+"&userPhone="+userPhone+"&userEmail="+userEmail;

			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				request.onreadystatechange = getInfo;
				request.open("POST", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

}

		function getInfo() {
			if (request.readyState == 4) {
		
				 var x = document.getElementById("snackbar");
  x.className = "show";
  setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
			}
		}
	
