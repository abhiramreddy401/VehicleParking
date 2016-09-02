package com.carsnik.dao;

import java.util.List;

import com.carsnik.vo.CarsnikParkingViolationVO;

public interface CarsnikViolationDao {
	
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception;
	public List<CarsnikParkingViolationVO> findbyId(String where) throws java.lang.Exception;
	public void save(CarsnikParkingViolationVO carsnikParkingViolationVO);
	public List<CarsnikParkingViolationVO> findViolationsCount(String where) throws java.lang.Exception;
	public void updateVehicle(CarsnikParkingViolationVO carsnikParkingViolationVO)throws java.lang.Exception;
}
