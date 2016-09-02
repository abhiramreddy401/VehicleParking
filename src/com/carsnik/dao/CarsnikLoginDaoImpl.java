package com.carsnik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingUsersVO;

@Repository("CarsnikLoginDao")
public class CarsnikLoginDaoImpl implements CarsnikLoginDao{
	
	
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 
	 	@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<CarsnikParkingUsersVO> findbyWhere(String where) throws java.lang.Exception {
	
	 		Query query = null;
			if(where != null)
				query = entityManager.createQuery("FROM CarsnikParkingUsersVO o WHERE " + where);
			 return query.getResultList();
	 		
	 		
		}


	 	@Override
		@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
		public void update(CarsnikParkingUsersVO carsnikParkingUsersVO)
				throws Exception {
			// TODO Auto-generated method stub
	 		entityManager.merge(carsnikParkingUsersVO);
		}


	 	@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<CarsnikParkingUsersVO> findAll() throws Exception {
			// TODO Auto-generated method stub
	 		Query query = entityManager.createQuery("FROM CarsnikParkingUsersVO o");
			 return query.getResultList();

		}
		
		
	 
	 
	 
}
