package com.HotelManagement.repo;

 
import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
