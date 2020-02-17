package com.app.dao;

import org.hibernate.SessionFactory;

import pojos.Account;

public interface IAccountDao {
	Account validateUser(String usr, String pass);
	Account UpdatePass(String newpass,int id);
	Account getAccountDetails(int id);
	SessionFactory GetCurrentSF();
}
