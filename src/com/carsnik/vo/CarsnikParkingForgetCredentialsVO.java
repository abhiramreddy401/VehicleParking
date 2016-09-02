package com.carsnik.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_forget_credentials")
public class CarsnikParkingForgetCredentialsVO {

	private int sno;
	private String user_id="";
	private String mail_id_or_mobile="";
	private Date sent_time;
	
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
	@Column(name = "mail_id_or_mobile")
	public String getMailIdOrMobile() {
		return mail_id_or_mobile;
	}
	public void setMailIdOrMobile(String mailIdOrMobile) {
		mail_id_or_mobile = mailIdOrMobile;
	}
	@Column(name = "sent_time")
	public Date getSentTime() {
		return sent_time;
	}
	public void setSentTime(Date sentTime) {
		sent_time = sentTime;
	}
	
	@Override
	public String toString() {
		return "CarsnikParkingForgetCredentialsVO [mail_id_or_mobile="
				+ mail_id_or_mobile + ", sent_time=" + sent_time + ", sno="
				+ sno + ", user_id=" + user_id + "]";
	}
		
}
