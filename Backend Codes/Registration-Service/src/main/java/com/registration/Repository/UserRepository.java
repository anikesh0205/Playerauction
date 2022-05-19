package com.registration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
