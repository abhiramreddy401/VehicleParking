
<html>
<head>
<title>Carsnik Forget Credentials</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>

<script>

$(document).ready(function(){
	$("#forgetbtn").click(function () {
		var data = $("#email").val()+$("#mobile").val();
		alert(data);
    	 $.ajax({url: "/Carsnik/forgetCredentials.htm?data="+data, success: function(result){
    	        //$("#div1").html(result); Credentials Send to the Registered Mail-id..
       	    if(result == "Success")
			{
    			$("#message").html("Credentials Sent to your Mail-Id");
				$("#message").show();
			}else
			{
				$("#message").html(result);
				$("#message").show();
			}
            
    	    }});
		
		
	});

	$("#cancelbtn").click(function(){
		window.location.href="/Carsnik/";
		});
    	
});


</script>


</head>
<body>

    <!--Form  start-->
    <div id="form_name" align="center">
      <form class="cmxform" id="commentForm" method="get" action="">
		<fieldset>
			<legend>Forget Credentials</legend>
			<br/>
			<p>
				<div id="message" stydle="display:none">
				</div>
			</p>
			<p>
				<input id="email" type="email" name="email" placeholder="Email-id" required>
			</p>
			<p style="display:none">
				<input id="mobile" type="text" minlength="10" name="mobile"  placeholder="Mobile Number" required >
			</p>
			<p>
				 <input type="button" value="Send"  id="forgetbtn"/>
				 <input type="button" value="Cancel"  id="cancelbtn"/>
			</p>
		</fieldset>
	</form>
	
    </div>
    <!--form ends-->
</body>
</html>
