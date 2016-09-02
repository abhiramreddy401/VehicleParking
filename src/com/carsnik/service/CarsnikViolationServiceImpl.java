package com.carsnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikViolationDao;
import com.carsnik.vo.CarsnikParkingViolationVO;

@Service("CarsnikViolationService")
public class CarsnikViolationServiceImpl implements CarsnikViolationService {
	
	@Autowired
	private CarsnikViolationDao carsnikViolationDao;
	
	
	
	@Transactional(readOnly=true)
	public List<Object[]> findbyWhere(String where) throws java.lang.Exception {
		
		return carsnikViolationDao.findbyWhere(where);
	
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveViolation(CarsnikParkingViolationVO carsnikParkingViolationVO)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikViolationDao.save(carsnikParkingViolationVO); 
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public List<CarsnikParkingViolationVO> findbyId(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return carsnikViolationDao.findbyId(where);
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public List<CarsnikParkingViolationVO> findViolationsCount(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return carsnikViolationDao.findViolationsCount(where);
		
	}



	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void updateVehicle(
			CarsnikParkingViolationVO carsnikParkingViolationVO)
			throws Exception {
		// TODO Auto-generated method stub
		
		carsnikViolationDao.updateVehicle(carsnikParkingViolationVO);
		
	}

}
