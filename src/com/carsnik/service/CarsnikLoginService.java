package com.carsnik.service;

import java.util.List;

import com.carsnik.vo.CarsnikParkingUsersVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;

public interface CarsnikLoginService {
	
	public List<CarsnikParkingUsersVO> findAll() throws java.lang.Exception;
	public List<CarsnikParkingUsersVO> findbyWhere(String where) throws java.lang.Exception; 
	public void update(CarsnikParkingUsersVO carsnikParkingUsersVO)throws java.lang.Exception;
}
