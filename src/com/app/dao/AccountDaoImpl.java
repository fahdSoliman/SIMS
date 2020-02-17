package com.app.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Account;

@Repository //mandatory
public class AccountDaoImpl implements IAccountDao {
	// dependency -- auto wiring by type --field level D.I
	@Autowired // byType
	public  SessionFactory sf;
	
	
	public AccountDaoImpl() {
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public Account validateUser(String usr1, String pass1) {
		String jpql = "select a from Account a where a.userLogin=:usr and a.password=:pass";
		return sf.getCurrentSession().
				createQuery(jpql, Account.class).
				setParameter("usr", usr1).
				setParameter("pass", pass1).getSingleResult();
	}

	@Override
	public Account UpdatePass(String newpass,int id) {
		
		String jpql = "update Account a set a.password=:newpass where a.UID=:uid";
		 sf.getCurrentSession().
				createQuery(jpql).
				setParameter("newpass", newpass).
				setParameter("uid",id).executeUpdate();
		 return null;
		 
	}
	@Override
	public Account getAccountDetails(int id) {
		return sf.getCurrentSession().get(Account.class, id);
	}

	@Override
	public SessionFactory GetCurrentSF() {
		return sf;
	}
}
