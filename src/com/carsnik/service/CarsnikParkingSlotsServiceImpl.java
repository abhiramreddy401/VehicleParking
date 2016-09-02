package com.carsnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikParkingSlotsDao;
import com.carsnik.vo.CarsnikParkingSlotsVO;
@Service("CarsnikParkingSlotsService")
public class CarsnikParkingSlotsServiceImpl implements
		CarsnikParkingSlotsService {

	
	@Autowired
	private CarsnikParkingSlotsDao carsnikParkingSlotsDao;
	
	
	
	@Transactional(readOnly=true)
	public List<CarsnikParkingSlotsVO> findbyWhere(String where) throws java.lang.Exception {
System.out.println(">>>wg==:"+where);
		int x = carsnikParkingSlotsDao.findbyWhere(where).size();
		System.out.println("SIZE:::::::::::::::::::::::::::"+x);
	return carsnikParkingSlotsDao.findbyWhere(where);
	}
}
