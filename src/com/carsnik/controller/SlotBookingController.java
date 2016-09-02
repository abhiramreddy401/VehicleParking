package com.carsnik.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carsnik.service.CarsnikParkingSlotsService;
import com.carsnik.service.CarsnikPaymentService;
import com.carsnik.service.CarsnikSlotAssignService;
import com.carsnik.service.CarsnikVehicleRegisterService;
import com.carsnik.vo.CarsnikParkingAssignVO;
import com.carsnik.vo.CarsnikParkingPaymentVO;
import com.carsnik.vo.CarsnikParkingSlotsVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;

@Controller
public class SlotBookingController {
	
	@Autowired
	private CarsnikParkingSlotsService carsnikParkingSlotsService;
	
	@Autowired
	private CarsnikSlotAssignService carsnikSlotAssignService;
	
	@Autowired
	private CarsnikVehicleRegisterService carsnikVehicleRegisterService;
	
	@Autowired
	private CarsnikPaymentService carsnikPaymentService;
	
	private int assign_slot ;
    private String slotNo;	
	@RequestMapping("/rentspace")
    public ModelAndView rentParking(HttpSession session) throws Exception {
		
		// allot a slot to user 
		
		System.out.println("parking lot .....assign");
		
		String slot_where = "slot_avail='Y'";
		List<CarsnikParkingSlotsVO> availSlot = carsnikParkingSlotsService.findbyWhere(slot_where);
		if(availSlot.size()>0){
			
			System.out.println(">>>AVAIL SLOT>>>"+availSlot.get(0).getSlotNo());
			assign_slot = availSlot.get(0).getSlotNo();
			
			CarsnikParkingAssignVO carsnikParkingAssignVO = new CarsnikParkingAssignVO();
			
			Date date = new Date();
			java.sql.Date assignDate = new java.sql.Date( date.getTime()); 
			
			carsnikParkingAssignVO.setAssgnDate(assignDate);
			carsnikParkingAssignVO.setSlotNo(assign_slot);
			carsnikParkingAssignVO.setUserId(session.getAttribute("userid").toString());
			
			// saving the values in the  parking_assgn_slot table
			carsnikSlotAssignService.saveAssignedSlot(carsnikParkingAssignVO);
			// updating the slot availabilinty in parking_slots_avail table
			String assigned="N";
			carsnikSlotAssignService.update(assigned,assign_slot);
			}
		return new ModelAndView("RentParkingSlot","Assigned",assign_slot);
    }
	
	
	
    @RequestMapping(value="/vehicleregister",method=RequestMethod.GET)
    public @ResponseBody String vehicleRegister(@RequestParam("data") String data,HttpSession session) throws Exception {
    	try{
    	String [] vehicleData = data.split("@");

    	String make = vehicleData[0];
    	String model = vehicleData[1];
    	String year = vehicleData[2];
    	String planeNo = vehicleData[3];
    	String slotNo = vehicleData[4];
    	String userId = session.getAttribute("userid").toString();
    	 
    	assign_slot = Integer.parseInt(slotNo);
    	CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO = new CarsnikParkingVehicleDetailsVO();
    	carsnikParkingVehicleDetailsVO.setMake(make);
    	carsnikParkingVehicleDetailsVO.setModel(model);
    	carsnikParkingVehicleDetailsVO.setUserId(userId);
    	carsnikParkingVehicleDetailsVO.setVehicleNumber(planeNo);
    	carsnikParkingVehicleDetailsVO.setYear(year);
    	carsnikParkingVehicleDetailsVO.setSlotNo(slotNo);
    	carsnikVehicleRegisterService.registerVehicle(carsnikParkingVehicleDetailsVO);
    	
    	System.out.println("After Vehicle Registration");

    	// At the time on registering the vehicle we are inserting the record in the Payment Table
    	  // so that we get the paid and un paid users for their slots
    	
    	Date date = new Date();
		java.sql.Date paymentDate = new java.sql.Date(date.getTime());
		
    	CarsnikParkingPaymentVO carsnikParkingPaymentVO = new CarsnikParkingPaymentVO();
    	carsnikParkingPaymentVO.setAmount(200);
    	carsnikParkingPaymentVO.setPaidUnpaid("N");
    	carsnikParkingPaymentVO.setPaymentDate(paymentDate);
    	carsnikParkingPaymentVO.setUserId(userId);
    	carsnikParkingPaymentVO.setSlotNo(slotNo);

    	System.out.println(":::::"+carsnikParkingPaymentVO.toString());  
    	carsnikPaymentService.payment(carsnikParkingPaymentVO);

    	
    	return "Success";
    	}
    	catch(Exception e)
    	{
    		
    		/*carsnikSlotAssignService.delete(slotNo);
    		
    		String assigned="Y";
			carsnikSlotAssignService.update(assigned,assign_slot);*/
    		return "Vehicle Not Registered";
    	}
    }
    
