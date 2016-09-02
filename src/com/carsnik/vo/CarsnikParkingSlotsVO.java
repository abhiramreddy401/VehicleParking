package com.carsnik.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_slots_avail")
public class CarsnikParkingSlotsVO {
	
	private int slot_no;
	private String slot_avail="";
	
	@Id 
	@Column(name = "slot_no")
	public int getSlotNo() {
		return slot_no;
	}
	public void setSlotNo(int slotNo) {
		slot_no = slotNo;
	}
	
	@Column(name = "slot_avail")
	public String getSlotAvail() {
		return slot_avail;
	}
	public void setSlotAvail(String slotAvail) {
		slot_avail = slotAvail;
	}
	@Override
	public String toString() {
		return "CarsnikParkingSlots [slot_avail=" + slot_avail + ", slot_no="
				+ slot_no + "]";
	}
	
	
	
	

}
