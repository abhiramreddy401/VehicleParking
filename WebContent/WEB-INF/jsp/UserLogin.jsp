
<html>
<head>
<title>Carsnik Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

    <script>
	$.validator.setDefaults({
		submitHandler: function() {
			alert("submitted!");
		}
	});
 
  </script>
<script src="<c:url value="/resources/js/login.js" />"></script>
</head>
 
 
<body>
<div id="emptyDiv"></div>
<div id="description"></div>
<!--container start-->
	<div>
      <h2 class="form_title">Welcome To Carsnik Parking Lot</h2>
      </div>
		<div id="form_name" align="center">
		
		      <form class="cmxform" id="login-form" method="post">
				<fieldset>
					<legend>Render-Login</legend>
					<br/>
					<div id="message" style="display:none;" ></div>
					<p>
						<input id="userid" type="text" name="userid" placeholder="User-id" required>
						 
					</p>
					<p>
						<input id="password" type="password"  name="password"  placeholder="Password" required >
						
					</p>
					<p><a href="#" id="forgetlink">Forgot Password?</a></p>
					<p>
					      <input type="submit" value="Login"  id="loginbtn"/>
			       		  <input type="button" value="SignUp" id="registerbtn"/>
					</p>
				</fieldset>
			</form>
			
		    </div>


</body>
</html>