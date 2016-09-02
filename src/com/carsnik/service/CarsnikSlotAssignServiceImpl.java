package com.carsnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikSlotAssignDao;
import com.carsnik.vo.CarsnikParkingAssignVO;

@Service("CarsnikSlotAssignService")
public class CarsnikSlotAssignServiceImpl implements CarsnikSlotAssignService{

	@Autowired
	private CarsnikSlotAssignDao carsnikSlotAssignDao;
	
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public void saveAssignedSlot(CarsnikParkingAssignVO carsnikParkingAssignVO)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikSlotAssignDao.saveAssignedSlot(carsnikParkingAssignVO);
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void update(String assigned,int assign_slot)
			throws Exception {
		// TODO Auto-generated method stub
		 carsnikSlotAssignDao.update(assigned, assign_slot);
		
			
	}

	@Override
	@Transactional(readOnly=true)
	public List<CarsnikParkingAssignVO> findByWhere(String where)throws Exception {
		// TODO Auto-generated method stub
		return carsnikSlotAssignDao.findByWhere(where);
		
	}
	
	/**
	 * This method is used to remove the data from Corrosponding Table.
	 * @param id a String Containing the value of id.
	 * @exception Exception on error (if any).
	 */		
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void delete(String id)  throws java.lang.Exception {
		carsnikSlotAssignDao.delete(id);
	}

	
	
	
}
