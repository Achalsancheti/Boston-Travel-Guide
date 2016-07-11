package com.achal.spring.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.achal.spring.exception.AdException;
import com.achal.spring.pojo.User;

public class LoginDAO extends DAO {

	public LoginDAO() {
    }
	
	public User get(String userName, String password, String roleType)throws AdException
    {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName = :userName and password = :password and roleType= :roleType");
            q.setString("userName", userName);
            q.setString("password", password);
            q.setString("roleType", roleType);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + userName, e);
        }
    }
	
	
}
