package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.IAdminService;

import pojos.Account;
import pojos.Diploma;
import pojos.Institute;
import pojos.Room;
import pojos.Type;

@Controller // mandatory
@RequestMapping("/admin")
public class AdminController {
	   
	@Autowired
	private IAdminService AdminService;
	
	public AdminController() {
		
	}
	
	
	@GetMapping("/viewdiploma")
	public String ViewDiploma(HttpSession hs,Model map,@RequestParam int id
			) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
			map.addAttribute(AdminService.GetDiplomaByID(id));
			return "/admin/viewdiploma";
	}
	@PostMapping("/viewdiploma")
	public String ProcessViewDiploma(HttpSession hs,RedirectAttributes flashMap,
			Diploma dip) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
		{
			Institute ins = (Institute) hs.getAttribute("Institute");
			flashMap.addFlashAttribute("status", AdminService.AddDiploma(dip, ins));
			return "redirect:/admin/custins";
		}
	}
	
	@GetMapping("/diploma")
	public String viewAddDiploma(HttpSession hs,Diploma dip) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
			return "/admin/diploma";
	}
	
	@PostMapping("/diploma")
	public String processAddDiploma(HttpSession hs,Diploma dip
			,RedirectAttributes flashMap) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
		{
			Institute ins = AdminService.GetCompleteDipDetials();
			flashMap.addFlashAttribute("diploma", AdminService.AddDiploma(dip, ins));
			return "redirect:/admin/custins";
		}
	}
	
	@GetMapping("/addroom")
	public String CreateRoom(HttpSession hs,Room r) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
			
			return "/admin/addroom";
	}
	@PostMapping("/addroom")
	public String processCreateRoom(HttpSession hs,Room r,
			RedirectAttributes flashMap,Model map) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else {
			Institute ins = (Institute) hs.getAttribute("Institute");
			flashMap.addFlashAttribute("room", AdminService.AddRoom(r, ins));
			return "redirect:/admin/custins";
		}
	}
	
	@GetMapping("/addins")
	public String AddIns(HttpSession hs,Institute ins) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
			return "/admin/addins";
	}
	@PostMapping("/addins")
	public String AddInsProc(HttpSession hs,@Valid Institute ins, 
			BindingResult res,Model map, RedirectAttributes flashMap) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else {
			if(res.hasErrors())
			{
				System.out.println("p.l validation failed....forwarding");
				return "/admin/addins";
			}
			try {
				flashMap.addFlashAttribute("status", AdminService.CreateIns(ins)); 
				return "redirect:/admin/details";
			} catch (RuntimeException e) {
				System.out.println("reg err " + e);
				map.addAttribute("status", "Adding institute faild pls retry");
				return "/admin/addins";
			}
		}
	}
	@GetMapping("/custins")
	public String ViewCustomizeInstitute(HttpSession hs,
			Model map,RedirectAttributes flashMap) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else {
			if(AdminService.CheckIns())
			{
				return "/admin/addins";
			}else 
			{
				Institute ins = AdminService.GetCompleteInsDetials();
				Institute dip = AdminService.GetCompleteDipDetials();
				map.addAttribute("status", "retriving Data Sucess");
				map.addAttribute(ins);
				hs.setAttribute("Institute", ins);
				hs.setAttribute("Diploma", dip);
				return "/admin/custins";
			}
		}
	}
	
	@PostMapping("/custins")
	public String CustomizeInstitute(HttpSession hs,@Valid Institute ins
			,BindingResult res,RedirectAttributes flashMap,Model map ) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") 
		{
			return "redirect:/user/notfound";
		}else 
		{
			map.addAttribute("status", AdminService.CreateIns(ins));
			return "/admin/details";
		}
	}
	@GetMapping("/details")
	public String ViewDetails(HttpSession hs) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
			return "/admin/details";
	}
	@GetMapping("/list")
	public String showUserList(Model map ,@RequestParam String Type) {
		System.out.println("in Accounts list");
		map.addAttribute("user_list", AdminService.listUser(Type));
		return "/admin/userlist";
	}
	@GetMapping("/newuser")
	public String ViewNewUser(HttpSession hs) {
		if(hs.getAttribute("account_type").toString() != "ADMIN") {
			return "redirect:/user/notfound";
		}else
		return "/admin/newuser";
	}
	@PostMapping("/newuser")
	public String ProcessNewAccount(HttpSession hs,@RequestParam String FullName, @RequestParam String MobileNo,@RequestParam String Address,
			 @RequestParam String Email, @RequestParam String UserLogin,@RequestParam String UserPass,@RequestParam Type Type,  Model map) {
		try {
			if(hs.getAttribute("account_type").toString() != "ADMIN") {
				return "redirect:/user/notfound";
			}else {
				Account a = AdminService.CreateUser(FullName, MobileNo, Address, Email, UserLogin, UserPass,Type);
				map.addAttribute("status", "added success");
				map.addAttribute("account_dtls", a);
				return "/admin/details";
			}
		} catch(NoResultException e) {
			map.addAttribute("status", "Invalid data , Pls retry");
			return "/admin/details";
		}
	}
	
	// request handling method for deleting  dtls
	@GetMapping("/delete")
	public String deleteAccountDetails(@RequestParam int uid, RedirectAttributes flashMap) {
		System.out.println("in delete Account dtls " + uid);
		try {
			flashMap.addFlashAttribute("status", AdminService.DeleteAcc(uid));
		} catch (DataAccessException e) {
			flashMap.addFlashAttribute("status", "account deletion failed " + e.getMessage());
		}
		return "redirect:/admin/userlist";
	}

	//- request handling method for showing update form
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int vid, Model map, RedirectAttributes flashMap) {
		System.out.println("in show update form " + vid);

		Account acc = AdminService.GetAccDetails(vid);
		if (acc != null) {
			System.out.println("proceeding to update form");
			map.addAttribute(acc);
			return "/vendor/update";
		}
		flashMap.addFlashAttribute("status", "Vendor Updation failed : invalid ID ");
		return "redirect:/admin/list";
	}
}
