package com.service.Rating_Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Rating_Service.Entities.Rating;
import com.service.Rating_Service.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	
	
	@Autowired
	private RatingService ratingService;
	
	// create
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating Rating) {
	//	return new ResponseEntity<>()
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(Rating));
		
	}
	
	// get All
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatingsByuserId(@PathVariable("Id") String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("Id") String Hotelid){
		return ResponseEntity.ok(ratingService.getRatingByUserId(Hotelid));
	}
}
