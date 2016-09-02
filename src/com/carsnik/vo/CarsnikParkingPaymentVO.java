package com.carsnik.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_payment")
public class CarsnikParkingPaymentVO {
	
	private int payment_id;
	private String user_id="";
	private int amount;
	private String paid_unpaid="";
	private Date payment_date;
	private String slot_no="";
	
	@Id
	@Column(name = "payment_id")
	public int getPaymentId() {
		return payment_id;
	}
	public void setPaymentId(int paymentId) {
		payment_id = paymentId;
	}
	@Column(name = "user_id")
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		user_id = userId;
	}
	@Column(name = "amount")
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column(name = "paid_unpaid")
	public String getPaidUnpaid() {
		return paid_unpaid;
	}
	public void setPaidUnpaid(String paidUnpaid) {
		paid_unpaid = paidUnpaid;
	}
	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return payment_date;
	}
	public void setPaymentDate(Date paymentDate) {
		payment_date = paymentDate;
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
		return "CarsnikParkingPaymentVO [amount=" + amount + ", paid_unpaid="
				+ paid_unpaid + ", payment_date=" + payment_date
				+ ", payment_id=" + payment_id + ", slot_no=" + slot_no
				+ ", user_id=" + user_id + "]";
	}
	

	
	
	
	
	

}
