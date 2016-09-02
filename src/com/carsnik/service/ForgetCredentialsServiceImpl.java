package com.carsnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.ForgetCredentialsDao;
import com.carsnik.vo.CarsnikParkingForgetCredentialsVO;

@Service("ForgetCredentialsService")
public class ForgetCredentialsServiceImpl implements ForgetCredentialsService{
	
	@Autowired
	ForgetCredentialsDao forgetCredentialsDao;
		
	@Override
	@Transactional(readOnly=true)
	public String sendCredentials(CarsnikParkingForgetCredentialsVO carsnikParkingForgetCredentialsVO,String to,String password)
			throws Exception {
		// TODO Auto-generated method stub
		
		return forgetCredentialsDao.sendCredentials(carsnikParkingForgetCredentialsVO,to,password);
		
	}

	
	

}
