package com.user.service.external.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.service.Entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	//GET
	
	//POST
	@PostMapping("/ratings")
	Rating createRating();
	
	// PUT

}