    /*
     * The below method is to show the vehicles in the slot
     */
    @RequestMapping(value = "/viewSlotDetails", method = RequestMethod.GET)
    public ModelAndView viewSlotDetails(@RequestParam String slotno) throws Exception {
     	System.out.println("Here in the View Slot Details Controller.."+slotno);
     	
     	String slot_where = "slot_no='"+slotno+"'";
     	System.out.println("String Constructed by the parameter sent from JSP Page"+slot_where);
     	
     	List<CarsnikParkingVehicleDetailsVO> carsnikParkingVehicleDetailsVOList = carsnikVehicleRegisterService.findByWhere(slot_where);
    	
     	Map<String,Object> map = new HashMap<String,Object>();
     	map.put("vehicles", carsnikParkingVehicleDetailsVOList);
     	map.put("slot_no", slotno);
     	return new ModelAndView("ViewSlotDetails","model",map);
    	
    }

     /*
      * 
      * Below methos is for update the vehicle details in the DB
      * 
      */
    @RequestMapping(value="/vehicleUpdate",method=RequestMethod.GET)
    public @ResponseBody String vehicleUpdate(@RequestParam("data") String data,HttpSession session) throws Exception {
    	try{
    		
    	String [] vehicleData = data.split("@");

    	String make = vehicleData[0];
    	String model = vehicleData[1];
    	String year = vehicleData[2];
    	String planeNo = vehicleData[3];
    	
    	System.out.println("::::::::::::::::::::"+planeNo);
    	String vehicle_number = "vehicle_number='"+planeNo+"'";
    	List<CarsnikParkingVehicleDetailsVO> carsnikParkingVehicleDetailsVOList = carsnikVehicleRegisterService.findByWhere(vehicle_number);
    	
    	System.out.println("BEFORE UPDATE:::"+carsnikParkingVehicleDetailsVOList.get(0).toString());
    	
    	CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO =carsnikParkingVehicleDetailsVOList.get(0);
    	carsnikParkingVehicleDetailsVO.setMake(make);
    	carsnikParkingVehicleDetailsVO.setModel(model);
    	carsnikParkingVehicleDetailsVO.setVehicleNumber(planeNo);
    	carsnikParkingVehicleDetailsVO.setYear(year);
    	
    	System.out.println(carsnikParkingVehicleDetailsVO.toString());
    	carsnikVehicleRegisterService.updateVehicle(carsnikParkingVehicleDetailsVO);
    	
    	return "Success";
    	}
    	catch(Exception e)
    	{
    		
    		/*carsnikSlotAssignService.delete(slotNo);
    		
    		String assigned="Y";
			carsnikSlotAssignService.update(assigned,assign_slot);*/
    		return "Vehicle Not Updated Vehicle..!!";
    	}
    }

    	
    	
    
    
    //////////////////////////////////////////// PAYMENT //////////////////////////////////////////
	//@RequestMapping("/payment")
	@RequestMapping(value="/payment",method=RequestMethod.GET)
    public ModelAndView payments(@RequestParam("slot_no") String slot) {
		System.out.println("Parking payment.................."+slot);
		
		ModelAndView model = new ModelAndView("Payment");
		model.addObject("slotno", slot);
		
		return model;
		
		//return new ModelAndView("Payment","slotno",slot);
    }
	
    
	
	@RequestMapping(value="/paymentGateway",method=RequestMethod.POST)
    public @ResponseBody String paymentGateway(@RequestParam("data") String data,HttpSession session) throws Exception {

		try{
		String paidUnpaid = "Y";
		System.out.println("The payment details::::"+data);
		String [] arr = data.split("@@");
		
		int amount = Integer.parseInt(arr[0]);
		String slotno = arr[1];
		System.out.println("The slot number is::::::"+slotno);
    	String userId = session.getAttribute("userid").toString();
    	Date date = new Date();
		java.sql.Date paymentDate = new java.sql.Date(date.getTime());
		
		// update the record which was inserted at the time of vehicle registered against the slot
		System.out.println("UPDATE PAYMENT RECORD FOR GIVEN SLOT");
		
    	CarsnikParkingPaymentVO carsnikParkingPaymentVO = new CarsnikParkingPaymentVO();
    	carsnikParkingPaymentVO.setAmount(amount);
    	carsnikParkingPaymentVO.setPaidUnpaid(paidUnpaid);
    	carsnikParkingPaymentVO.setPaymentDate(paymentDate);
    	carsnikParkingPaymentVO.setUserId(userId);
    	carsnikParkingPaymentVO.setSlotNo(slotno);
    	
    	String where = "slot_no='"+slotno+"'";
    	carsnikPaymentService.update(where,paidUnpaid);

    	return "Success";
		}
		catch(Exception e)
		{
			return "Payment Failure";
		}
		
    }
    

}
