package com.carsnik.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_users")
public class CarsnikParkingUsersVO {

	
	private String user_id="";
	private String password="";
	private String re_password="";
	private String f_name="";
	private String l_name="";
	private String mail_id="";
	private String address="";
	private String phone_number="";
	private Date reg_date;
	private String status="";	
	private int level;
	
	public CarsnikParkingUsersVO() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("default Constructer invoked dude...");
	}
	
	
	public CarsnikParkingUsersVO(String userId, String password,
			String rePassword, String fName, String lName, String mailId,
			String address, String phoneNumber, Date regDate, String status,
			int level) {
		super();
		user_id = userId;
		this.password = password;
		re_password = rePassword;
		f_name = fName;
		l_name = lName;
		mail_id = mailId;
		this.address = address;
		phone_number = phoneNumber;
		reg_date = regDate;
		this.status = status;
		this.level = level;
	}






	@Id 
	@Column(name = "user_id")
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		user_id = userId;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "re_password")
	public String getRePassword() {
		return re_password;
	}
	public void setRePassword(String rePassword) {
		re_password = rePassword;
	}
	@Column(name = "f_name")
	public String getFName() {
		return f_name;
	}
	public void setFName(String fName) {
		f_name = fName;
	}
	@Column(name = "l_name")
	public String getLName() {
		return l_name;
	}
	public void setLName(String lName) {
		l_name = lName;
	}
	@Column(name = "mail_id")
	public String getMailId() {
		return mail_id;
	}
	
	public void setMailId(String mailId) {
		mail_id = mailId;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phoneNumber) {
		phone_number = phoneNumber;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "reg_date")
	public Date getRegDate() {
		return reg_date;
	}
	public void setRegDate(Date regDate) {
		reg_date = regDate;
	}
  
	
	@Column(name = "level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "CarsnikParkingUsersVO [address=" + address + ", f_name="
				+ f_name + ", l_name=" + l_name + ", level=" + level
				+ ", mail_id=" + mail_id + ", password=" + password
				+ ", phone_number=" + phone_number + ", re_password="
				+ re_password + ", reg_date=" + reg_date + ", status=" + status
				+ ", user_id=" + user_id + "]";
	}

	
}


