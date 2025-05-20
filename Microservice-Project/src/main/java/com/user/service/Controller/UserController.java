package com.user.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.Entity.UserEntity;
import com.user.service.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	//create user
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
		UserEntity user1 =  userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//single user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getSingleUser(String userId){
		UserEntity user = userService.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
	//all user get
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> allUser = userService.getAllUsers();
		return ResponseEntity.ok(allUser);
	}
	

}
