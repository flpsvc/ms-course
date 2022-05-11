package com.springms.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springms.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}