package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IVisitorService;

import pojos.VMessages;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
	
	@Autowired
	private IVisitorService visitor;
	
	@GetMapping("/showform")
	public String showMessagePage(Model model) {
		VMessages theMessage=new VMessages();
		model.addAttribute("message",theMessage);
		return "/user/messageform";
	}
	
	@PostMapping("/sendMessage")
	public String sendMessage(@ModelAttribute("message") VMessages theMessage) {
		visitor. sendMessage(theMessage);
		return "/user/visitorconfirmation";
	}

}
