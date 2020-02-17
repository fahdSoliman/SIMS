package com.app.dao;

import java.time.LocalDate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Account;

@Repository
public class RegistrationDaoImpl implements IRegistrationDao {

	@Autowired
	public SessionFactory sf;
	
	@Override
	public void registerNewUser(Account account) {
			account.setRegDate(LocalDate.now());
			sf.getCurrentSession().save(account);
	}

}
