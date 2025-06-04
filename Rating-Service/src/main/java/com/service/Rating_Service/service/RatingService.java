package com.service.Rating_Service.service;

import java.util.List;

import com.service.Rating_Service.Entities.Rating;

//@Serivce
public interface RatingService {
	//create
	Rating create(Rating rating);
	
	//get All ratings
	List<Rating> getRatings();
	
	//getAll by UserId
	List<Rating> getRatingByUserId(String userID);
	
	//getAll by Hotel
	List<Rating> getRatingByHotelId(String hotelID);
}
