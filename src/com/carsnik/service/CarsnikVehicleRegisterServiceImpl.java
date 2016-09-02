package com.carsnik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carsnik.dao.CarsnikVehicleRegisterDao;
import com.carsnik.vo.CarsnikParkingEntryVO;
import com.carsnik.vo.CarsnikParkingVehicleDetailsVO;

@Service("CarsnikVehicleRegisterService")
public class CarsnikVehicleRegisterServiceImpl implements CarsnikVehicleRegisterService {

	@Autowired
	CarsnikVehicleRegisterDao carsnikVehicleRegisterDao;
	
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void registerVehicle(CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO)
			throws Exception {
		// TODO Auto-generated method stub
		
		carsnikVehicleRegisterDao.registerVehicle(carsnikParkingVehicleDetailsVO);
		
		
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void updateVehicle(String assigned, int assignSlot) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public CarsnikParkingVehicleDetailsVO findById(String vehicleNumber)
			throws Exception {
		// TODO Auto-generated method stub
		return carsnikVehicleRegisterDao.findById(vehicleNumber);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CarsnikParkingVehicleDetailsVO> findByWhere(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return carsnikVehicleRegisterDao.findByWhere(where);
	}

	
	/**
	 * This method is used to Update the new data into Corrosponding Table.
	 * @param ecallInboundGroupsVO A ObjectVO containing the Information about the Corrosponding new VO Object.
	 * @exception Exception on error (if any).
	 */
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public void updateVehicle(
			CarsnikParkingVehicleDetailsVO carsnikParkingVehicleDetailsVO)
			throws Exception {
		// TODO Auto-generated method stub
		carsnikVehicleRegisterDao.update(carsnikParkingVehicleDetailsVO);
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CarsnikParkingEntryVO> findByDate(String where)
			throws Exception {
		// TODO Auto-generated method stub
		return carsnikVehicleRegisterDao.findByDate(where);
	}

	
}
