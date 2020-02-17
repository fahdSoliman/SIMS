package com.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDaoImpl;

import pojos.*;

@Service // mandatory --to tell SC about B.L layer
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private AdminDaoImpl Dao;
	
	public AdminServiceImpl() {
		
	}
	@Override
	public Account CreateUser(String FullName, String MobileNo, String Address, 
			String Email, String UserLogin, String UserPass,Type Type) {
		return Dao.CreateUser(FullName, MobileNo, Address, Email, UserLogin, UserPass,Type);
	}
	@Override
	public List<Account> listUser(String type) {
		// TODO Auto-generated method stub
		return Dao.listAcc(type);
	}
	@Override
	public String DeleteAcc(int uid) {
		Account Acc = Dao.GetAccDetails(uid);
		return Dao.DeleteAccDetails(Acc);
	}
	@Override
	public Account GetAccDetails(int UID) {
		return Dao.GetAccDetails(UID); 
	}
	@Override
	public String CreateIns(Institute ins) {
		return Dao.CreateIns(ins);
	}
	@Override
	public String AddRoom(Room rooms,Institute ins) {
		return Dao.AddRooms(rooms, ins); 
	}
	@Override
	public Institute GetInsDetails() {
		return Dao.GetInsDetials(); 
	}
	@Override
	public boolean CheckIns() {
		return Dao.CheckIns();
	}
	@Override
	public List<Room> GetRooms() {
		
		return Dao.GetRooms(); 
	}
	@Override
	public Institute GetCompleteInsDetials() {
		return Dao.GetCompleteInsDetials();
	}
	@Override
	public String AddDiploma(Diploma dip, Institute ins) {
		// TODO Auto-generated method stub
		return Dao.AddDiploma(dip, ins); 
	}
	@Override
	public Diploma GetDiplomaByID(int id) {
		// TODO Auto-generated method stub
		return Dao.GetDiplomaByID(id);
	}
	@Override
	public Institute GetCompleteDipDetials() {
		return Dao.GetCompleteDipDetials();
	}
}
