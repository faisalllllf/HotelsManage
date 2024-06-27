<<<<<<< HEAD
<<<<<<< HEAD
package com.HotelManagement.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequestForm;
import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.service.UserService;
import com.HotelManagement.service.sendmessageJms;

@Controller
public class AdminController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private UserService userService;

	@Autowired
	private sendmessageJms sendmessagejms;

	@GetMapping("/admin/home")
	public String adminHome(Model model, Authentication authentication) {
		String userName = authentication.getName();

		System.out.println("Inside Admin Controller");
		model.addAttribute("userName", userName);
		model.addAttribute("role", "ADMIN");
		return "Admin_dashboard";
	}

	@GetMapping("/admin/getAllUsers")
	public String getAllUsers(Model model) {

		List<UserDto> users = userService.findAllUsers();
		System.out.println("users" + users);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/admin/createUser")
	public String showCreateUserForm(Model model) {
		UsersAd user = new UsersAd();
		List<Role> roles = userService.findAllRoles();
		System.out.println("roles" + roles);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "createUser";
	}

	// handler method to handle register user form submit request
	@PostMapping("/admin/createUser/save")
	public String saveCreateUSer(@ModelAttribute("user") UsersAd user, BindingResult result, Model model) {
		// User existing = userService.findByEmail(user.getEmail());
		System.out.println("userCreate" + user.toString());
		List<Role> roles = userService.findAllRoles();
		model.addAttribute("roles", roles);
		System.out.println("roles" + roles);
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			System.out.println("already existing");
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			System.out.println("having errors ");
			model.addAttribute("user", user);
			return "createUser";
		}
		System.out.println("saving to  database");
		userService.saveCreateUser(user);
		return "redirect:/admin/createUser?success";
	}

	@GetMapping("/departments/home")
	public String showCreateUserJForm(Model model, Authentication authentication) {
		System.out.println("inside admin COntroller for departments ");
		String userName = authentication.getName();
		List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		String role = "";
		for (String r : roles) {
			System.out.println("rolein admin controller" + r);
			role = r;
		}
		if (role != null || role != "") {
			model.addAttribute("role", role);
			model.addAttribute("userName", userName);
		}

		System.out.println("ROle");

		return "Admin_dashboard";
	}

	@GetMapping("/AddRooms/{Role}")
	public String AddRooms(Model model, @PathVariable String Role, Principal principal) {

		System.out.println("Inside Admin Add Rooms Controller");
		model.addAttribute("role", Role);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("roomRequest", new RoomRequestForm());
		return "AddRooms";
	}

	@PostMapping("/upload")
	public String handleImageUpload(@RequestParam("roomNo") int roomNo, @RequestParam("roomType") String roomType,
			@RequestParam("guestNo") int guestNo, @RequestParam("picByte") MultipartFile picByte,
			@RequestParam("price") int price, @RequestParam("roomDesc") String roomDesc

	) {
		try {
			// Create ImageDetails bean
			RoomRequestForm roomRequestForm = new RoomRequestForm();
			roomRequestForm.setGuestNo(guestNo);;
			roomRequestForm.setPicByte(picByte);
			roomRequestForm.setPrice(price);
			roomRequestForm.setRoomDesc(roomDesc);
			roomRequestForm.setRoomNo(roomNo);
			roomRequestForm.setRoomType(roomType);

			

			
			
			// Send the image details to JMS
			String response = sendmessagejms.sendmessagetoRoomService("RoomQueue", roomRequestForm);

			System.out.println("response");
			// Return success message
		} catch (Exception e) {
			return "UploadFailed: " + e.getMessage(); // Return error message
		}
		return "Admin_dashboard";
	}
}
=======
package com.HotelManagement.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequestForm;
import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.service.UserService;
import com.HotelManagement.service.sendmessageJms;

