package com.carsnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikUserRegisterDao;
import com.carsnik.vo.CarsnikParkingUsersVO;

@Service("CarsnikUserRegisterService")
public class CarsnikUserRegisterServiceImpl implements
		CarsnikUserRegisterService {

	@Autowired
	CarsnikUserRegisterDao carsnikUserRegisterDao;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveUser(CarsnikParkingUsersVO carsnikParkingUsersVO)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikUserRegisterDao.saveUser(carsnikParkingUsersVO);

	}
	
	

}
