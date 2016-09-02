package com.carsnik.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_entry")
public class CarsnikParkingEntryVO {
	
	private int Entry_Id;
	private String User_Name="";
	private String Vehicle_Number="";
	private String Entry_Time;
	
	@Id
	@Column(name="Entry_Id")
	public int getEntryId() {
		return Entry_Id;
	}
	public void setEntryId(int entryId) {
		Entry_Id = entryId;
	}
	@Column(name="User_Name")
	public String getUserName() {
		return User_Name;
	}
	public void setUserName(String userName) {
		User_Name = userName;
	}
	@Column(name="Vehicle_Number")
	public String getVehicleNumber() {
		return Vehicle_Number;
	}
	public void setVehicleNumber(String vehicleNumber) {
		Vehicle_Number = vehicleNumber;
	}
	@Column(name="Entry_Time")
	public String getEntryTime() {
		return Entry_Time;
	}
	public void setEntryTime(String entryTime) {
		Entry_Time = entryTime;
	}
	
	@Override
	public String toString() {
		return "CarsnikParkingEntryVO [Entry_Id=" + Entry_Id + ", Entry_Time="
				+ Entry_Time + ", User_Name=" + User_Name + ", Vehicle_Number="
				+ Vehicle_Number + "]";
	}
	
	
	
	

}
