package com.achal.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="numberTable")
public class PhoneNumber {
	
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property",value="user"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=false, nullable=false)
	private long id;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="id")
	private User user;
	
	public PhoneNumber() {
	}
	
	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public User getUser() {
	    return user;
	}
		
	public void setUser(User user) {
		this.user = user;
	}

}
