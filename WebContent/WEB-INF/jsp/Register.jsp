<html>
<head>
<title>John Rentals Signup</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

    <script>
	

	$().ready(function() {
	$("#signupForm").validate();
	$("#user_id").change(function() {

		var userName = $("#user_id").val();
		$.ajax({url: "/Carsnik/getUserId.htm?data="+userName, success: function(result){
   	        if(userName == result)
			{
			this.value = result;
			$("#userexist").hide();
			}
			else
			{
					$("#userexist").html("User Name Already Exists");
					$("#userexist").show();
			}
   	    }});
	});

	$("#signup" ).click(function() {

          var formData = $("#f_name").val()+"@@"+$("#l_name").val()+"@@"+$("#user_id").val()+"@@"+$("#password").val()+"@@"+$('input[name=re_password]').val()+"@@"+$("#mail_id").val()+"@@"+$("#phone_number").val()+"@@"+$("#address").val(); 
  		  $.post( "/Carsnik/registerUser.htm?data="+formData, function( data ) {
  	  		if(data == "Success")
			{
				$("#message").html("Renter Registered Successfully !");
				$("#message").show();
			}else
			{
				$("#message").html(data);
				$("#message").show();
			}

	      	  
      	});	

		});


	$("#cancelbtn").click(function(){
		window.history.back();
		});
	});

	

	

	
</script>
	
</head>
<body>

    <!--Form  start-->
    <div id="form_name" align="center">
    
<form class="cmxform" id="signupForm" method="post"  commandName="carsnikParkingUsersVO">
		<fieldset>
			<legend>Render Registration</legend>
			<br/>
			<p>
				<div id="message" stydle="display:none">
				</div>
			</p>
			<p>
				
				<input id="f_name" name="f_name" type="text" placeholder="First Name" required>
				<input id="l_name" name="l_name" type="text" placeholder="Last Name" required>
			</p>
			
			<p>
			    	<div id="userexist" style="display:none"></div>
				<input id="user_id" name="user_id" type="text" placeholder="user id" required minlength="2">
			</p>
			<p>
				<input id="password" name="password" type="password" placeholder="Password" required minlength="5">
				<input id="re_password" name="re_password" type="password" placeholder="Confirm Password" required minlength="5" equalTo="#password" >
			
			</p>
			
			<p>
				<input id="mail_id" name="mail_id" type="email" placeholder="Email" required>
				<input id="phone_number" name="phone_number" type="text" placeholder="Mobile Number" required>
			
			</p>
			<p>
				<textarea id="address" name="address" placeholder="Address" required></textarea>
			</p>
			<p>
			   <input type="checkbox" class="checkbox" id="agree" name="agree" required> 
			   I here by accept the terms and conditions.
			</p>
			
			<p>
				<input class="submit" type="button" id="signup" value="Submit">
				 <input type="button" value="Cancel"  id="cancelbtn"/>
			</p>
		</fieldset>
		
	</form>
	
    </div>
    <!--form ends-->




</body>
</html>
	