package com.carsnik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingAssignVO;
import com.carsnik.vo.CarsnikParkingSlotsVO;
@Repository("CarsnikSlotAssignDao")
public class CarsnikSlotAssignDaoImpl implements CarsnikSlotAssignDao{

	@PersistenceContext        
	private EntityManager entityManager;
	public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void saveAssignedSlot(CarsnikParkingAssignVO carsnikParkingAssignVO)
			throws Exception {
		// TODO Auto-generated method stub
		entityManager.persist(carsnikParkingAssignVO);
	   	entityManager.flush();
	}
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(String assigned,int assign_slot)
			throws Exception {
		// TODO Auto-generated method stub
		
		CarsnikParkingSlotsVO carsnikParkingSlotsVO = entityManager.find( CarsnikParkingSlotsVO.class, assign_slot);   
		carsnikParkingSlotsVO.setSlotAvail("N");
    	entityManager.merge(carsnikParkingSlotsVO); 
	}


	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<CarsnikParkingAssignVO> findByWhere(String where) throws Exception {
		Query query = null;
		if(where != null)
		{
		query = entityManager.createQuery("FROM CarsnikParkingAssignVO o WHERE " + where);
		}
		return query.getResultList();
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void delete(String id) {
		Integer idInt=Integer.parseInt(id);
		CarsnikParkingAssignVO carsnikParkingAssignVO = entityManager.find(CarsnikParkingAssignVO.class, idInt);
	    	entityManager.remove(carsnikParkingAssignVO);
	}
	
	
}	
	
	