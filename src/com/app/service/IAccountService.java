package com.app.service;

import pojos.Account;

public interface IAccountService {
	Account validateUser(String usr, String pass);
	Account ResetPass(String newpass,int id);
}
