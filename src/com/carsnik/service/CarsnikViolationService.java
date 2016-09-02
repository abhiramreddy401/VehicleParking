package com.carsnik.service;

import java.util.List;

import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;
import com.carsnik.vo.CarsnikParkingViolationVO;

public interface CarsnikViolationService {
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception;
	public List<CarsnikParkingViolationVO> findbyId(String where) throws java.lang.Exception;
	public void saveViolation(CarsnikParkingViolationVO carsnikParkingViolationVO) throws java.lang.Exception;
	public List<CarsnikParkingViolationVO> findViolationsCount(String where) throws java.lang.Exception;
	public void updateVehicle(CarsnikParkingViolationVO carsnikParkingViolationVO)throws java.lang.Exception;
	

}
