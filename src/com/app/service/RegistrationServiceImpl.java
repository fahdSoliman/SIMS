package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RegistrationDaoImpl;

import pojos.Account;
@Service
@Transactional
public class RegistrationServiceImpl implements IRegistrationService {

	RegistrationDaoImpl dao;
	@Override
	public void registerNewUser(Account account) {
		dao.registerNewUser(account);
	}

}
