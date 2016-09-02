package com.carsnik.service;

import com.carsnik.vo.CarsnikParkingPaymentVO;

public interface CarsnikPaymentService {
	public void payment(CarsnikParkingPaymentVO carsnikParkingPaymentVO) throws java.lang.Exception;
	public void update(String where,String paidUnpaid) throws java.lang.Exception;
	public String findDueAmount(String where) throws java.lang.Exception;
}
