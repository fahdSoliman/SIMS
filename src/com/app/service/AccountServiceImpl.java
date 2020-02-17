package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAccountDao;

import pojos.Account;

@Service // mandatory --to tell SC about B.L layer
@Transactional // to automate tx management by spring --mandatory
public class AccountServiceImpl implements IAccountService {
	@Autowired //byType
	private IAccountDao dao;
	
	public AccountServiceImpl() {
		System.out.println("in constr of "+getClass().getName());
	}

	@Override
	public Account validateUser(String usr, String pass) {
		System.out.println("service : validate");
		return dao.validateUser(usr, pass);
	}

	@Override
	public Account ResetPass(String newpass,int id) {
		System.out.println("service : resetPass");
		return dao.UpdatePass(newpass,id);
	}

}
