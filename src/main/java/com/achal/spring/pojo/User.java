package com.achal.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person {
	
	@Column(name="userName")
	@NotNull
	@Size(min=3, max=15)
    private String userName;
	
	@Column(name="password")
	@NotNull
	@Size(min=5,max=16)
    private String password;
	
	@Column(name="roleType")
	@NotNull
	private String roleType;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private Email email;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
    private PhoneNumber number;
	
	public User(String userName, String password, String roleType) {
        this.userName = userName;
        this.password = password;
        this.roleType = roleType;
    }
	
	User() {
    }
	
	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

	public Email getEmail() {
		return email;
		
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
	public PhoneNumber getNumber(){
		return number;
	}
	
	public void setNumber(PhoneNumber number){
		this.number = number;
	}
}
