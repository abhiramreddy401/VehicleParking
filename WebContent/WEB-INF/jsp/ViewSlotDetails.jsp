<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Slot Details</title>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<style>

.btn {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 9px;
  padding: 8px 10px 8px 10px;
  text-decoration: none;
}


.circle {
  background-color: #d1d1e0;
  height: 18px;
  width: 18px;
  border-radius: 100%;
  float:right;
  
}
 .popupbox{
 display:none;
 position:absolute;
 top:200px;
 left:400px;
 width:500px;
 height:450px;
 z-Index:2051;
 border:0px solid black;
 text-align:center;
 vertical-align:middle;
 padding:10px;
 background-color:grey;
 overflow: auto;
border-radius: 25px; 
}

.backgroundPopup{
display:none;
position:fixed;
_position:absolute; /* hack for internet explorer 6*/
height:100%;
opacity:0.65;
filter:alpha(opacity=90) ;
background-color:#000000;
width:100%;
top:0;
left:0;

border:1px solid grey;
z-index:1000;
}
</style>



<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>






<script>

$(document).ready(function(){
	$("select").change(function () {
	
	});

	

	$("#reg1").click(function(){
		$("#paymentButton").show();
    	var data = $("#make1").val()+"@"+$("#model1").val()+"@"+$("#year1").val()+"@"+$("#plateno1").val();
    	
    	 $.ajax({url: "/Carsnik/vehicleUpdate.htm?data="+data, success: function(result){
    	    if(result == "Success")
			{
    			
				$("#message1").html("Vehicle Details Updated Successfully !");
				$("#message1").show();
			}else
			{
				$("#message1").html(result);
				$("#message1").show();
			}
    	    
    	    }});
   
    	
       	});
    $("#reg2").click(function(){
    	$("#paymentButton").show();
    	var data = $("#make2").val()+"@"+$("#model2").val()+"@"+$("#year2").val()+"@"+$("#plateno2").val();
    	
    	 $.ajax({url: "/Carsnik/vehicleUpdate.htm?data="+data, success: function(result){
    		 if(result == "Success") 			{
 				
 				$("#message2").html("Vehicle Details Updated Successfully !");
 				$("#message2").show();
 			}else
 			{
 				$("#message2").html(result);
 				$("#message2").show();
 			}
     	    
     	   }});
    	
   	});

    $("#reg3").click(function(){
    	$("#paymentButton").show();
    	var data = $("#make3").val()+"@"+$("#model3").val()+"@"+$("#year3").val()+"@"+$("#plateno3").val();
    	
    	 $.ajax({url: "/Carsnik/vehicleUpdate.htm?data="+data, success: function(result){
    		 if(result == "Success")
  			{
    			$("#message3").html("Vehicle Details Updated Successfully !");
  				$("#message3").show();
  			}else
  			{
  				$("#message3").html(result);
  				$("#message3").show();
  			}
    	     
    	    }});
    	
   	});

    $("#cancel3").click(function(){
    	window.history.back();
    	
   	});

    $("#cancel2").click(function(){
    	window.history.back();
    	
   	});

    $("#cancel1").click(function(){
    	window.history.back();
    	
   	});
   	

	
});






</script>


</head>



<body>

<div id="menubar">
<div style="float:left">Welcome : ${username} </div>
<div style="float:left"> &nbsp;&nbsp; UserId :${userid}  </div>
<div style="float:right">Status : <div id="stat">${status}</div>  &nbsp;&nbsp; <a href="/Carsnik/logout.htm">Logout</a></div>
</div>
<div id="form_name" align="center">
<form class="cmxform" id="signupForm" method="get" action="">
		<fieldset>
		<div>
			
            <p> The Number of Registered Vehicles: ${fn:length(model.vehicles)} </p>
            
            		<table>
						<tr>
						                  
            	    <c:forEach items="${model.vehicles}" var="item" varStatus="stCount" begin="0" end="${fn:length(model.vehicles)}">
            	    <td>
            	    		<p>
									<div id="message${stCount.count}" style="display:none"></div>
							</p>
            	    
            				<p>
								<input id="make${stCount.count}" name="make" type="text" placeholder="Make" value="${item.make}" required>
							</p>
							<p>
								<input id="model${stCount.count}" name="model" type="text" placeholder="Model" value ="${item.model}" required>
							</p>
							<p>
								<input id="year${stCount.count}" name="year" type="text" placeholder="Year" value="${item.year}" required minlength="4">
							</p>
							<p>
								<input id="plateno${stCount.count}" name="plateno" type="text" placeholder="Plate number" value="${item.vehicleNumber}" required readonly>
							</p>
							<p>
								<input class="submit" type="button" id="reg${stCount.count}" value="Submit">
								<input class="submit" type="button" id="cancel${stCount.count}" value="Cancel">
							</p>
							
							<input type="hidden" id="status" value='${status}'/>
            		</td>	
    				</c:forEach>
            </tr>
					</table>                  
            
		</div>
		
		
		</fieldset>
		
		
	</form>
	
    </div>



<div id="backgroundPopup" class="backgroundPopup"></div>
 <DIV id="popupbox" class="popupbox" align="center">
 
 </DIV>




</body>
</html>