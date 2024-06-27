package com.HotelManagement.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.security.CustomUserDetailsService;
import com.HotelManagement.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	


	@GetMapping("/user/home")
	public String userHome(Authentication authentication,Principal principal,Model model,HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		session.setAttribute("userName", principal.getName());
	
		System.out.println("name from auth"+auth.getName());
		System.out.println("principla get anme from princiapl"+principal.getName());
	model.addAttribute("userName", auth.getName());
		
		return "userHome";
	}
	

	@GetMapping("user/SearchRoom")
	public String searchHotel(HttpSession session) {
		
		String userName=(String) session.getAttribute("userName");
	
		
		System.out.println("userName from seesion in searchRoom Api"+userName);
	
		
		return "userHome";
	}
	
	

}