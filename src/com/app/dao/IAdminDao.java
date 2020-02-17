package com.app.dao;


import java.util.List;

import pojos.*;

public interface IAdminDao {
	Account CreateUser(String FullName, String MobileNo, String Address, String Email,
			String UserLogin, String UserPass,Type Type);
	List<Account> listAcc(String type);
	String DeleteAccDetails(Account DelAcc);
	Account GetAccDetails(int UID);
	String CreateIns(Institute ins);
	Institute GetInsDetials();
	Institute GetCompleteInsDetials();
	boolean CheckIns();
	String AddRooms(Room rooms,Institute ins);
	List<Room> GetRooms();
	String AddDiploma(Diploma dip,Institute ins);
	Institute GetCompleteDipDetials();
	Diploma GetDiplomaByID(int id);
}
