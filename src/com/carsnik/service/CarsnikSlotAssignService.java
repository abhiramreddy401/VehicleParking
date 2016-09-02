package com.carsnik.service;

import java.util.List;

import com.carsnik.vo.CarsnikParkingAssignVO;

public interface CarsnikSlotAssignService {

	
	public void saveAssignedSlot(CarsnikParkingAssignVO carsnikParkingAssignVO) throws java.lang.Exception;
	public void update(String assigned,int assign_slot)throws java.lang.Exception;
	public void delete(String id) throws java.lang.Exception;
	public List<CarsnikParkingAssignVO> findByWhere(String where) throws java.lang.Exception;
}
