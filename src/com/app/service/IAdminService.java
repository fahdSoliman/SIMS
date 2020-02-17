package com.app.service;


import java.util.List;

import pojos.*;

public interface IAdminService {
	Account CreateUser(String FullName, String MobileNo, String Address, 
			String Email, String UserLogin, String UserPass,Type Type);
	List<Account> listUser(String type);
	String DeleteAcc(int uid);
	Account GetAccDetails(int UID);
	String CreateIns(Institute ins);
	String AddRoom(Room rooms,Institute ins);
	Institute GetInsDetails();
	Institute GetCompleteInsDetials();
	boolean CheckIns();
	List<Room> GetRooms();
	String AddDiploma(Diploma dip,Institute ins);
	Institute GetCompleteDipDetials();
	Diploma GetDiplomaByID(int id);

}
