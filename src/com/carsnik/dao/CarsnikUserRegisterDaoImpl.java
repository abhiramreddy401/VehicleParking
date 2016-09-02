package com.carsnik.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingUsersVO;

@Repository("CarsnikUserRegisterDao")
public class CarsnikUserRegisterDaoImpl implements CarsnikUserRegisterDao {

	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void saveUser(CarsnikParkingUsersVO carsnikParkingUsersVO)
			throws Exception {
		// TODO Auto-generated method stub
		entityManager.persist(carsnikParkingUsersVO);
		entityManager.flush();
		

	}

}
