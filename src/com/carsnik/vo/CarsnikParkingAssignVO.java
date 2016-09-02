package com.carsnik.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_assgn_slot")
public class CarsnikParkingAssignVO {
	
	private int sno;
	private String user_id="";
	private int slot_no;
	private Date assgn_date;
	
	
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
	@Column(name = "slot_no")
	public int getSlotNo() {
		return slot_no;
	}
	public void setSlotNo(int slotNo) {
		slot_no = slotNo;
	}
	@Column(name = "assgn_date")
	public Date getAssgnDate() {
		return assgn_date;
	}
	public void setAssgnDate(Date assgnDate) {
		assgn_date = assgnDate;
	}
	
	@Override
	public String toString() {
		return "CarsnikParkingSlotsAvailVO [assgn_date=" + assgn_date
				+ ", slot_no=" + slot_no + ", sno=" + sno + ", user_id="
				+ user_id + "]";
	}
	

}
