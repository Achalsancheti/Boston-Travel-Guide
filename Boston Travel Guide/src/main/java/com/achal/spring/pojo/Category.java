package com.achal.spring.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.achal.spring.pojo.Advertisement;

@Entity
@Table(name="categoryTable")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="categoryid")
	private long id;
	
	@Column(name="title")
    private String title;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
	private Set<Advertisement> adverts = new HashSet<Advertisement>();

	public Category(String title) {
        this.title = title;
        this.adverts = new HashSet<Advertisement>();
    }
	
	Category() {
    }
	
	public Set<Advertisement> getAdverts() {
        return adverts;
    }

    void setAdverts(Set<Advertisement> adverts) {
        this.adverts = adverts;
    }
    
    public void addAdvert(Advertisement advert) {
        getAdverts().add(advert);
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
