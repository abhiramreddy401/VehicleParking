package com.carsnik.dao;

import com.carsnik.vo.CarsnikParkingForgetCredentialsVO;

public interface ForgetCredentialsDao {
	public String sendCredentials(CarsnikParkingForgetCredentialsVO carsnikParkingForgetCredentialsVO,String to,String password) throws java.lang.Exception;
}
