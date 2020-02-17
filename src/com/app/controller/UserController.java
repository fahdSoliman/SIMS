package com.app.controller;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.IAccountService;

import pojos.Account;

@Controller // mandatory
@RequestMapping("/user") // optional
public class UserController {
	
	// dependency
	@Autowired // byType
	private IAccountService service;
	public Account a;

	public UserController() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	// request handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	// req handling method to process login form
	@PostMapping("/login")
	public String processLoginForm(HttpSession hs,@RequestParam String UserLogin, @RequestParam String Password, Model map) {
		System.out.println("in process login form " + UserLogin + " " + Password);
		try {
			a = service.validateUser(UserLogin, Password);
			map.addAttribute("status", "Successful Login");
			map.addAttribute("account_dtls", a);
			hs.setAttribute("account_dtls", a);
			hs.setAttribute("account_type", a.getType().toString());
			switch(a.getType().toString()) {
			case "ADMIN":
				return "/admin/details";
			case "STUDENT":
				return "/student/details";
			case"COORDINATOR":
				return "/coordinator/details";
			case"FACULTY":
				return"/faculty/details";
			case"REGISTRATION":
				return"/registration/details";
			default:
				return"/student/details";
			}
		} catch (NoResultException e) {
			System.out.println("invalid login " + e);
			map.addAttribute("status", "Invalid Login , Pls retry");
			return "/user/login";
		}

	}
	// req handling method to forward tie clnt to view layer details page
	@GetMapping("/details")
	public String forwardToView() {
		System.out.println("in forward to view");
		if(a == null) {
			return"./";
		}else {
			return "/user/details";

		}
	}
	// req handling method for logout
	@GetMapping("/logout")
	public String logMeOut(HttpSession hs, HttpServletRequest req, HttpServletResponse resp, Model map) {
		System.out.println("in logout");
		// get user dtls from session scope & xfer them to model map
		map.addAttribute("account_dtls", hs.getAttribute("account_dtls"));
		// invalidate HS
		hs.invalidate();
		// set refresh header
		resp.setHeader("refresh", "5;url=" + req.getContextPath());
		a = null;
		return "/user/logout";
	}
	@GetMapping("/resetpass")
	public String forwardToView2() {
		System.out.println("in forward to view");
		return "/user/resetpass";
	}
	@PostMapping("/resetpass")
	public String ResetPass(@RequestParam String newPass, Model map) {
		try {
			a = service.ResetPass(newPass,a.getAccountID());
			map.addAttribute("status", "Reset Successful");
			map.addAttribute("account_dtls", a);
			return "/user/logout";
		} catch (NoResultException e) {
			System.out.println("invalid login " + e);
			map.addAttribute("status", "Invalid Login , Pls retry");
			return "/user/resetpass";
		}
	}
	@GetMapping("/notfound")
	public String forwardToNotFound() {
		return "/user/notfound";
	}
	public Account GetCurrentAccount() {
		return a;
		
	}
}
