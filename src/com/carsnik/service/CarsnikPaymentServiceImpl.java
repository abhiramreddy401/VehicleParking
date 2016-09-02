package com.carsnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikPaymentDao;
import com.carsnik.dao.CarsnikVehicleRegisterDao;
import com.carsnik.vo.CarsnikParkingPaymentVO;

@Service("CarsnikPaymentService")
public class CarsnikPaymentServiceImpl implements CarsnikPaymentService{

	@Autowired
	CarsnikPaymentDao carsnikPaymentDao;
	
	
	@Override
	public void payment(CarsnikParkingPaymentVO carsnikParkingPaymentVO)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikPaymentDao.payment(carsnikParkingPaymentVO);
		
	}


	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(String where,String paidUnpaid)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikPaymentDao.update(where,paidUnpaid);
		
			
	}


	@Override
	public String findDueAmount(String where) throws Exception {
		// TODO Auto-generated method stub
		return carsnikPaymentDao.findDueAmount(where);
		
	}
	
	

}
