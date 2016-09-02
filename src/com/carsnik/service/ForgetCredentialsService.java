package com.carsnik.service;

import com.carsnik.vo.CarsnikParkingForgetCredentialsVO;

public interface ForgetCredentialsService {
	
	public String sendCredentials(CarsnikParkingForgetCredentialsVO carsnikParkingForgetCredentialsVO,String to,String password) throws java.lang.Exception;

}
