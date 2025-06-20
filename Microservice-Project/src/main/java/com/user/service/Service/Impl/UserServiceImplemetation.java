package com.user.service.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.Entity.Rating;
import com.user.service.Entity.UserEntity;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.Repository.UserRepository;
import com.user.service.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImplemetation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	private Logger logger = LoggerFactory.getLogger(UserServiceImplemetation.class);
	

	@Override
	public UserEntity saveUser(UserEntity user) {
		
		//generate unique Id
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	// get single user
	@Override
	public UserEntity getUser(String userID) {
		// TODO Auto-generated method stub 
	/*	return userRepository.findById(userID).orElseThrow(()->{
			 return new ResourceNotFoundException("resource with given id is not found on server !!"+userID);
		});*/
		
		UserEntity user = userRepository.findById(userID)
		        .orElseThrow(
		        () -> new ResourceNotFoundException("Resource with given ID not found on server: " + userID));
		// fetch rating of the above user from rating service
		//		ArrayList<Rating> ratingsOfuser = restTemplate.getForObject("http://localhost:8083/ratings/users/0aa036a7-2aa4-4641-b4bd-b3763e82c1ed", ArrayList.class);

		ArrayList<Rating> ratingsOfuser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		//logger.info("information ",forObject);
		System.out.println("forObject >> "+ratingsOfuser);
		
		user.setRatings(ratingsOfuser);
		return user;
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
