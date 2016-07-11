package com.achal.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.achal.spring.pojo.User;

@Entity
@Table(name="advertisementTable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Advertisement {

	@Id
	@GeneratedValue
	@Column(name="advertId",unique=true, nullable=false)
    private long id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="message")
    private String message;
	
	@Column(name="photoName")
	private String photoName;
	
	@Transient
    private MultipartFile photo;
	
	@Transient //we don't have any column in database therefore used transient
    private String postedBy;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
	
	@Transient
    private String category_name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="recommendation")
	private String recommendation;
    
    @JoinColumn(name="categoryId")
    private long category;
    
    public Advertisement(String title, String message, User user, long category_id,String categoryName, String location, String phoneNumber, String photoName, String status, String recommendation) {
        this.title = title;
        this.message = message;
        this.photoName = photoName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.category = category_id;
        this.category_name = categoryName;
        this.status=status;
        this.recommendation=recommendation;
    }
    
    Advertisement() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(String pb) {
        this.postedBy = pb;
    }

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
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
    
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
}
