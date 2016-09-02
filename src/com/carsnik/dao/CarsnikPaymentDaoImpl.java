package com.carsnik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.vo.CarsnikParkingPaymentVO;
import com.carsnik.vo.CarsnikParkingSlotsVO;

@Repository("CarsnikPaymentDao")
public class CarsnikPaymentDaoImpl implements CarsnikPaymentDao{

	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }

	 @Override
	 @Transactional(readOnly=true)
	 public void payment(CarsnikParkingPaymentVO carsnikParkingPaymentVO)
			throws Exception {
		// TODO Auto-generated method stub
		 entityManager.persist(carsnikParkingPaymentVO);
		 entityManager.flush();
		
	}

	 @Override
		@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
		public void update(String where,String paidUnpaid)
				throws Exception {
			// TODO Auto-generated method stub
			
	    	Query query = null;
			if(where != null)
			query = entityManager.createQuery("FROM CarsnikParkingPaymentVO o WHERE " + where);
			CarsnikParkingPaymentVO carsnikParkingPaymentVO = (CarsnikParkingPaymentVO) query.getSingleResult();
			carsnikParkingPaymentVO.setPaidUnpaid(paidUnpaid);
			entityManager.merge(carsnikParkingPaymentVO);
	    	
		}

	@Override
	public String findDueAmount(String where) throws Exception {
		// TODO Auto-generated method stub
 		Query query = null;
 		System.out.println("SELECT sum(amount) FROM parking_payment p  where paid_unpaid='N' and user_id="+where);
		if(where != null)
		query = entityManager.createNativeQuery("SELECT sum(amount) FROM parking_payment p  where paid_unpaid='N' and user_id='"+where+"'");
		List <Object>list= query.getResultList();
		System.out.println("######################## List data ##########"+list.get(0));
		if(list.get(0)!=null)
		{
			System.out.println("list data:::::"+list.get(0).toString());
		return  list.get(0).toString();
		}
		else
		{
			System.out.println("NO DATA DUDE");
		return "No Data";
		}	
	}


}
