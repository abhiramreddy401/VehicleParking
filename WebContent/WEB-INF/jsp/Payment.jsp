<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Payment</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 <link  href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
 
 <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
 
 
  <script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
  <script src="<c:url value="/resources/js/jquery-ui.js" />"></script> 

<script>


$(document).ready(function(){
	$("#payment").click(function () {
	 // after validations it should show a alert for success payment and then redirected to the user home page
     // make database insersions then redirect to the home page
		 if($("#amount").val()=="")
			 {
			  $("#amountmsg").html("Field Should no be blank");
			  $("#amountmsg").show();
			  $("#cardnomsg").hide();
			  $("#ExpDatemsg").hide();
			  $("#cvvmsg").hide();
			  $("#cardholdernamemsg").hide();
			  $("#addressmsg").hide();
			   return false;
			 }else if($("#cardno").val()=="")
			 {
				$("#cardnomsg").html("Field Should no be blank");
				$("#cardnomsg").show();
				$("#amountmsg").hide();
				  $("#ExpDatemsg").hide();
				  $("#cvvmsg").hide();
				  $("#cardholdernamemsg").hide();
				  $("#addressmsg").hide();
				  return false;
			 }else if($("#ExpDate").val()=="")
			 {
				$("#ExpDatemsg").html("Field Should no be blank");
				$("#cardnomsg").hide();
				$("#amountmsg").hide();
				  $("#ExpDatemsg").show();
				  $("#cvvmsg").hide();
				  $("#cardholdernamemsg").hide();
				  $("#addressmsg").hide();
				 
				return false;
			 }else if($("#cvv").val()=="")
			 {
					$("#cvvmsg").html("Field Should no be blank");
					
					$("#cardnomsg").hide();
					$("#amountmsg").hide();
					  $("#ExpDatemsg").hide();
					  $("#cvvmsg").show();
					  $("#cardholdernamemsg").hide();
					  $("#addressmsg").hide();
					 
					return false;
			 }else if($("#cardholdername").val()=="")
			 {
					$("#cardholdernamemsg").html("Field Should no be blank");
					$("#cardholdernamemsg").show();
					$("#cardnomsg").hide();
					$("#amountmsg").hide();
					  $("#ExpDatemsg").hide();
					  $("#cvvmsg").hide();
					  $("#addressmsg").hide();
					 
					return false;
			 }else if($("#address").val()=="")
			 {
					$("#addressmsg").html("Field Should no be blank");
					$("#cardholdernamemsg").hide();
					$("#cardnomsg").hide();
					$("#amountmsg").hide();
					  $("#ExpDatemsg").hide();
					  $("#cvvmsg").hide();
					  $("#addressmsg").show();
					 
					return false;
			 }else{ 

		var data = $("#amount").val()+"@@"+$("#slotno").val();
		 $.post("/Carsnik/paymentGateway.htm?data="+data, function( result ) {
    	    if(result == "Success")
			{
    			$("#message").html("Payment Done Successfully!");
				$("#message").show();
			}else
			{
				$("#message").html(result);
				$("#message").show();
			}
    	        
 	        
		 });
			 }
 	    });
	    
	$("#cancelpayment").click(function(){
    	window.location.href="/Carsnik/mainPage.htm";
		});


	$(function() {
	    $( "#ExpDate" ).datepicker();
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




<div id="form_name" align="center">
<form class="cmxform" id="payForm" method="get" >
		<fieldset>
		<div>
			<legend>Vehicle Registration</legend>
			<br/>
			<div>
			<p>
				Make Payment
			</p>
			<p>
				<div  id="message" stydle="display:none;color:red;"></div>
			</p>
			
			<p> 
				<div  id="amountmsg" name="amountmsg" style="display:none;color:red;"></div>
				<input id="amount" name="amount" type="text" placeholder="Amount" required>
				
				
				
			</p>
			<p>
				<div  id="cardnomsg" name="cardnomsg" style="display:none;color:red;"></div>
				<input id="cardno" name="cardno" type="text" placeholder="Card Number" required>
				
			</p>
			<p>
				<div id="ExpDatemsg" name="ExpDatemsg" style="display:none;color:red;"></div>
				<input id="ExpDate"  type="text" placeholder="Expirity Date" required>
				
				
				
			</p>
			<p>
				<div id="cvvnomsg" name="cvvnomsg" style="display:none;color:red;"></div>
				<input id="cvvno" name="cvvno" type="text" placeholder="CVV Number" required minlength="3">
				
			</p>
			<p>
				<div id="cardholdernamemsg" name="cardholdernamemsg" style="display:none;color:red;"></div>
				<input id="cardholdername" name="cardholdername" type="text" placeholder="Card Holder Name" required>
				
			</p>
			
			<p>
				<div id="addressmsg" name="addressmsg" style="display:none;color:red;"></div>
				<textarea id="address" name="address" placeholder="Address" required>
				</textarea>
				
			</p>
			
			<p>
				<input class="submit" type="button" id="payment" value="Submit">
				<input class="submit" type="button" id= "cancelpayment"value="Cancel">
			</p>
			<input type="hidden" id="slotno" value='${slotno}'/>
			
			</div>
		</fieldset>
		
		
	</form>
	
    </div>




</body>
</html>