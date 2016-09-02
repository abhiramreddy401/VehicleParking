
<html>
<head>
<title>Carsnik Admin Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

    <script>

    $(document).ready(function(){
    $("#lgbtn").click(function(){ 
        $.ajax({url: "/Carsnik/AdminLoginPage.htm?userid="+$("#userid").val()+'&password='+$("#password").val()+'&time='+new Date(), success: function(data){
 	    if(data=="Success")
      {
    	 // alert("User Login Success");
    	  window.location.href="/Carsnik/AdminHomePage.htm";
      }
      else 
      {
    	    $("#message").html("Invalid Credentials!");
			$("#message").show();
      }
   	    }
   	    });
    });

    $("#forgetlink").click(function(){
    	window.location.href="/Carsnik/forget.htm";

    });
    
    });


    
	$.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});
 
        
    
    
  </script>

</head>
 
 
<body>
<div id="emptyDiv"></div>
<div id="description"></div>
<!--container start-->
	<div>
      <h2 class="form_title">Welcome To Carsnik Parking Lot</h2>
      </div>
		<div id="form_name" align="center"></br>
		<div id="message" style="display:none;" ></div>
		      <form class="cmxform" id="login-form" method="post">
				<fieldset>
					<legend>Admin-Login</legend>
					<br/>
					<p>
						<input id="userid" type="text" name="userid" placeholder="User-id" required>
						 
					</p>
					<p>
						<input id="password" type="password"  name="password"  placeholder="Password" required >
						
					</p>
					<p><a href="#" id="forgetlink">Forgot Password?</a></p>
					<p>
					      <input type="button" value="Login"  id="lgbtn"/>
					</p>
				</fieldset>
			</form>
			
		    </div>




</body>
</html>