package com.carsnik.controller;

import java.util.Date;
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
import com.carsnik.service.CarsnikUserRegisterService;
import com.carsnik.vo.CarsnikParkingUsersVO;

@Controller
public class CarsnikUserRegisterController {
	
	@Autowired
	private CarsnikUserRegisterService carsnikUserRegisterService;

	@Autowired
	private CarsnikLoginService carsnikLoginService;


	public static final String VIEW_NAME="Register";
	
	@RequestMapping("/register")
    public ModelAndView register() {
    	
        return new ModelAndView(VIEW_NAME);
    }
	
	/*@RequestMapping(value="/registerRender",method=RequestMethod.GET)
    public @ResponseBody String registerUser(@RequestParam("data") String data,HttpSession session) throws Exception 
		{
			
			return data;
		}
	*/
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	    public @ResponseBody String registerUser(@RequestParam("data") String data,HttpSession session) throws Exception {
		
		String returnData="";
		try{
		System.out.println("data from the webpage::::"+data);
		String [] formData = data.split("@@");
		CarsnikParkingUsersVO carsnikParkingUsersVO = new CarsnikParkingUsersVO();
		
		String fname= formData[0];
		String lname = formData[1];
		String userId = formData[2];
		String password = formData[3];
		String rePassword = formData[4];
		String mailId = formData[5];
		String phoneNumber = formData[6];
		String address = formData[7];
		
		carsnikParkingUsersVO.setFName(fname);
		carsnikParkingUsersVO.setLName(lname);
		carsnikParkingUsersVO.setUserId(userId);
		carsnikParkingUsersVO.setPassword(password);
		carsnikParkingUsersVO.setRePassword(rePassword);
		carsnikParkingUsersVO.setMailId(mailId);
		carsnikParkingUsersVO.setPhoneNumber(phoneNumber);
		carsnikParkingUsersVO.setAddress(address);
	
		Date date = new Date();
		java.sql.Date regDate = new java.sql.Date( date.getTime()); 
		
		
		carsnikParkingUsersVO.setRegDate(regDate);
		carsnikParkingUsersVO.setStatus("Y");
		
		carsnikParkingUsersVO.toString();
		
		 
		carsnikUserRegisterService.saveUser(carsnikParkingUsersVO);
		returnData =  "Success";
		}
		catch(Exception e)
		{
			returnData = "Render not Registered";
		}
		System.out.println("Data Returned to the JSP::::"+returnData);
		return returnData;
	} 
	
	
	/*
	 *  While Registering the User --- User-id is created Dynamically by hitting the DB with Ajax Call
	 *  
	 */
	
    @RequestMapping(value="/getUserId",method=RequestMethod.GET)
    public @ResponseBody String getUserId(@RequestParam("data") String data,HttpSession session) throws Exception {
    	
    	String where = "user_id='"+data+"'";
    	System.out.println(":::::::::::::::::::"+where);
    	
    	List<CarsnikParkingUsersVO> carsnikParkingUsersVOList =  carsnikLoginService.findbyWhere(where);
    	if(carsnikParkingUsersVOList.size()>0)
    		return "Username already Exists";
    	else
    		return data;
    	
    	
    }
    

	
    
}
