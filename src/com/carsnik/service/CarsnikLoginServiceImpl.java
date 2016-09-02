package com.carsnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikLoginDao;
import com.carsnik.vo.CarsnikParkingUsersVO;


@Service("CarsnikLoginService")
public class CarsnikLoginServiceImpl implements CarsnikLoginService{

	
	@Autowired
	private CarsnikLoginDao carsnikLoginDao;
	
	
	
	@Transactional(readOnly=true)
	public List<CarsnikParkingUsersVO> findbyWhere(String where) throws java.lang.Exception {
		//int x = carsnikLoginDao.findbyWhere(where).size();
		//System.out.println("SIZE:::::::::::::::::::::::::::"+x);
	return carsnikLoginDao.findbyWhere(where);
	}




	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(CarsnikParkingUsersVO carsnikParkingUsersVO) throws Exception {
		// TODO Auto-generated method stub
		carsnikLoginDao.update(carsnikParkingUsersVO);
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CarsnikParkingUsersVO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return carsnikLoginDao.findAll();
	}
	
}
