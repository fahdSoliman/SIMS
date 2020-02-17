package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.VMessages;

@Repository
public class VisitorDaoImpl implements IVisitorDao{

	@Autowired
	public SessionFactory sf;
	
	@Override
	public void sendMessage(VMessages message) {
		sf.getCurrentSession().save(message);
	}
	
	

}
