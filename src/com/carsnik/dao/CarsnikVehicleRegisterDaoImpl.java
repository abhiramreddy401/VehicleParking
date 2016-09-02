package com.carsnik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingEntryVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;

@Repository("CarsnikVehicleRegisterDao")
public class CarsnikVehicleRegisterDaoImpl implements CarsnikVehicleRegisterDao{
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 @Override
	 @Transactional(readOnly=true)
	public void registerVehicle(
				CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO)
				throws Exception {
			// TODO Auto-generated method stub
		 	entityManager.persist(carsnikParkingVehicleDetailsVO);
		   	entityManager.flush();
			
		}
	
	@Override
	@Transactional(readOnly=true)
	public void updateVehicle(String assigned, int assignSlot) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional(readOnly=true)
	public CarsnikParkingVehicleDetailsVO findById(String where)  {
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM CarsnikParkingVehicleDetailsVO o WHERE " + where);
		 return (CarsnikParkingVehicleDetailsVO) query.getResultList().get(0);
		 
		 //return  (CarsnikParkingVehicleDetailsVO)entityManager.find(CarsnikParkingVehicleDetailsVO.class, vehicleNumber);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<CarsnikParkingVehicleDetailsVO> findByWhere(String where) {
		// TODO Auto-generated method stub
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM CarsnikParkingVehicleDetailsVO o WHERE " + where);
		 return query.getResultList();
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(
			CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO) {
		// TODO Auto-generated method stub
		   entityManager.merge(carsnikParkingVehicleDetailsVO);	
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<CarsnikParkingEntryVO> findByDate(String where)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = null;
		if(where != null)
		query = entityManager.createQuery("FROM CarsnikParkingEntryVO o WHERE " + where);
		 return query.getResultList();
	
	}
	
	
	

	
}
