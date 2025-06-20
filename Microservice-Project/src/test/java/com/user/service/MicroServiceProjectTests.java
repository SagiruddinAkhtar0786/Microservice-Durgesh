package com.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.user.service.Entity.Rating;
import com.user.service.external.Services.RatingService;

@SpringBootTest
class MicroServiceProjectTests {

	@Test
	void contextLoads() {
	}
	
	
	@Autowired
	private RatingService ratingService;
	
	
/*	@Test
	void createRating() {
		Rating rating = Rating.builder().rating("10").userId("").hotelId("").remark("this is created using feign client").build();
		ResponseEntity<Rating> saveResponseEntityRating =ratingService.createRating(rating);
		saveResponseEntityRating.getStatusCode();
		System.out.println("new rating created");
	}*/
}
