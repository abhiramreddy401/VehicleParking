<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Violation</title>

<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script>

$(document).ready(function(){
	$("#reportviolation").click(function () {
		var data = $("#plateno").val()+"@"+$("#slotno").val();
		$.ajax({url: "/Carsnik/reportViolation.htm?data="+data, success: function(result){
		       //$("#div1").html(result); 
		          if(result == "Success")
			{
    			$("#message").html("Violation Lodged Successfully!");
				$("#message").show();
			}else
			{
				$("#message").html(result);
				$("#message").show();
			}
    	        
 	       }});
		
	});
	$("#cancelreportviolation").click(function(){
    	window.location.href="/Carsnik/mainPage.htm";
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
<form class="cmxform" id="signupForm" method="get" action="">
		<fieldset>
		<div>
			<legend>Report Violation</legend>
			<br/>
			<div>
			<p>
				Report Violation
			</p>
			
			<p>
				<div id="message" stydle="display:none"></div>
			</p>
			
			<p>
				<input id="plateno" name="plateno" type="text" placeholder="Plate Number" required>
			</p>
			<p>
				<input id="slotno" name="slotno" type="text" placeholder="Slot Number" required>
			</p>
			
			<p>
				<input class="submit" type="button" id="reportviolation" value="Submit">
				<input class="submit" type="button" id= "cancelreportviolation"value="Cancel">
			</p>
			
			</div>
		</fieldset>
		
		
	</form>
	
    </div>




</body>
</html>