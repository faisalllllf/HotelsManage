package com.Hrm.LoginMicroService.repo;

import com.Hrm.LoginMicroService.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {

	Employee findByUsername(String username);
	
	Employee findByRestToken(String token);

}
