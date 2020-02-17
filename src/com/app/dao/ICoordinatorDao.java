package com.app.dao;

import java.util.List;

import pojos.Account;
import pojos.Student;
import pojos.Type;
import pojos.VMessages;

public interface ICoordinatorDao {

	List<Student> ViewRegistration();
	List<VMessages> AnswerQuestion();
	void SetSchedule();
	void SetExamTime();
	public String DeleteQuestion(int id);
	public VMessages GetMessage(int id);
	List<Account> GetRegistrations(Type type);
	Account GetAccount(int theid);
	public void ConfirmRegistration(int theId) ;
}
