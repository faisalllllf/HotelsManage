package com.Hrm.LoginMicroService.repo;

 
import org.springframework.data.jpa.repository.JpaRepository;


import com.Hrm.LoginMicroService.Entity.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
