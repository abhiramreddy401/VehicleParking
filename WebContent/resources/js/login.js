/*
 * function related to login 
 */

$(document).ready(function(){
	
	/*
	 *  Login
	 */
	
    $("#loginbtn").click(function(){
   
   	});
    
    /*
     *  forget link
     */

    $("#forgetlink").click(function(){
    	window.location.href="/Carsnik/forget.htm";

    });
    
    /*
     *  send credentials
     */
    
    $("#sendbtn").click(function(){
        
    });

/*
 * signup
 */
    $("#registerbtn").click(function(){
    	
    	window.location.href="/Carsnik/register.htm";
    });

   
    
    	
   });



//------------------------------------------------------form submissions here---------------------------------------------//





$.validator.setDefaults({
	submitHandler: function() {
	$.get("/Carsnik/login.htm?userid="+$("#userid").val()+'&password='+$("#password").val()+'&time='+new Date(),function(data){
	
      if(data=="User")
      {
    	  window.location.href="/Carsnik/mainPage.htm";
      }
      else if (data=="Admin")
      {
    
    	  window.location.href="/Carsnik/mainPage.htm";
      }
      else 
      {
    	  $("#message").html("Invalid Credentials !");
		  $("#message").show();
      }
    	
    	
    });
	}
	
	
	
	  

});


$().ready(function() {
	// validate the comment form when it is submitted
$("#login-form").validate();

});





//------------------------------------------------------form submissions here---------------------------------------------//








