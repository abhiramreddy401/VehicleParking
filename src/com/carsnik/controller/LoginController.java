package com.carsnik.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carsnik.service.CarsnikLoginService;
import com.carsnik.service.CarsnikParkingSlotsService;
import com.carsnik.service.CarsnikSlotAssignService;
import com.carsnik.service.CarsnikViolationService;
import com.carsnik.service.ForgetCredentialsService;
import com.carsnik.vo.CarsnikParkingAssignVO;
import com.carsnik.vo.CarsnikParkingForgetCredentialsVO;
import com.carsnik.vo.CarsnikParkingSlotsVO;
import com.carsnik.vo.CarsnikParkingUsersVO;



@Controller
public class LoginController {
	
 
	
	@Autowired
	private CarsnikLoginService carsnikLoginService;

    @Autowired
	private CarsnikViolationService carsnikViolationService;
    
    @Autowired
	private CarsnikParkingSlotsService carsnikParkingSlotsService;
    
    @Autowired
	private ForgetCredentialsService forgetCredentialsService;
    
    @Autowired
    private CarsnikSlotAssignService carsnikSlotAssignService;
    
    private CarsnikParkingSlotsVO carsnikParkingSlotsVO;    
   
    private CarsnikParkingAssignVO carsnikParkingAssignVO;
    
     
    private List<CarsnikParkingAssignVO> carsnikParkingAssignList;

    
    @RequestMapping("/UserLogin")
    
    public ModelAndView userLogin() {
    	System.out.println("User Login Page......!!!");
        return new ModelAndView("UserLogin");
    }
    
    
    
    
    @RequestMapping("/forget")
    public ModelAndView forget() {
    	System.out.println("FORGET FORGET");
        return new ModelAndView("Forget");
    }
    
    
    @RequestMapping(value="/forgetCredentials",method=RequestMethod.GET)
    public @ResponseBody String forgetCredentials(@RequestParam("data") String data,HttpSession session) throws Exception {
    	
    	String mailIdOrMobile = data;
    	Date date = new Date();
		java.sql.Date sentTime  = new java.sql.Date( date.getTime());
    	
    	// Get the user mail id based on the Email provided from the UI
		
		String where = "mail_id='"+mailIdOrMobile+"'";
		
		List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where);
		
		if(carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null)
		{	
			CarsnikParkingForgetCredentialsVO carsnikParkingForgetCredentialsVO = new CarsnikParkingForgetCredentialsVO();
	        carsnikParkingForgetCredentialsVO.setMailIdOrMobile(mailIdOrMobile);
	    	carsnikParkingForgetCredentialsVO.setUserId(carsnikParkingUsersVOList.get(0).getUserId());
	    	carsnikParkingForgetCredentialsVO.setSentTime(sentTime);
	    	
	    	return forgetCredentialsService.sendCredentials(carsnikParkingForgetCredentialsVO,carsnikParkingUsersVOList.get(0).getMailId(),carsnikParkingUsersVOList.get(0).getPassword());
	    	
    	}
		else
		{
			return "Please provide the valid Email-Id";
		}
		
    	
    }
    //showSlots.htm
    
    @RequestMapping(value="/showSlots",method=RequestMethod.GET)
    public @ResponseBody String showSlots(HttpSession session) throws Exception {
    	
    	System.out.println("the show slots methos......!!");
    	String userId = session.getAttribute("userid").toString();
    	String where = "user_id='"+userId+"'";
        
    	System.out.println("showSlots.htm comes here...");
    	carsnikParkingAssignList = carsnikSlotAssignService.findByWhere(where);
    	System.out.println(carsnikParkingAssignList.size());
    	Iterator iterator = carsnikParkingAssignList.iterator();
    	
    	String assignedSlots = "";
    	if(carsnikParkingAssignList.size()>0 || carsnikParkingAssignList!=null)
    	{
    		
    		while(iterator.hasNext())
    		{
    			carsnikParkingAssignVO = (CarsnikParkingAssignVO) iterator.next();
    			assignedSlots += carsnikParkingAssignVO.getSlotNo()+"#";
    			System.out.println(assignedSlots);
    		}
    		
    	}
    	System.out.println(assignedSlots);
    	return assignedSlots;
    }
    
    @RequestMapping("/mainPage")
    public ModelAndView UserMainPage() {
    	return new ModelAndView("UserMainPage");
    }
    
    
    int ViolationCount=0 ;
    Date ViolationDate;
    String userName="";
	String status="";
    int avail_slot=0;    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public @ResponseBody String loginvalidate(@RequestParam("userid") String userid,@RequestParam("password") String password,HttpSession session) {
    	
    	String returnValue = "";
    	String slot_nos = "";
    	int userLevel;
    	
    	try {
    		// status to be checked and then only allowed to login
    		String where = "user_id='"+userid+"' and password = '"+password+"' and status='Y'";
    		System.out.println(where);
    		List<CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where);
    		
    		if(carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null)
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
    				returnValue = "Admin";
    			}
    			else{
    			    returnValue = "User";
    			}
    			
    			String vio_where = "vio_user_id='"+userid+"'";
        		List<Object[]> violationDetails = carsnikViolationService.findbyWhere(vio_where);
        		
        		if(violationDetails.get(0)[0]!=null)
        		{
        			
        		ViolationCount = (Integer)violationDetails.get(0)[0];
        		ViolationDate = (Date)violationDetails.get(0)[1];
        		session.setAttribute("ViolationCount", ViolationCount);
    			session.setAttribute("ViolationDate", ViolationDate);
        		}
        		else
        		{
        		
        			System.out.println("here comes the null pointer exception");
        			session.setAttribute("ViolationCount", ViolationCount);
        			session.setAttribute("ViolationDate", ViolationDate);
        		}
        		
        		
           		String slot_where = "slot_avail='Y'";
        		List<CarsnikParkingSlotsVO> carsnikParkingSlotsVOList = carsnikParkingSlotsService.findbyWhere(slot_where);
        		if(carsnikParkingSlotsVOList.size()>0){
        			avail_slot = carsnikParkingSlotsVOList.size();
        			Iterator itr = carsnikParkingSlotsVOList.iterator();
        			
        			while(itr.hasNext())
        			{
        				 carsnikParkingSlotsVO =(CarsnikParkingSlotsVO)itr.next();
        				 slot_nos += carsnikParkingSlotsVO.getSlotNo()+":";
        			}
        			session.setAttribute("availslots", avail_slot);
        			session.setAttribute("availslotnos", slot_nos);
        		}
        		else
        		{
        			session.setAttribute("availslots", avail_slot);
        			session.setAttribute("availslotnos", slot_nos);
        		}
        		
     		}
    		else
    		{
    			returnValue = "login failed";
    		}
    		
    					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return returnValue;
}

    
    
};