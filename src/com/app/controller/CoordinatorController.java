package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.ICoordinatorService;

import pojos.Type;
import pojos.VMessages;

@Controller
@RequestMapping("/coodinator")
public class CoordinatorController {
		
		@Autowired
		private ICoordinatorService service;
		
		public  CoordinatorController() {
			System.out.println("in coordinator controller");
		}
		
		@GetMapping("/messagelist")
		public String ViewMessages(HttpSession hs,Model model) {
			if(hs.getAttribute("account_type").toString() != "COORDINATOR") 
				return "redirect:/user/notfound";
			else {
				List<VMessages> messagelist=service.AnswerQuestion();
				model.addAttribute("list",messagelist);
				return "/coordinator/viewmessages";
			}
		}
		
		@GetMapping("/deletemessage")
		public String DeleteMessage(HttpSession hs,@RequestParam int theID,RedirectAttributes flashMap) {
			if(hs.getAttribute("account_type").toString() != "COORDINATOR") 
			{
				return "redirect:/user/notfound";
			}
			else {
						try {
								flashMap.addFlashAttribute("status",service.DeleteQuestion(theID));
								} catch (DataAccessException e) {
											flashMap.addFlashAttribute("status", "account deletion failed " + e.getMessage());
								}
									return "redirect:/coordinator/viewmessage";
			}
		}
		
		@GetMapping("/showmessage")
		public String ShowMessage(HttpSession hs,@RequestParam int theID,Model model) {
			if(hs.getAttribute("account_type").toString() != "COORDINATOR") 
			{
				return "redirect:/user/notfound";
			}
			else {
						model.addAttribute("theMessage",service.GetMessage(theID));
						return "/coordinator/showmessage";
			}
		}
		
		@GetMapping("/registrationlist")
		public String ShowRegistration(HttpSession hs,Model model) {
		if(hs.getAttribute("account_type").toString() != "COORDINATOR")
		{
			return "redirect:/user/notfound";
		}
		else {
			model.addAttribute("registered",service.GetRegistrations(Type.valueOf("REGISTRATIONS")));
			return "registrationlist";
		}
		}
		
		@GetMapping("/showdetails")
		public String ShowRegistrationDetails(HttpSession hs,@RequestParam int theId,Model model)
		{
			if(hs.getAttribute("account_type").toString() != "COORDINATOR") {
				return "redirect:/user/notfound";
			}
			else {
				model.addAttribute("theAccount",service.GetAccount(theId));
				return "/coordinator/accountdetails";
			}
		}
		@GetMapping("/confirm")
		public String ConfirmRegistration(HttpSession hs,@RequestParam int theId,Model model) {
			if(hs.getAttribute("account_type").toString() != "COORDINATOR") {
				return "redirect:/user/notfound";
			}
			else {
				service.ConfirmRegistration(theId);
				return "/coordinator/confirmmessage";
			}
		}
		
		
		
}
