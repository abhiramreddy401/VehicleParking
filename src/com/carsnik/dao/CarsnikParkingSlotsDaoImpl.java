package com.carsnik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingSlotsVO;

@Repository("CarsnikParkingSlotsDao")
public class CarsnikParkingSlotsDaoImpl implements CarsnikParkingSlotsDao {
	
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 
	 	@Override
		@SuppressWarnings("unchecked")
		@Transactional(readOnly=true)
		public List<CarsnikParkingSlotsVO> findbyWhere(String where) throws java.lang.Exception {
	System.out.println("where condition comes here in dao");
	 		Query query = null;
			if(where != null)
			query = entityManager.createQuery("FROM CarsnikParkingSlotsVO o WHERE " + where);
			query.setFirstResult(0);
			query.setMaxResults(1);
			 return query.getResultList();
	 		
	 		
		}


}
