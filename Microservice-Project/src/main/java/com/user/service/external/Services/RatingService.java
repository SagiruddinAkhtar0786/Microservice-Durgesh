package com.user.service.external.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.Entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	//GET
	
	//POST
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	
	// PUT
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
	// Delete
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);

}
