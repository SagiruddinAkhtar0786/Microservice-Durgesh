package com.user.service.Service;

import java.util.List;

import com.user.service.Entity.UserEntity;

public interface UserService {
	//user operation
	
	// create
	UserEntity saveUser(UserEntity user);
	
	//getAllUser
	List<UserEntity> getAllUsers();
	
	//get single user by given ID
	
	UserEntity getUser(String userID);
	
	//delete
	
	void deleteUser(String userID);
	//update
	
	UserEntity updateUser(UserEntity user);
}
