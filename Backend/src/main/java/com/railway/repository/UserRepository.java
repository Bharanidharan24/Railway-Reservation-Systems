package com.railway.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railway.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	
	
}

