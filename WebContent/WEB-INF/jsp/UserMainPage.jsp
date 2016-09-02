
<html>
<head>
<title>Carsnik User Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<style>


span {
background-color: red;
border: none;
border-radius: 3px;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
color: #f4f4f4;
cursor: pointer;
font-family: 'Open Sans', Arial, Helvetica, sans-serif;
height: 50px;
text-transform: uppercase;
width: 150px;
-webkit-appearance:none;
}




</style>


<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
<script>

$(document).ready(function(){
    $("#rentspace").click(function(){
	window.location.href="/Carsnik/rentspace.htm";
   	});

    $("#violations").click(function(){
    	window.location.href="/Carsnik/reportviolation.htm";
       	});

    $("#slotsbooked").click(function () {
		alert("show rented function");
		$.ajax({url: "/Carsnik/showSlots.htm", success: function(result){

			   //$("#slotsbookediv").html(result);
			   var i;
			   var content="";
			   alert(result);
			   var slotArray = result.split('#');
			   var i;
			   var content="";
			   for(i=0;i<slotArray.length-1;i++)
				{
				
					content += "<span id="+slotArray[i]+" onclick='showSlotDetails("+slotArray[i]+")'>"+slotArray[i]+"</span>&nbsp;&nbsp;&nbsp;&nbsp;";	
				}
			   
			   $("#slotsbookediv").html($("#dynamicbutton").html(content));
			   $("#slotsbookediv").show();

			   $('span').click(function(){
					var slotno = $(this).text();
					window.location.href="/Carsnik/viewSlotDetails.htm?slotno="+slotno;
					
				});
		    
		   }});
	});

    
    
});




</script>
</head>
<body>

<div id="menubar">
<div style="float:left">Welcome : ${username} </div>
<div style="float:left"> &nbsp;&nbsp; UserId :${userid}  </div>
<div style="float:right">Status : ${status}  &nbsp;&nbsp; <a href="/Carsnik/">Logout</a></div>
</div>

		<fieldset>
			<legend></legend>
    <div  align="center" >
	<div style="width: 670px;" >
	<br/><br/><br/>
		<fieldset>
			<legend>Violations</legend>
			Number of Violations Done By User : ${ViolationCount}
			<br/>
			
		</fieldset>
			<br/><br/><br/>
		<fieldset>
			<legend>Rent a Parking Slot</legend>
			<div id="slotreg">
			<br/>
			<input type="button" id="rentspace" value="Rent Lot"/> 
			</div>
		</fieldset>
		<br/>
		<fieldset>
			<legend>Already Rented Slots</legend>
			<input type="button" id="slotsbooked" value="Show Rented"/>
			<div id="slotsbookediv" style="display:none;">
			<br></br>
			<div id="dynamicbutton"></div>
			</div>
		</fieldset>
		
		<br/>
		<fieldset>
			<legend>Report Violation</legend>
			<input type="button" id="violations" value="Report Violation"/>
			<br/>
		</fieldset>
		
	</div>
<input type="hidden" id="userid" value='${availslotnos}'/>
</fieldset>
</body>
</html>
	