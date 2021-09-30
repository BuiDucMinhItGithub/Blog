package com.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.service.AdminService;


@Controller

public class LoginController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {
		if (error != null) {
			model.addAttribute("message", "Đăng nhập thất bại!");
		}
		return "admin/admin/login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		return "redirect:/logoutSuccessful";
	}
	
	
	@RequestMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request,@RequestParam(name = "name") String name,
			@RequestParam(name = "password") String password) {
		if(adminService.login(name,password) != null) {
			request.setAttribute("name", name);
			return "redirect:/admin/view";
		}else {
			return "redirect:/403";
		}
	}

	
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	   public String logoutSuccessfulPage(HttpServletRequest request,Model model) {
	       model.addAttribute("title", "Logout");
	       
	       return "redirect:/login";
	   }
}
