package com.carsnik.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carsnik.service.CarsnikLoginService;
import com.carsnik.service.CarsnikPaymentService;
import com.carsnik.service.CarsnikVehicleRegisterService;
import com.carsnik.service.CarsnikViolationService;
import com.carsnik.vo.CarsnikParkingEntryVO;
import com.carsnik.vo.CarsnikParkingUsersVO;
import com.carsnik.vo.CarsnikParkingViolationVO;


@Controller
public class AdminHomeController {
	
	private String userName="";
	private String status="";

	@Autowired
	private CarsnikLoginService carsnikLoginService;
    
	@Autowired
	private CarsnikViolationService carsnikViolationService;
	
	@Autowired
	private CarsnikPaymentService carsnikPaymentService;
	
	@Autowired
	private CarsnikVehicleRegisterService carsnikVehicleRegisterService;
	

	@RequestMapping("/AdminHomePage")
    public ModelAndView adminHome() {
    	System.out.println("Admin Home Page......!!!");
        return new ModelAndView("AdminHomePage");
    }
	
	@RequestMapping("/AdminLogin")
    public ModelAndView adminLogin() {
    	System.out.println("Admin Login Page......!!!");
        return new ModelAndView("AdminLogin");
    }
    
    
    @RequestMapping(value="/AdminLoginPage",method=RequestMethod.GET)
    public @ResponseBody String adminloginvalidate(@RequestParam("userid") String userid,@RequestParam("password") String password,HttpSession session) {
    	String returnValue = "";
    	int userLevel;
    	try {
    		String where = "user_id='"+userid+"' and password = '"+password+"' and status='Y'";
    		List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where);
    		if(carsnikParkingUsersVOList.size()>0)
    		{
	    		userName = carsnikParkingUsersVOList.get(0).getFName();
	    		status = carsnikParkingUsersVOList.get(0).getStatus();
	    		userLevel = carsnikParkingUsersVOList.get(0).getLevel();
	    		
	    		System.out.println(carsnikParkingUsersVOList.get(0).toString());
	
	    		session.setAttribute("userid",userid);
    			session.setAttribute("password", password);
    			session.setAttribute("username", userName);
    			session.setAttribute("status", status);
    			
    			if(userLevel>0)
    			{
    				returnValue = "Success";
    			}
    			else{
    			    returnValue = "Login Failed";
    			}
    		}
    	}catch (Exception e) {
    			e.printStackTrace();
		}
    	
