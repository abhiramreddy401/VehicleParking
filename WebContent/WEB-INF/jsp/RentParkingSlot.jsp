
<html>
<head>
<title>Carsnik Show Availability</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script>

$(document).ready(function(){
	$("select")
	.change(function () {
		if($("#vehicleselect").val() == 1)
		{
			$("#vechicle1").show();
			$("#vechicle2").hide();
			$("#vechicle3").hide();
		}
		else if ($("#vehicleselect").val() == 2)
		{
			$("#vechicle2").show();
			$("#vechicle1").hide();
			$("#vechicle3").hide();
		}
		else if ($("#vehicleselect").val() == 3)
		{
			$("#vechicle3").show();
			$("#vechicle1").hide();
			$("#vechicle2").hide();
		}
			

		
	});

	$("#payment").click(function(){
    	window.location.href="/Carsnik/payment.htm?slot_no="+$("#slot_no").val();
       	});
    $("#home").click(function(){
    	window.location.href="/Carsnik/mainPage.htm";
       	});
   	



    $("#reg1").click(function(){
		$("#paymentButton").show();

		if($("#make1").val()=="")
		 {

		  $("#make1msg").html("Field Should no be blank");
		  $("#make1msg").show();
		  $("#model1msg").hide();
		  $("#year1msg").hide();
		  $("#plateno1msg").hide();
		  
		   return false;
		 }else if($("#model1").val()=="")
		 {
			 $("#make1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").show();
			  $("#year1msg").hide();
			  $("#plateno1msg").hide();
			    return false;
		 }else if($("#year1").val()=="")
		 {
			 $("#year1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").show();
			  $("#plateno1msg").hide();
			  
			return false;
		 }else if($("#plateno1").val()=="")
		 {
			 $("#plateno1msg").html("Field Should no be blank");
			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").hide();
			  $("#plateno1msg").show();
			 	 
				return false;
		 }else{


			  $("#make1msg").hide();
			  $("#model1msg").hide();
			  $("#year1msg").hide();
			  $("#plateno1msg").hide();


		var data = $("#make1").val()+"@"+$("#model1").val()+"@"+$("#year1").val()+"@"+$("#plateno1").val()+"@"+$("#slot_no").val();
    	
    	 $.ajax({url: "/Carsnik/vehicleregister.htm?data="+data, success: function(result){
    	    if(result == "Success")
			{
    			
				$("#message1").html("Vehicle Registered Successfully !");
				$("#message1").show();
			}else
			{
				$("#message1").html(result);
				$("#message1").show();
			}
    	    
    	    }});
		 }
   
    	
       	});
    $("#reg2").click(function(){
    	$("#paymentButton").show();


    	if($("#make2").val()=="")
		 {

		  $("#make2msg").html("Field Should no be blank");
		  $("#make2msg").show();
		  $("#mode21msg").hide();
		  $("#year2msg").hide();
		  $("#plateno2msg").hide();
		  
		   return false;
		 }else if($("#model2").val()=="")
		 {
			 $("#make2msg").html("Field Should no be blank");
			  $("#make2msg").hide();
			  $("#model2msg").show();
			  $("#year2msg").hide();
			  $("#plateno2msg").hide();
			    return false;
		 }else if($("#year2").val()=="")
		 {
			 $("#year2msg").html("Field Should no be blank");
			  $("#make2msg").hide();
			  $("#mode12msg").hide();
			  $("#year2msg").show();
			  $("#plateno2msg").hide();
			  
			return false;
		 }else if($("#plateno2").val()=="")
		 {
			 $("#plateno2msg").html("Field Should no be blank");
			  $("#make2msg").hide();
			  $("#model2msg").hide();
			  $("#year2msg").hide();
			  $("#plateno2msg").show();
			 	 
				return false;
		 }else{ 


			 $("#make2msg").hide();
			  $("#mode21msg").hide();
			  $("#year2msg").hide();
			  $("#plateno2msg").hide();
			 
		    	var data = $("#make2").val()+"@"+$("#model2").val()+"@"+$("#year2").val()+"@"+$("#plateno2").val()+"@"+$("#slot_no").val();
		    	
		   	 $.ajax({url: "/Carsnik/vehicleregister.htm?data="+data, success: function(result){
		   		 if(result == "Success")
					{
						$("#message2").html("Vehicle Registered Successfully !");
						$("#message2").show();
					}else
					{
						$("#message2").html(result);
						$("#message2").show();
					}
		    	    
		    	   }});
		 }
    


    	
   	});

    $("#reg3").click(function(){
    	$("#paymentButton").show();



    	if($("#make3").val()=="")
		 {

		  $("#make3msg").html("Field Should no be blank");
		  $("#make3msg").show();
		  $("#mode13msg").hide();
		  $("#year3msg").hide();
		  $("#plateno3msg").hide();
		  
		   return false;
		 }else if($("#model3").val()=="")
		 {
			 $("#make3msg").html("Field Should no be blank");
			  $("#make3msg").hide();
			  $("#model3msg").show();
			  $("#year3msg").hide();
			  $("#plateno3msg").hide();
			    return false;
		 }else if($("#year3").val()=="")
		 {
			 $("#year3msg").html("Field Should no be blank");
			  $("#make3msg").hide();
			  $("#mode13msg").hide();
			  $("#year3msg").show();
			  $("#plateno3msg").hide();
			  
			return false;
		 }else if($("#plateno3").val()=="")
		 {
			 $("#plateno3msg").html("Field Should no be blank");
			  $("#make3msg").hide();
			  $("#model3msg").hide();
			  $("#year3msg").hide();
			  $("#plateno3msg").show();
			 	 
				return false;
		 }else{

			  
			  $("#make3msg").hide();
			  $("#model3msg").hide();
			  $("#year3msg").hide();
			  $("#plateno3msg").hide();
			  
			  

    	var data = $("#make3").val()+"@"+$("#model3").val()+"@"+$("#year3").val()+"@"+$("#plateno3").val()+"@"+$("#slot_no").val();;
    	
    	 $.ajax({url: "/Carsnik/vehicleregister.htm?data="+data, success: function(result){
    		 if(result == "Success")
  			{
  				$("#message3").html("Vehicle Registered Successfully !");
  				$("#message3").show();
  			}else
  			{
  				$("#message3").html(result);
  				$("#message3").show();
  			}
    	     
    	    }});
		 }    	
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
<div style="float:right">Status : ${status}  &nbsp;&nbsp; <a href="/Carsnik/logout.htm">Logout</a></div>
</div>


<div style="float: left; display:none" id="HomeBtn" >
   		<input class="submit" type="button" id="home" value="User Home">

</div>

<div style="float: right; display:none" id="paymentButton" >
   		<input class="submit" type="button" id="payment" value="Make Payment">

</div>



<div id="form_name" align="center">

<div>
   <p style="color: blue;">Slot Booked : <font style="color:red">${Assigned}</font></p> 
   <input type="hidden" id="slot_no" value='${Assigned}'/>
   <p style="color: blue;">
     Now Please register your Vehicles.
   </p>
</div>
<form class="cmxform" id="signupForm" method="get" action="">
		<fieldset>
		<div>
			<legend><h2> Vehicle Registration </h2></legend>
			<br/>
			<p>
			  <select id="vehicleselect">
			   		  <option value="">-select-</option>
					  <option value="1">Vehicle1</option>
					  <option value="2">Vehicle2</option>
					  <option value="3">Vehicle3</option>
			  </select>
			</p>
			<div id="vechicle1" style="display:none">
			<p>
				Vehicle 1 Registration
			</p>
			<p>
				<div id="message1" stydle="display:none">
				</div>
			</p>
			
			<p>
				<input id="make1" name="make" type="text" placeholder="Make" required>
				<div  id="make1msg" name="make1msg" style="display:none;color:red;"></div>
			
				
			</p>
			<p>
				<input id="model1" name="model" type="text" placeholder="Model" required>
				<div  id="model1msg" name="model1msg" style="display:none;color:red;"></div>
				
				
				
			</p>
			<p>
				<input id="year1" name="year1" type="text" placeholder="Year" required minlength="4">
				<div  id="year1msg" name="year1msg" style="display:none;color:red;"></div>
				
				
			</p>
			<p>
				<input id="plateno1" name="plateno" type="text" placeholder="Plate number" required>
				<div  id="plateno1msg" name="plateno1msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input class="submit" type="button" id="reg1" value="Submit">
				<input class="submit" type="button" id ="cancel1" value="Back">
			</p>
			
			</div>
			
			
			<div id="vechicle2" style="display:none">
			
			<p>
				Vehicle 2 Registration
			</p>
						<p>
				<div id="message2" stydle="display:none">
				</div>
			</p>
			
			<p>
				<input id="make2" name="make" type="text" placeholder="Make" required>
					<div  id="make2msg" name="make2msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="model2" name="model" type="text" placeholder="Model" required>
				<div  id="model2msg" name="model2msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="year2" name="year" type="text" placeholder="Year" required minlength="4">
				<div  id="year2msg" name="year2msg" style="display:none;color:red;"></div>
				
			</p>
			<p>
				<input id="plateno2" name="plateno" type="text" placeholder="Plate number" required>
					<div  id="plateno2msg" name="plateno2msg" style="display:none;color:red;"></div>
			
			
			</p>
			<p>
				<input class="submit" type="button" id="reg2" value="Submit">
				<input class="submit" type="button" id="cancel2" value="Back">
			</p>
			
			</div>
			
			
			<div id="vechicle3" style="display:none">
			
			<p>
				Vehicle 3 Registration
			</p>
						<p>
				<div id="message3" stydle="display:none">
				</div>
			</p>
			
			<p>
				<input id="make3" name="make" type="text" placeholder="Make" required>
				<div  id="make3msg" name="make3msg" style="display:none;color:red;"></div>
			</p>
			<p>
				<input id="model3" name="model" type="text" placeholder="Model" required>
				<div  id="model3msg" name="model3msg" style="display:none;color:red;"></div>
			</p>
			<p>
				<input id="year3" name="year" type="text" placeholder="Year" required minlength="4">
				<div  id="year3msg" name="year3msg" style="display:none;color:red;"></div>
			</p>
			<p>
				<input id="plateno3" name="plateno" type="text" placeholder="Plate number" required>
					<div  id="plateno3msg" name="plateno3msg" style="display:none;color:red;"></div>
			</p>
			<p>
				<input class="submit" type="button" id="reg3" value="Submit">
				<input class="submit" type="button" id="cancel3" value="Back">
			</p>
			
			</div>
			
		
		
		
		</fieldset>
		
		
	</form>
	
    </div>
    <!--form ends-->

</body>

</html>
	