package com.user.service.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.Entity.UserEntity;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.Repository.UserRepository;
import com.user.service.Service.UserService;


@Service
public class UserServiceImplemetation implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity getUser(String userID) {
		// TODO Auto-generated method stub
	/*	return userRepository.findById(userID).orElseThrow(()->{
			 return new ResourceNotFoundException("resource with given id is not found on server !!"+userID);
		});*/
		
		return userRepository.findById(userID)
		        .orElseThrow(() -> new ResourceNotFoundException("Resource with given ID not found on server: " + userID));
	}

	@Override
	public void deleteUser(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
