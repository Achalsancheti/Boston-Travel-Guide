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
import org.hibernate.validator.constraints.NotEmpty;

import com.achal.spring.pojo.User;

@Entity
@Table(name="emailTable")
public class Email {

	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property",value="user"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=false, nullable=false)
	private long id;
	
	@Column(name="emailId")
	@NotEmpty
	@org.hibernate.validator.constraints.Email
	private String emailId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="id")
	private User user;
	
	public Email() {
	}

	public Email(String emailId) {
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public User getUser() {
	    return user;
	}
		
	public void setUser(User user) {
		this.user = user;
	}
	
}
