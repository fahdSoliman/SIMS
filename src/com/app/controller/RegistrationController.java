package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IRegistrationService;

import pojos.Account;
import pojos.Type;


@Controller // mandatory
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private IRegistrationService service;
	public RegistrationController() {
		System.out.println("in cnstr of " + getClass().getName());
	}
	
	// request handling method to show login form
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		System.out.println("in show register form");
		Account account=new Account();
		account.setType(Type.valueOf("REGISTRATION"));
		model.addAttribute("account",account);
		return "/registration/register";
	}
	
	@PostMapping("/getregistered")
	public String getRegistered(@ModelAttribute("account") Account theAccount) {
		service.registerNewUser(theAccount);
		return "registration/confirmation";
	}
}
