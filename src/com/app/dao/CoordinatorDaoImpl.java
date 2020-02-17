package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.Account;
import pojos.Student;
import pojos.Type;
import pojos.VMessages;

@Repository
public class CoordinatorDaoImpl implements ICoordinatorDao {

	@Autowired
	public SessionFactory sf;
	
	public CoordinatorDaoImpl() {
		
	}
	
	@Override
	public List<Student> ViewRegistration() {
		return null;
	}

	@Override
	public List<VMessages> AnswerQuestion() {
		String hql="FROM VMessages";
		return  sf.getCurrentSession().createQuery(hql,VMessages.class).getResultList();
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
		String hql = "DELETE FROM VMessages "  + 
	             "WHERE MessageID = :message_id";
		sf.getCurrentSession().createQuery(hql,VMessages.class).setParameter("message_id",id);
		return "Message deleted successfully!!!";
	}

	@Override
	public VMessages GetMessage(int id) {
		return sf.getCurrentSession().get(VMessages.class, id);
	}

	@Override
	public List<Account> GetRegistrations(Type type) {
		String hql = "DELETE FROM account "  + 
	             "WHERE type = :type1";
		return sf.getCurrentSession().createQuery(hql,Account.class).setParameter("type1",type).getResultList();
	}

	@Override
	public Account GetAccount(int theId) {
		
		return sf.getCurrentSession().get(Account.class,theId);
	}
 
	@Override
	public void ConfirmRegistration(int theId) {
		Type type=Type.valueOf("STUDENT");
		String hql = "UPDATE account set  type=type1 WHERE accountID = :account_id";
		sf.getCurrentSession().createQuery(hql,Account.class).setParameter("type1",type).setParameter("accountID",theId).executeUpdate();
	}

}
