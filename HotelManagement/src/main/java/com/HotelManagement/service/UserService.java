<<<<<<< HEAD
package com.HotelManagement.service;

import java.util.List;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;

public interface UserService {

	void saveUser(UserDto userDto);

	void saveCreateUser(UsersAd userDto);

	User findByEmail(String email);

	List<Role> findAllRoles();

	List<UserDto> findAllUsers();
}
=======
package com.HotelManagement.service;

import java.util.List;

import com.HotelManagement.dto.UserDto;
import com.HotelManagement.dto.UsersAd;
import com.HotelManagement.entity.Role;
import com.HotelManagement.entity.User;

public interface UserService {

	void saveUser(UserDto userDto);

	void saveCreateUser(UsersAd userDto);

	User findByEmail(String email);

	List<Role> findAllRoles();

	List<UserDto> findAllUsers();
}
>>>>>>> 8e11644 (First Commit)
