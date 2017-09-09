package com.achal.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.annotations.Cascade;

import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.User;
import com.achal.spring.pojo.Email;
import com.achal.spring.pojo.PhoneNumber;

public class UserDAO extends DAO {

	public UserDAO() {
    }
	
	public User get(String userName)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName = :userName");
            q.setString("userName", userName);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }
	
	public List getit() throws AdException{
		try {
            begin();
            Query q = getSession().createQuery("from User");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
	}
	
	public User create(String userName, String password, String roleType,String emailId, String firstName, String lastName, String phoneNumber, String zipCode, String gender, String photoName)
            throws AdException {
        try {
            begin();
            
            Email email=new Email(emailId);
            PhoneNumber number = new PhoneNumber(phoneNumber);
            User user=new User(userName,password,roleType);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setGender(gender);
            user.setNumber(number);
            user.setZipCode(zipCode);
            user.setPhotoName(photoName);
            
            email.setUser(user);
            number.setUser(user);
            
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public void delete(Long personID)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where personID = :personID");
            q.setLong("personID", personID);
            q.executeUpdate();
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + personID, e);
        }
    }
}
