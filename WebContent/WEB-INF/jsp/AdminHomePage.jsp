
<html>
<head>
<title>Carsnik Admin Login Page</title>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
 <link  href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
 
 <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
 <script src="<c:url value="/resources/js/jquery.validate.min.js" />"></script>
 
 
  <script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
  <script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
  
  
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
 height:200px;
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



<script>

$(document).ready(function(){

$("#newUser").click(function(){
    	window.location.href="/Carsnik/register.htm";
    });

$("#Entries").click(function(){

	if($("#datepicker").val()== "")
	{    $("#entrymsg").html("Field Should not be empty!");
      	 $("#entrymsg").show();
		 return false;
	}
 	 $("#entrymsg").hide();
	 $.ajax(
			 {url: "/Carsnik/AdminViewEntries.htm?data="+$("#datepicker").val()+"&dateTime"+new Date(), success: function(result){
         var data = result.substring(0,result.length-1);
		  var x = data.split("#") ;      
		  var y;
		  //var table = "<table border='1' bordercolor='black'><th>User Name</th><th>Vehicle Number</th><th>Entry Time</th>";
		  var table = "<table width='100%' align='center' border='1'><button id='closediv' class='circle' >X</button><th>User Name</th><th>Vehicle Number</th><th>Entry Time</th>";
		   for(var p=0;p<x.length;p++)
			{
				y = x[p].split("@@");
		        table+="<tr><td align='center'>"+y[0]+"</td><td align='center'>"+y[1]+"</td><td align='center'>"+y[2]+"</td></tr>" ;		
			}
			table += "</table>";
			$("#popupbox").html(table);

			$("#backgroundPopup").show();
			 $("#popupbox").show();


			 $("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});
		 }
   });		    
	
	
});

$("#violations").click(function(){
	var data = $("#user_id").val();
	if(data== "")
	{    $("#viomsg").html("Field Should not be empty!");
      	 $("#viomsg").show();
		 return false;
	}
 	 $("#viomsg").hide();
	
	 $.ajax({url: "/Carsnik/AdminViolationDetails.htm?userid="+data+"&dateTime"+new Date(), success: function(result){
          var data = result.substring(0,result.length-1);
		  var x = data.split("#") ;      
		  var y;
		  //var table = "<table border='1' bordercolor='black'><th>Vehicle Number</th><th>Violations</th>";
		  var table = "<table width='100%' align='center' border='1'><button id='closediv' class='circle' >X</button><th>Vehicle Number</th><th>Date of Violation</th>";
		   for(var p=0;p<x.length;p++)
			{
				y = x[p].split("@");
		        table+="<tr><td align='center'>"+y[0]+"</td><td align='center'>"+y[1]+"</td></tr>" ;		
			}
			table += "</table>";
			$("#popupbox").html(table);

			$("#backgroundPopup").show();
			 $("#popupbox").show();


			 $("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});
		 }
    });  
	 	 	 
});


$("#sendEmails1").click(function(){

	
	$.ajax({url: "/Carsnik/sendMailStart.htm?dateTime"+new Date(), success: function(result){

	     
	     var table = "<div id='message'></div><table width='100%' align='center' border='1'><button id='closediv' onclick='test()' class='circle' >X</button><th>Bulk Mail</th></table>";
			$("#popupbox").html(table);
			$("#backgroundPopup").show();
  		    $("#popupbox").show();

  		  $("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});	
	     
	     if(result == "Success")
			{
				
 			$("#message").html("Mails Sent Successfully!");
				$("#message").show();
			}else
			{
				$("#message").html(result);
				$("#message").show();
			}

    }});


	
});

$("#sendEmails2").click(function(){

	
	$.ajax({url: "/Carsnik/sendMailEnd.htm?dateTime"+new Date(), success: function(result){

	     
	     var table = "<div id='message'></div><table width='100%' align='center' border='1'><button id='closediv' onclick='test()' class='circle' >X</button><th>Bulk Mail</th></table>";
			$("#popupbox").html(table);
			$("#backgroundPopup").show();
 		    $("#popupbox").show();

 		  $("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});	
	     
	     if(result == "Success")
			{
				
			$("#message").html("Mails Sent Successfully!");
				$("#message").show();
			}else
			{
				$("#message").html(result);
				$("#message").show();
			}

   }});
	

	
});

$("#viewStatus").click(function(){
	var data = $("#view_status").val();

	if(data== "")
	{    $("#statmsg1").html("Field Should not be empty!");
      	 $("#statmsg1").show();
		 return false;
	}
 	 $("#statmsg1").hide();
	
	$.ajax({url: "/Carsnik/adminViewStatus.htm?userid="+data+"&dateTime"+new Date(), success: function(result){

        var data = result;
		  var x = data.split("@@") ;      
		  //var table = "<table border='1' bordercolor='black'><th>Vehicle Number</th><th>Violations</th>";
		  var table = "<table width='100%' align='center' border='1'><button id='closediv' onclick='test()' class='circle' >X</button><th>User Name</th><th>Account Status</th><th>Violations</th><th>Amount Due</th>";
              table+="<tr><td align='center'>"+x[0]+"</td><td align='center'>"+x[1]+"</td><td align='center'>"+x[2]+"</td><td align='center'>"+x[3]+"</td>";		
  			  table += "</table>";
			$("#popupbox").html(table);
			$("#backgroundPopup").show();
  		    $("#popupbox").show();

			$("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});
		 }


		
	});
});



$("#updateStatus").click(function(){
	if($("#editStatus").val()== "")
	{    $("#statmsg2").html("Field Should not be empty!");
      	 $("#statmsg2").show();
		 return false;
	}
 	 $("#statmsg2").hide();
	
	var data = $("#editStatus").val();
	$.ajax({url: "/Carsnik/adminViewStatus.htm?userid="+data+"&dateTime"+new Date(), success: function(result){
        var data = result;
		  var x = data.split("@@") ;      
		  //var table = "<table border='1' bordercolor='black'><th>Vehicle Number</th><th>Violations</th>";
		  var table = "<div id='message'></div><table width='100%' align='center' border='1'><button id='closediv' onclick='test()' class='circle' >X</button><th>User Name</th><th>Account Status</th>";
              table+="<tr><td align='center'>"+x[0]+"</td><td align='center'>"+x[1]+"</td>";
              table+="<tr><td align='center'><input style='border:2px solid #456879;border-radius:10px;height: 20px;width: 100px;' type='text' id='stat' value='"+x[1]+"'/></td><td align='center'><button id='updateUserStat' class='btn'>update<button></td>";		
  			  table += "</table>";
			$("#popupbox").html(table);
			$("#backgroundPopup").show();
  		    $("#popupbox").show();

  		  $("#closediv").click(function(){

				 $("#backgroundPopup").hide();
				 $("#popupbox").hide();
						
			});	

  		$("#updateUserStat").click(function(){
			 var statusdata = $("#stat").val()+"@@"+$("#editStatus").val();
				
		    	 $.ajax({url: "/Carsnik/AdminUpdateStatus.htm?data="+statusdata+"&dateTime"+new Date(), success: function(result){
		    	    if(result == "Success")
					{
		    			$("#message").html("Status Updated Successfully!");
						$("#message").show();
					}else
					{
						$("#message").html(result);
						$("#message").show();
					}
		    	    }
		 	    });
			 
					
		});	


  		  
		}});
	
	
});


$(function() {
    $( "#datepicker" ).datepicker();
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
	<fieldset>
	<legend></legend>
    <div  align="center" >
	<div style="width: 670px;" >
	<br/><br/>
		<table align="center">
		<tr>
		<td align="center">
		<fieldset style="width: 300px;">
		<legend align="left">Create New User</legend>
			<br/>
			<input type="button" id="newUser" value="Create"/>
			<br/><br/>
		</fieldset>
		</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td align="right">
		<fieldset style="width: 500px;">
		<legend align="right">Entries by Date in Parking </legend>
			<br/>
			<div id="entrymsg" style="display:none"></div>
			<input type="text" id="datepicker" value=""/> &nbsp;&nbsp;&nbsp; 
			<input type="button" id="Entries" value="View Entries"/>
			<br/><br/>
		</fieldset>
		</td>
		</tr>
		</table>
		<br/>
		<fieldset>
		<legend align="left">Violation Details</legend>
			<br/>
			
			<div id="viomsg" style="display:none"></div>
			<input type="text" id="user_id"  size="10"/> &nbsp;&nbsp;&nbsp; <input type="button" id="violations" value="Get Violations"/>
			<br/><br/>
		</fieldset>

		<fieldset>
		 <legend align="left">Bulk - Mailing</legend>
			<br/>
			<input type="button" id="sendEmails1" value="Month Begin"/>&nbsp;&nbsp;&nbsp;<input type="button" id="sendEmails2" value="Month End"/>
			<br/><br/>
		</fieldset>
		<fieldset>
		 <legend align="left">View Account Status</legend>
			<br/>
				<div id="statmsg1" style="display:none"></div>
			<input type="text" id="view_status"  size="10"/> &nbsp;&nbsp;&nbsp; <input type="button" id="viewStatus" value="View Status"/>
			<br/><br/>
		</fieldset>
		<fieldset>
		 <legend align="left">Activate/In-Activate</legend>
			<br/>
			<div id="statmsg2" style="display:none"></div>
			<input type="text" id="editStatus"  size="10"/> &nbsp;&nbsp;&nbsp; <input type="button" id="updateStatus" value="Update Status"/>
			<br/><br/>
		</fieldset>
	</div>
	</div>
</fieldset>

<div id="backgroundPopup" class="backgroundPopup"></div>
 <DIV id="popupbox" class="popupbox" align="center">
 
 </DIV>
 



</body>
</html>