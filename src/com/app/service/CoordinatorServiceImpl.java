package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CoordinatorDaoImpl;

import pojos.Account;
import pojos.Student;
import pojos.Type;
import pojos.VMessages;

@Service
@Transactional
public class CoordinatorServiceImpl implements ICoordinatorService {

	@Autowired
	private CoordinatorDaoImpl Dao;
	
	public CoordinatorServiceImpl() {
		super();
	}

	
	@Override
	public List<Student> ViewRegistration() {
		return Dao.ViewRegistration();
	}

	@Override
	public List<VMessages> AnswerQuestion() {
		return Dao.AnswerQuestion();
	}


	@Override
	public void SetSchedule() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetExamTime() {
		// TODO Auto-generated method stub

	}


	@Override
	public String DeleteQuestion(int id) {
		return Dao.DeleteQuestion(id);
	}


	@Override
	public VMessages GetMessage(int id) {
		
		return Dao.GetMessage(id);
	}


	@Override
	public List<Account> GetRegistrations(Type type) {
		return Dao.GetRegistrations(type);
	}


	@Override
	public Account GetAccount(int theId) {
		
		return Dao.GetAccount(theId);
	}


	@Override
	public void ConfirmRegistration(int theId) {
		Dao.ConfirmRegistration(theId);
	}

}