@Controller
public class AdminController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private UserService userService;

	@Autowired
	private sendmessageJms sendmessagejms;

	@GetMapping("/admin/home")
	public String adminHome(Model model, Authentication authentication) {
		String userName = authentication.getName();

		System.out.println("Inside Admin Controller");
		model.addAttribute("userName", userName);
		model.addAttribute("role", "ADMIN");
		return "Admin_dashboard";
	}

	@GetMapping("/admin/getAllUsers")
	public String getAllUsers(Model model) {

		List<UserDto> users = userService.findAllUsers();
		System.out.println("users" + users);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/admin/createUser")
	public String showCreateUserForm(Model model) {
		UsersAd user = new UsersAd();
		List<Role> roles = userService.findAllRoles();
		System.out.println("roles" + roles);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "createUser";
	}

	// handler method to handle register user form submit request
	@PostMapping("/admin/createUser/save")
	public String saveCreateUSer(@ModelAttribute("user") UsersAd user, BindingResult result, Model model) {
		// User existing = userService.findByEmail(user.getEmail());
		System.out.println("userCreate" + user.toString());
		List<Role> roles = userService.findAllRoles();
		model.addAttribute("roles", roles);
		System.out.println("roles" + roles);
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			System.out.println("already existing");
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			System.out.println("having errors ");
			model.addAttribute("user", user);
			return "createUser";
		}
		System.out.println("saving to  database");
		userService.saveCreateUser(user);
		return "redirect:/admin/createUser?success";
	}

	@GetMapping("/departments/home")
	public String showCreateUserJForm(Model model, Authentication authentication) {
		System.out.println("inside admin COntroller for departments ");
		String userName = authentication.getName();
		List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		String role = "";
		for (String r : roles) {
			System.out.println("rolein admin controller" + r);
			role = r;
		}
		if (role != null || role != "") {
			model.addAttribute("role", role);
			model.addAttribute("userName", userName);
		}

		System.out.println("ROle");

		return "Admin_dashboard";
	}

	@GetMapping("/AddRooms/{Role}")
	public String AddRooms(Model model, @PathVariable String Role, Principal principal) {

		System.out.println("Inside Admin Add Rooms Controller");
		model.addAttribute("role", Role);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("roomRequest", new RoomRequestForm());
		return "AddRooms";
	}

	@PostMapping("/upload")
	public String handleImageUpload(@RequestParam("roomNo") int roomNo, @RequestParam("roomType") String roomType,
			@RequestParam("guestNo") int guestNo, @RequestParam("picByte") MultipartFile picByte,
			@RequestParam("price") int price, @RequestParam("roomDesc") String roomDesc

	) {
		try {
			// Create ImageDetails bean
			RoomRequestForm roomRequestForm = new RoomRequestForm();
			roomRequestForm.setGuestNo(guestNo);;
			roomRequestForm.setPicByte(picByte);
			roomRequestForm.setPrice(price);
			roomRequestForm.setRoomDesc(roomDesc);
			roomRequestForm.setRoomNo(roomNo);
			roomRequestForm.setRoomType(roomType);

			

			
			
			// Send the image details to JMS
			String response = sendmessagejms.sendmessagetoRoomService("RoomQueue", roomRequestForm);

			System.out.println("response");
			// Return success message
		} catch (Exception e) {
			return "UploadFailed: " + e.getMessage(); // Return error message
		}
		return "Admin_dashboard";
	}
}
>>>>>>> 26f4154 (lll)
=======
package com.HotelManagement.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequestForm;
import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.service.UserService;
import com.HotelManagement.service.sendmessageJms;

@Controller
public class AdminController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private UserService userService;

	@Autowired
	private sendmessageJms sendmessagejms;

	@GetMapping("/admin/home")
	public String adminHome(Model model, Authentication authentication) {
		String userName = authentication.getName();

		System.out.println("Inside Admin Controller");
		model.addAttribute("userName", userName);
		model.addAttribute("role", "ADMIN");
		return "Admin_dashboard";
	}

	@GetMapping("/admin/getAllUsers")
	public String getAllUsers(Model model) {

		List<UserDto> users = userService.findAllUsers();
		System.out.println("users" + users);
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("/admin/createUser")
	public String showCreateUserForm(Model model) {
		UsersAd user = new UsersAd();
		List<Role> roles = userService.findAllRoles();
		System.out.println("roles" + roles);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		return "createUser";
	}

	// handler method to handle register user form submit request
	@PostMapping("/admin/createUser/save")
	public String saveCreateUSer(@ModelAttribute("user") UsersAd user, BindingResult result, Model model) {
		// User existing = userService.findByEmail(user.getEmail());
		System.out.println("userCreate" + user.toString());
		List<Role> roles = userService.findAllRoles();
		model.addAttribute("roles", roles);
		System.out.println("roles" + roles);
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			System.out.println("already existing");
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			System.out.println("having errors ");
			model.addAttribute("user", user);
			return "createUser";
		}
		System.out.println("saving to  database");
		userService.saveCreateUser(user);
		return "redirect:/admin/createUser?success";
	}

	@GetMapping("/departments/home")
	public String showCreateUserJForm(Model model, Authentication authentication) {
		System.out.println("inside admin COntroller for departments ");
		String userName = authentication.getName();
		List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		String role = "";
		for (String r : roles) {
			System.out.println("rolein admin controller" + r);
			role = r;
		}
		if (role != null || role != "") {
			model.addAttribute("role", role);
			model.addAttribute("userName", userName);
		}

		System.out.println("ROle");

		return "Admin_dashboard";
	}

	@GetMapping("/AddRooms/{Role}")
	public String AddRooms(Model model, @PathVariable String Role, Principal principal) {

		System.out.println("Inside Admin Add Rooms Controller");
		model.addAttribute("role", Role);
		model.addAttribute("userName", principal.getName());
		model.addAttribute("roomRequest", new RoomRequestForm());
		return "AddRooms";
	}

	@PostMapping("/upload")
	public String handleImageUpload(@RequestParam("roomNo") int roomNo, @RequestParam("roomType") String roomType,
			@RequestParam("guestNo") int guestNo, @RequestParam("picByte") MultipartFile picByte,
			@RequestParam("price") int price, @RequestParam("roomDesc") String roomDesc

	) {
		try {
			// Create ImageDetails bean
			RoomRequestForm roomRequestForm = new RoomRequestForm();
			roomRequestForm.setGuestNo(guestNo);;
			roomRequestForm.setPicByte(picByte);
			roomRequestForm.setPrice(price);
			roomRequestForm.setRoomDesc(roomDesc);
			roomRequestForm.setRoomNo(roomNo);
			roomRequestForm.setRoomType(roomType);

			

			
			
			// Send the image details to JMS
			String response = sendmessagejms.sendmessagetoRoomService("RoomQueue", roomRequestForm);

			System.out.println("response");
			// Return success message
		} catch (Exception e) {
			return "UploadFailed: " + e.getMessage(); // Return error message
		}
		return "Admin_dashboard";
	}
}
<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
