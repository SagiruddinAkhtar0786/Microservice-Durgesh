package com.service.Rating_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.Rating_Service.Entities.Rating;
import com.service.Rating_Service.repository.RatingRepository;


@Service
public class RatingServiceImpl implements RatingService{

	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		//return null;
		return ratingRepository.save(rating);
		
		
	}

	// get all ratigns
	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userID) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userID);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelID) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelID);
	}

}
