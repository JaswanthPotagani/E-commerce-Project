package com.sai.ecom_proj.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.ecom_proj.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

	Optional<Users> findByUsername(String username);
	boolean existsByUsername(String Username);
	
}
