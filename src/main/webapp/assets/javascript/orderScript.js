	function Cancel(status,id,price,userId) {
		console.log('on'+status,price+userId);
		var url1="cancelOrder?orderStatus="+status+"&orderId="+id+"&price="+price+"&userId="+userId;
		if(window.XMLHttpRequest){  
    		request=new XMLHttpRequest();  
    		}  
    		else if(window.ActiveXObject){  
    		request=new ActiveXObject("Microsoft.XMLHTTP");  
    		} 
	
	   	try  
    	{  
    	request.onreadystatechange=getInfo;  
    	request.open("GET",url1,true);  
    	request.send();  
    	}  
    	catch(e)  
    	{  
    	alert("Unable to connect to server");  
    	}
        
      
    } 
    
    function getInfo(){  
    	if(request.readyState==4){  
    	var val=request.responseText;
    	 alert(val);  
    	}
		
	}
	
	