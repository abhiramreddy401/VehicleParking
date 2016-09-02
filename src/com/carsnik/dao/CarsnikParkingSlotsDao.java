package com.carsnik.dao;

import java.util.List;

import com.carsnik.vo.CarsnikParkingSlotsVO;

public interface CarsnikParkingSlotsDao {
	
	public List<CarsnikParkingSlotsVO> findbyWhere(String where) throws java.lang.Exception;

}
