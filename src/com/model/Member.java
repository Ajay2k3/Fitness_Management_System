package com.model;

import java.sql.Date;

public class Member {

	private int memberId;
	private String name;
	private String contact;
	private String email;
	private String address;
	private Date date_joined;
	private Boolean isActive;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Member() {

    }

	 public Member(int memberId, String name, String contact,
             String email, String address,
             Date date_joined, boolean isActive) {

   this.memberId = memberId;
   this.name = name;
   this.contact = contact;
   this.email = email;
   this.address = address;
   this.date_joined = date_joined;
   this.isActive = isActive;
}
	
}