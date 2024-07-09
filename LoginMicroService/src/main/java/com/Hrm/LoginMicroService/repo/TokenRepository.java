package com.Hrm.LoginMicroService.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hrm.LoginMicroService.Entity.TokenEntity;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
	TokenEntity findByUsername(String name);
}
