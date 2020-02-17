package com.app.service;

import java.util.List;

import pojos.Account;
import pojos.Student;
import pojos.Type;
import pojos.VMessages;

public interface ICoordinatorService {
	
	List<Student> ViewRegistration();
	List<VMessages> AnswerQuestion();
	void SetSchedule();
	void SetExamTime();
	String DeleteQuestion(int id);
	VMessages GetMessage(int id);
	List<Account> GetRegistrations(Type type);
	Account GetAccount(int theId);
	void ConfirmRegistration(int theId);
	
}
