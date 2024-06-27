<<<<<<< HEAD
<<<<<<< HEAD

package com.HotelManagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.repo.RoleRepository;
import com.HotelManagement.repo.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null) {
			role = checkRoleExist();
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	private UserDto convertEntityToDto(User user) {
		UserDto userDto = new UserDto();
		String[] name = user.getName().split(" ");
		userDto.setFirstName(name[0]);
		userDto.setLastName(name[1]);
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public void saveCreateUser(UsersAd userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName(userDto.getCategory());
		if (role == null) {
			role = checkAdminRoleExist(userDto.getCategory());
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);

	}

	private Role checkAdminRoleExist(String name) {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		try {
			System.out.println("Fetching all roles ");
			roles=roleRepository.findAll();
		} catch (Exception e) {
			System.out.println("exception occured at find All Roles" + e.getMessage());
		}
		return roles;
	}
}
=======

package com.HotelManagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.repo.RoleRepository;
import com.HotelManagement.repo.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null) {
			role = checkRoleExist();
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	private UserDto convertEntityToDto(User user) {
		UserDto userDto = new UserDto();
		String[] name = user.getName().split(" ");
		userDto.setFirstName(name[0]);
		userDto.setLastName(name[1]);
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public void saveCreateUser(UsersAd userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName(userDto.getCategory());
		if (role == null) {
			role = checkAdminRoleExist(userDto.getCategory());
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);

	}

	private Role checkAdminRoleExist(String name) {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		try {
			System.out.println("Fetching all roles ");
			roles=roleRepository.findAll();
		} catch (Exception e) {
			System.out.println("exception occured at find All Roles" + e.getMessage());
		}
		return roles;
	}
}
>>>>>>> 26f4154 (lll)
=======

package com.HotelManagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;
import com.HotelManagement.repo.RoleRepository;
import com.HotelManagement.repo.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null) {
			role = checkRoleExist();
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> convertEntityToDto(user)).collect(Collectors.toList());
	}

	private UserDto convertEntityToDto(User user) {
		UserDto userDto = new UserDto();
		String[] name = user.getName().split(" ");
		userDto.setFirstName(name[0]);
		userDto.setLastName(name[1]);
		userDto.setEmail(user.getEmail());
		return userDto;
	}

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public void saveCreateUser(UsersAd userDto) {
		User user = new User();
		user.setName(userDto.getFirstName() + " " + userDto.getLastName());
		user.setEmail(userDto.getEmail());

		// encrypt the password once we integrate spring security
		// user.setPassword(userDto.getPassword());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName(userDto.getCategory());
		if (role == null) {
			role = checkAdminRoleExist(userDto.getCategory());
		}
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);

	}

	private Role checkAdminRoleExist(String name) {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		try {
			System.out.println("Fetching all roles ");
			roles=roleRepository.findAll();
		} catch (Exception e) {
			System.out.println("exception occured at find All Roles" + e.getMessage());
		}
		return roles;
	}
}
<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
