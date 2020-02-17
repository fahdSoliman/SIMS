package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VisitorDaoImpl;

import pojos.VMessages;

@Service
@Transactional
public class VisitorServiceImpl implements IVisitorService {

	private VisitorDaoImpl Dao;
	
	@Override
	public void sendMessage(VMessages message) {
		Dao.sendMessage(message);
	}

}
