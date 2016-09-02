package com.carsnik.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_vehicle_details")
public class CarsnikParkingVehicleDetailsVO {
	
	private int sno;
	private String user_id="";
	private String vehicle_number="";
	private String make = "";
	private String model="";
	private String year="";
	private String slot_no="";
	
	@Id
	@Column(name = "sno")
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}

	@Column(name = "user_id")
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		user_id = userId;
	}
	@Column(name = "vehicle_number")
	public String getVehicleNumber() {
		return vehicle_number;
	}
	public void setVehicleNumber(String vehicleNumber) {
		vehicle_number = vehicleNumber;
	}
	@Column(name = "make")
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	@Column(name = "model")
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Column(name = "year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	@Column(name = "slot_no")
	public String getSlotNo() {
		return slot_no;
	}
	public void setSlotNo(String slotNo) {
		slot_no = slotNo;
	}
	@Override
	public String toString() {
		return "CarsnikParkingVehicleDetailsVO [make=" + make + ", model="
				+ model + ", slot_no=" + slot_no + ", sno=" + sno
				+ ", user_id=" + user_id + ", vehicle_number=" + vehicle_number
				+ ", year=" + year + "]";
	}
	
	
	

}
