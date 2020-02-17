package com.app.dao;

import java.time.LocalDate;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojos.*;

@Repository
public class AdminDaoImpl implements IAdminDao {
	@Autowired
	public SessionFactory sf;
	

	public AdminDaoImpl() {
		
	}
	@Override
	public Account CreateUser(String FullName, String MobileNo, String Address, String Email, 
			String UserLogin, String UserPass,Type Type) {
		Account a = new Account();
		a.setFullName(FullName);
		a.setMobileNo(MobileNo);
		a.setAddress(Address);
		a.setEmail(Email);
		a.setUserLogin(UserLogin);
		a.setPassword(UserPass);
		a.setType(Type);
		a.setRegDate(LocalDate.now());
		sf.getCurrentSession().save(a);
		return a;
	}
	@Override
	public List<Account> listAcc(String type) {
		String jpql = "select a from Account a where a.type =:type";
		Type t = Type.valueOf(type);
		return sf.getCurrentSession().createQuery(jpql,Account.class).setParameter("type", t)
				.getResultList();
	}
	@Override
	public String DeleteAccDetails(Account DelAcc) {
		sf.getCurrentSession().delete(DelAcc);
		String mes = "Account Deleted Succesfully";
		return mes;
	}
	@Override
	public Account GetAccDetails(int UID) {
		Account acc = sf.getCurrentSession().get(Account.class, UID);
		return acc;
	}
	@Override
	public String CreateIns(Institute ins) {
		sf.getCurrentSession().saveOrUpdate(ins);
		return "Institute Custimized Success";
	}
	@Override
	public String AddRooms(Room rooms, Institute ins) {
		ins.AddRoom(rooms);
		sf.getCurrentSession().update(ins);
		return "Room Created/Updated Success";
	}
	@Override
	public Institute GetInsDetials() {
		
		String jpql = "from Institute";
		return sf.getCurrentSession().createQuery(jpql,Institute.class)
				.getSingleResult();
	}
	@Override
	public boolean CheckIns() {
		String jpql = "select 1 from Institute";
		boolean b = sf.getCurrentSession().createQuery(jpql).getResultList().isEmpty();
		return b;
	}
	
	@Override
	public List<Room> GetRooms() {
		String jpql = "from Room";
		List<Room> rooms = sf.getCurrentSession().createQuery(jpql,Room.class).getResultList();
		return rooms;
		
	}
	@Override
	public Institute GetCompleteInsDetials() {
		String jpql = "select i from Institute i left outer join fetch i.rooms where i.instituteID =:id";
		return sf.getCurrentSession().createQuery(jpql,Institute.class).setParameter("id", 1)
				.getSingleResult();
	}
	@Override
	public String AddDiploma(Diploma dip, Institute ins) {
		ins.addDiploma(dip);
		sf.getCurrentSession().update(ins); 
		return "Diploma Created/Updated Success";
	}
	@Override
	public Diploma GetDiplomaByID(int id) {
		String jpql = "select d from Diploma d left outer join fetch d.modules where d.diplomaID=:id";
		return sf.getCurrentSession().createQuery(jpql,Diploma.class).getSingleResult();
	}
	@Override
	public Institute GetCompleteDipDetials() {
		String jpql = "select i from Institute i left outer join fetch i.diplomas where i.instituteID =:id";
		return sf.getCurrentSession().createQuery(jpql,Institute.class).setParameter("id", 1)
				.getSingleResult();
	}
	

}
