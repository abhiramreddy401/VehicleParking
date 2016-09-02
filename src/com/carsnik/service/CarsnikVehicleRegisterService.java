package com.carsnik.service;

import java.util.List;

import com.carsnik.vo.CarsnikParkingEntryVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;

public interface CarsnikVehicleRegisterService {

	
	public void registerVehicle(CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO) throws java.lang.Exception;
	public void updateVehicle(CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO)throws java.lang.Exception;
	public void updateVehicle(String assigned,int assign_slot)throws java.lang.Exception;
	public CarsnikParkingVehicleDetailsVO findById(String vehicleNumber) throws java.lang.Exception;
	public List<CarsnikParkingVehicleDetailsVO> findByWhere(String where) throws java.lang.Exception;
	public List<CarsnikParkingEntryVO> findByDate(String where) throws java.lang.Exception;
	
}
