package com.carsnik.dao;

import java.util.List;

import com.carsnik.vo.CarsnikParkingUsersVO;

public interface CarsnikLoginDao {
	
	public List<CarsnikParkingUsersVO> findAll() throws java.lang.Exception;
	public List<CarsnikParkingUsersVO> findbyWhere(String where) throws java.lang.Exception;
	public void update(CarsnikParkingUsersVO carsnikParkingUsersVO)throws java.lang.Exception;
	

}
