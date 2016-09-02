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
import com.carsnik.service.CarsnikVehicleRegisterService;
import com.carsnik.service.CarsnikViolationService;
import com.carsnik.vo.CarsnikParkingForgetCredentialsVO;
import com.carsnik.vo.CarsnikParkingUsersVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;
import com.carsnik.vo.CarsnikParkingViolationVO;

@Controller
public class ReportViolationController {

	
    @Autowired
	private CarsnikViolationService carsnikViolationService;

    @Autowired
	private CarsnikVehicleRegisterService carsnikVehicleRegisterService;

    @Autowired
	private CarsnikLoginService carsnikLoginService;
	
	 @RequestMapping("/reportviolation")
	    public ModelAndView reportViolation() {
	    	return new ModelAndView("ReportViolation");
	    }
	 
	 @RequestMapping(value="/reportViolation",method=RequestMethod.GET)
	    public @ResponseBody String reportViolation(@RequestParam("data") String data,HttpSession session) throws Exception {
		 System.out.println("REPORT VIOLATION CONTROLLER");
		 
		 try{
		    CarsnikParkingViolationVO carsnikParkingViolationVO = new CarsnikParkingViolationVO();
				
	    
		    String [] violation = data.split("@");
		    String vehicle_number = violation[0];
		    String slot_no = violation[1];
		    String compBy = session.getAttribute("userid").toString();
		    String activeOrInactive="Y";
		    String vioUserId ="";		    
		    int violationCount=0 ;
		    
		    carsnikParkingViolationVO.setVioCompBy(compBy);
		    carsnikParkingViolationVO.setSlotNo(Integer.parseInt(slot_no));
		    carsnikParkingViolationVO.setVehicleNo(vehicle_number);
		    
		    /*
		     * i.  get the user id based on the vehicle number from vechicle_details
		     * ii. get the violation count from the same table for that user and increment and set to violation count
		     * iii.if count greater than 3 set to inactive
		     * iv. set the current date
		     */
		    
		    // i.
		    
		    
		    String where="vehicle_number='"+vehicle_number+"'";;
		    CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO = carsnikVehicleRegisterService.findById(where);
		    
		    if(carsnikParkingVehicleDetailsVO!=null)
    		{
		     vioUserId = carsnikParkingVehicleDetailsVO.getUserId();
    		}
		    else
		    {
		    	return "Vehicle Number Not Found!";
		    }
		    carsnikParkingViolationVO.setVioUserId(vioUserId);
		    
		    //ii
		    String vio_where = "vio_user_id='"+vioUserId+"'";
    		List<Object[]> violationDetails = carsnikViolationService.findbyWhere(vio_where);
    		if(violationDetails.get(0)[0]!=null)
    		{
    		
    			violationCount = (Integer)violationDetails.get(0)[0];
    		}	    
		    //iii
    		violationCount = violationCount+1;
    		if(violationCount>3)
    		{
    			activeOrInactive = "N";
    			    
    			   System.out.println("UPDATING THE STATUS TO N in USERS TABLE");
    			    String where1="user_id='"+vioUserId+"'";
    			    
    			    List <CarsnikParkingUsersVO> carsnikParkingUsersVOList = carsnikLoginService.findbyWhere(where1);
    			    if(carsnikParkingUsersVOList.size()>0 || carsnikParkingUsersVOList!=null)
    			    {
    			    	carsnikParkingUsersVOList.get(0).setStatus("N");	
    			        carsnikLoginService.update(carsnikParkingUsersVOList.get(0));
    			    }

    		}
    		carsnikParkingViolationVO.setViolationCount(violationCount);
		    carsnikParkingViolationVO.setActiveOrInactive(activeOrInactive);
		    //iv
		    Date date = new Date();
			java.sql.Date violationDate = new java.sql.Date( date.getTime()); 
			
		    
		    carsnikParkingViolationVO.setViolationDate(violationDate);
		    
		    System.out.println(carsnikParkingViolationVO.toString());
		    carsnikViolationService.saveViolation(carsnikParkingViolationVO);
		    
		     
		    // update the status in the User Table also
		    
		  
		    return "Success";
		 }catch(Exception e)
		 {
			return "Violation Not Lodged"; 
		 }
	    }
	    
	
}
