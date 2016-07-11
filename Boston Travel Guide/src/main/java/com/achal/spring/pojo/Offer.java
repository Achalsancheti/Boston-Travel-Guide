package com.achal.spring.pojo;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="offerTable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Offer {
	
	@Id
	@GeneratedValue
	@Column(name="offerId",unique=true, nullable=false)
    private long offerId;
	
	@Column(name="place")
	private String place;
	
	@Column(name="offer")
	private String offer;
	
	@Column(name="offerCode")
	private String offerCode;
	
	@Column(name="expiryDate")
	private String expirydate;
	
	@Column(name="expiryTime")
	private String expiryTime;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
	
	public Offer(String place,String offer, String offerCode, String expirydate, String expiryTime, User user){

		this.place=place;
		this.offer=offer;
		this.offerCode=offerCode;
		this.expirydate=expirydate;
		this.expiryTime=expiryTime;
		this.user=user;
	}
	
	Offer(){
		
	}	
	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}
	
	public String getExpiryDate() {
		return expirydate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expirydate = expiryDate;
	}
	
	public String getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
