package com.user.service.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.Entity.UserEntity;
import com.user.service.Service.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	//create user
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
		UserEntity user1 =  userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	int retryCount= 1;
	//single user get
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker" , fallbackMethod="ratingHotelFallbackMethod")
	//@Retry(name="RatingHotelService" ,fallbackMethod="ratingHotelFallbackMethod")
	@RateLimiter(name="userRateLimiter" , fallbackMethod="ratingHotelFallbackMethod")
	public ResponseEntity<UserEntity> getSingleUser(@PathVariable String userId){
		logger.info("get single user handler >. ");
		logger.info("Retry Count :{} "+retryCount);
		retryCount++;
		UserEntity user = userService.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
	// creating fall back method for circuit breaker
	public ResponseEntity<UserEntity> ratingHotelFallbackMethod(String userId, Exception ex){
		logger.info("fall back id executed..."+ex.getMessage());
		UserEntity user=	UserEntity.builder()
					.email("srakhtar1997@gmail.com")
					.name("sagiruddin Akhtar")
					.about("This user is created dummy because some user id down")
					.userId("12345").build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
		
	
	//all user get
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser(){
		List<UserEntity> allUser = userService.getAllUsers();
		return ResponseEntity.ok(allUser);
	}
	

}