    	System.out.println("RETURN VALUE:::"+returnValue);
    	return returnValue;	
    } 
   
	
	
	
	@RequestMapping(value="/AdminViolationDetails",method=RequestMethod.GET)
    public @ResponseBody String adminViolations(@RequestParam("userid") String userid,HttpSession session) throws Exception {
		
		System.out.println("Hello in the admin get violation");
		String vio_where = "vio_user_id='"+userid+"'";
		List<CarsnikParkingViolationVO> carsnikParkingViolationVOList = carsnikViolationService.findbyId(vio_where);
		System.out.println("violation size....."+carsnikParkingViolationVOList.size());
		Iterator<CarsnikParkingViolationVO> iterator = carsnikParkingViolationVOList.iterator();
		
		String vehicleAndDate="";
		CarsnikParkingViolationVO carsnikParkingViolationVO;
		if(carsnikParkingViolationVOList.size()>0 && carsnikParkingViolationVOList!=null)
		{
			while(iterator.hasNext())
			{
				carsnikParkingViolationVO	 = 	 iterator.next();
				vehicleAndDate += carsnikParkingViolationVO.getVehicleNo()+"@"+carsnikParkingViolationVO.getViolationDate()+"#";
			}
			
		}
		System.out.println("vehicleAndDatevehicleAndDate"+vehicleAndDate);
		return vehicleAndDate;
	}
	
	//

	@RequestMapping(value="/adminViewStatus",method=RequestMethod.GET)
    public @ResponseBody String adminViewStatus(@RequestParam("userid") String userid,HttpSession session) throws Exception {
		System.out.println("Hello in the admin get violation");
		
		/*
		 *  i. User Name 
		 *  ii. Account Status
		 *  iii. No of Violations 
		 *  iv Amount Due
		 * 
		 */
		

		
		String where = "user_id='"+userid+"'";
		List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where);
		if(carsnikParkingUsersVOList.size()>0)
		{
			// i.
    		userName = carsnikParkingUsersVOList.get(0).getFName();
    		// ii.
    		status = carsnikParkingUsersVOList.get(0).getStatus();
    		
    		
    		System.out.println("UserName:::"+userName+":::Status::"+status);
		}
		
	 	   // iii.
		
		List<CarsnikParkingViolationVO> carsnikParkingViolationVOList =  carsnikViolationService.findViolationsCount(userid);
		
		 int violation_count_month = carsnikParkingViolationVOList.size();
		
		 System.out.println("Violation Count for 30 days::"+violation_count_month);
		
		 // iv.
		 
		 String dueAmount = carsnikPaymentService.findDueAmount(userid);
		 
		 System.out.println(userName+"@@"+status+"@@"+violation_count_month+"@@"+dueAmount);
		 
		return userName+"@@"+status+"@@"+violation_count_month+"@@"+dueAmount;
	}

    // view parking entries
	
	@RequestMapping(value="/AdminViewEntries",method=RequestMethod.GET)
    public @ResponseBody String adminViewEntries(@RequestParam("data") String data,HttpSession session) throws Exception {
		
		
		System.out.println("::::::::::::::::::::Entry Date:::"+data);
        String date_s = data;
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
	    Date date =dt.parse(date_s);

	    // *** same for the format String below
	    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    String formatedDate = dt1.format(date);
	    System.out.println("FORMATTED DATE DUDE:::::"+formatedDate);	
	    		
		
		String where="Entry_Time='"+formatedDate+"'";
		List <CarsnikParkingEntryVO> entrylist = carsnikVehicleRegisterService.findByDate(where);
		Iterator iterator = entrylist.iterator();
		String entry = "";
		 if(entrylist.size()>0 || entrylist!=null)
				 {
			       while(iterator.hasNext())
			       {
			    	   CarsnikParkingEntryVO carsnikParkingEntryVO = (CarsnikParkingEntryVO)iterator.next(); 	
			    	   entry += carsnikParkingEntryVO.getUserName()+"@@"+carsnikParkingEntryVO.getVehicleNumber()+"@@"+carsnikParkingEntryVO.getEntryTime()+"#";
			       }
			 	 }
		
		return entry;
	}
	
	//update status of user
	@RequestMapping(value="/AdminUpdateStatus",method=RequestMethod.GET)
    public @ResponseBody String adminUpdateStatus(@RequestParam("data") String data,HttpSession session) throws Exception {
	   System.out.println("UPDATING THE STATUS in USERS TABLE");
	   
	    String [] arr = data.split("@@");
	    String status = arr[0];
	    String userId = arr[1];
	    String where1="user_id='"+userId+"'";
	    String where2="vio_user_id='"+userId+"'";
	    
	    
	    
	    List <CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where1);
	    System.out.println(":::::::::CARSNIK PARKING USERS VO::::::"+carsnikParkingUsersVOList.size());
	    
	    List <CarsnikParkingViolationVO> CarsnikParkingViolationVOList = carsnikViolationService.findbyId(where2);
