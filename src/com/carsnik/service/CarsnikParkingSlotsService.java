package com.carsnik.service;

import java.util.List;

import com.carsnik.vo.CarsnikParkingSlotsVO;

public interface CarsnikParkingSlotsService {

	public List<CarsnikParkingSlotsVO> findbyWhere(String where) throws java.lang.Exception;
}
