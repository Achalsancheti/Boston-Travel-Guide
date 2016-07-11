package com.achal.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.achal.spring.dao.DAO;
import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Advertisement;
import com.achal.spring.pojo.Category;
import com.achal.spring.pojo.User;
import com.achal.spring.pojo.Advertisement;

public class AdvertisementDAO extends DAO {
	
	public Advertisement create(String title, String message, User user, long category_id,String categoryName, String location, String phoneNumber, String photoName, String status, String recommendation)
            throws AdException {
        try {
            begin();
            Advertisement advert = new Advertisement(title, message, user, category_id, categoryName, location,phoneNumber,photoName,status,recommendation);
            getSession().save(advert);
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating advert: " + e.getMessage());
        }
    }
	
	public List viewRestaurents() throws AdException {
		try {
            begin();
            Query q = getSession().createQuery("Select adverts from Category ct where ct.title= 'Restaurent'");
            
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
	}
	
	public List viewHotels() throws AdException {
		try {
            begin();
            Query q = getSession().createQuery("Select adverts from Category ct where ct.title= 'Hotel'");
            
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
	}
	
	public List viewMuseums() throws AdException {
		try {
            begin();
            Query q = getSession().createQuery("Select adverts from Category ct where ct.title= 'Museum'");
            
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
	}
	
	public List viewNightClubs() throws AdException {
		try {
            begin();
            Query q = getSession().createQuery("Select adverts from Category ct where ct.title= 'NightClub'");
            
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
	}
	
	public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Advertisement where recommendation='Recommended'");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
    }
	
	
	
	public int update(String recommendation, String title) throws AdException{
		try {
            begin();
            Query q=getSession().createQuery("update Advertisement A1 set recommendation = :recommendation where A1.title= :title");
            q.setString("recommendation",recommendation);
            q.setString("title",title);
            int n = q.executeUpdate();
            commit();
            return n;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category" + e.getMessage());
        }
	}
	
	public int approve(String status, String title) throws AdException{
		try {
            begin();
            Query q=getSession().createQuery("update Advertisement A1 set status = :status where A1.title= :title");
            q.setString("status",status);
            q.setString("title",title);
            int n = q.executeUpdate();
            commit();
            return n;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named category" + e.getMessage());
        }
	}
	
	public List approvelist() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Advertisement where status='Approved'");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the advertisement", e);
        }
    }
	
	 public void delete(Long category)
	            throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("delete from Advertisement where category = :category");
	            q.setLong("category", category);
	            q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete advert", e);
	        }
	 }

}
