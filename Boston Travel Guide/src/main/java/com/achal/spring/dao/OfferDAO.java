package com.achal.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.Offer;
import com.achal.spring.pojo.User;

public class OfferDAO extends DAO {
	
	public OfferDAO(){
		
	}
	
	public Offer create(String place, String offer, String offerCode, String expiryDate, String expiryTime, User user)
            throws AdException {
        try {
            begin();
            Offer off = new Offer(place,offer,offerCode,expiryDate,expiryTime,user);
            //off.setPlace(place);
            //off.setOffer(offer);
            //off.setOfferCode(offerCode);
            //off.setExpiryDate(expiryDate);
            //off.setExpiryTime(expiryTime);
            //off.setUser(user);
            
            getSession().save(off);
            commit();
            return off;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not create offer " + e.getMessage());
            
        }
    } 
	
	public List getAllProducts() throws Exception{
	    try{
	    	begin();
            Query q = getSession().createQuery("from Offer");
            List list = q.list();
            commit();
            return list;
	    }
	    catch(Exception e)
	    {
	        throw e;
	    }
	}

}
