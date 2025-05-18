package com.user.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,String>{
	
	//if you want to implement any custom method or query here you can write

}
