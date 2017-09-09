package com.achal.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue
	@Column(name="personID",unique=true, nullable=false)
	private long personID;
	
	@Column(name="firstName")
	@NotNull
	@Size(min=2, max=12)
	private String firstName;
	
	@Column(name="lastName")
	@NotNull
	@Size(min=2, max=12)
	private String lastName;
	
	@Column(name="zipCode")
	@NotNull
	@Size(min=5, max=5)
	private String zipCode;
	
	@Column(name="gender")
	@NotNull
	private String gender;
	
	@Column(name="photoName")
	@NotNull
	private String photoName;
	
	@Transient
    private MultipartFile photo;
	
	public Person(){
		
	}
	
	public long getPersonID() {
		return personID;
	}

	public void setPersonID(long personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getZipCode(){
		return zipCode;
	}
	
	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}
	
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
}