//	    carsnikVehicleRegisterService
	    
	    if((carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null) && (CarsnikParkingViolationVOList.size()>0 || CarsnikParkingViolationVOList!=null))
	    {
	    	carsnikParkingUsersVOList.get(0).setStatus(status);	
	        carsnikLoginService.update(carsnikParkingUsersVOList.get(0));
	        
	        Iterator iterator = CarsnikParkingViolationVOList.iterator();
	        
	        while(iterator.hasNext())
	        {
	        	CarsnikParkingViolationVO carsnikParkingViolationVO = (CarsnikParkingViolationVO)iterator.next();
	        	carsnikParkingViolationVO.setActiveOrInactive(status);
	        	
	        	carsnikViolationService.updateVehicle(carsnikParkingViolationVO);
	        }
	        
	        System.out.println("UPDATED SUCCESSFULLY...");
	        return "Success";
	        
	    }
	    else
	    {
	    	System.out.println("NOT UPDATED SUCCESSFULLY");
	    	return "Not Updated";
	    }
	    
	}
	
	
	@RequestMapping(value="/sendMailStart",method=RequestMethod.GET)
    public @ResponseBody String sendMailStart(HttpSession ses) throws Exception {
		
		
		   String from = "ramabhi@yahoo.com";
		     String pass ="venianiabhi";
		    // Recipient's email ID needs to be mentioned.
		     //String to = toAddress;
		   String host = "smtp.mail.yahoo.com";
  
		   
		   String returnValue = "";
		   // Get system properties
		   Properties properties = System.getProperties();
		   // Setup mail server
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", host);
		   properties.put("mail.smtp.user", from);
		   properties.put("mail.smtp.password", pass);
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.auth", "true");

		   // Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try{
		      		      
		      List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findAll();
				 if(carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null)
				 {
					 Address[] cc;
					 Iterator iterator = carsnikParkingUsersVOList.iterator();
					 while(iterator.hasNext())
					 {
						// Create a default MimeMessage object.
					      MimeMessage message = new MimeMessage(session);

					      // Set From: header field of the header.
					      message.setFrom(new InternetAddress(from));

					      // Set To: header field of the header.

						 CarsnikParkingUsersVO carsnikParkingUsersVO = (CarsnikParkingUsersVO)iterator.next();
						 message.addRecipient(Message.RecipientType.TO,new InternetAddress(carsnikParkingUsersVO.getMailId()));
						 
					      // Set Subject: header field
					      message.setSubject("Carsnik Credentials!");

					      // Now set the actual message
					      message.setText("Hi"+ carsnikParkingUsersVO.getFName()+","+'\n'+"This is to inform you that current months bill is generated"+'\n'+"and you are requested to pay the bill"+'\n'+'\n'+"Thanks & Regards"+'\n'+"Carsnik");

					      // Send message
					      Transport transport = session.getTransport("smtp");
					      transport.connect(host, from, pass);
					      transport.sendMessage(message, message.getAllRecipients());
					      transport.close();
					      returnValue = "Success"; 
						 return returnValue;
					 }
					 
				 }
				 else
				 {
					 returnValue = "There are no registered Mail-Id's !";
				 }
		        
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
		   System.out.println("Start:::"+returnValue);
		return returnValue;
	}
	



@RequestMapping(value="/sendMailEnd",method=RequestMethod.GET)
public @ResponseBody String sendMailEnd(HttpSession ses) throws Exception {
	
	
	   String from = "ramabhi@yahoo.com";
	     String pass ="venianiabhi";
	   String host = "smtp.mail.yahoo.com";

	   
	   String returnValue = "";
	   // Get system properties
	   Properties properties = System.getProperties();
	   // Setup mail server
	   properties.put("mail.smtp.starttls.enable", "true");
	   properties.put("mail.smtp.host", host);
	   properties.put("mail.smtp.user", from);
	   properties.put("mail.smtp.password", pass);
	   properties.put("mail.smtp.port", "587");
	   properties.put("mail.smtp.auth", "true");

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try{
	      		      
	      List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findAll();
			 if(carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null)
			 {
				 Address[] cc;
				 Iterator iterator = carsnikParkingUsersVOList.iterator();
				 while(iterator.hasNext())
				 {
					// Create a default MimeMessage object.
				      MimeMessage message = new MimeMessage(session);

				      // Set From: header field of the header.
				      message.setFrom(new InternetAddress(from));

				      // Set To: header field of the header.

					 CarsnikParkingUsersVO carsnikParkingUsersVO = (CarsnikParkingUsersVO)iterator.next();
					 message.addRecipient(Message.RecipientType.TO,new InternetAddress(carsnikParkingUsersVO.getMailId()));
					 
				      // Set Subject: header field
				      message.setSubject("Carsnik Credentials!");

				      // Now set the actual message
				      message.setText("Hi"+ carsnikParkingUsersVO.getFName()+","+'\n'+"This is to inform you that the bill Amount is due"+'\n'+"and you are requested to pay the bill before 10th of next month"+'\n'+'\n'+"Note:Please Ignore this mail if you have already paid the bill amount."+'\n'+"Thanks & Regards"+'\n'+"Carsnik");

				      // Send message
				      Transport transport = session.getTransport("smtp");
				      transport.connect(host, from, pass);
				      transport.sendMessage(message, message.getAllRecipients());
				      transport.close();
				      returnValue = "Success"; 
					 return returnValue;
				 }
				 
			 }
			 else
			 {
				 returnValue = "There are no registered Mail-Id's !";
			 }
	      
	      
	      
	   }catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	   System.out.println("Start:::"+returnValue);
	return returnValue;

}

}


