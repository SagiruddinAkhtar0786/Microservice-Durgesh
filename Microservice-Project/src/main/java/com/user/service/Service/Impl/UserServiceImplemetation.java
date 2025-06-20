package com.user.service.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.Entity.Hotel;
import com.user.service.Entity.Rating;
import com.user.service.Entity.UserEntity;
import com.user.service.Exception.ResourceNotFoundException;
import com.user.service.Repository.UserRepository;
import com.user.service.Service.UserService;
import com.user.service.external.Services.HotelService;

@Service
public class UserServiceImplemetation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImplemetation.class);
	

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

	Rating [] ratingsOfuser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("information ",ratingsOfuser.toString());
		System.out.println("forObject >> "+ratingsOfuser.toString());
		System.out.println("sagir");
		
		List<Rating> ratings = Arrays.stream(ratingsOfuser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			//localhost:8082/hotels/2b3536db-d648-4988-9664-4b7aa6543df4
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		//	Hotel hotel = forEntity.getBody();
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
		//	logger.info("responseStatus code {} ",forEntity.getStatusCode());
			
			//set the hotel to rating;
			rating.setHotel(hotel);
			
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
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
