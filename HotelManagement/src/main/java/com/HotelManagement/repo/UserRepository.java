package com.HotelManagement.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.HotelManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
