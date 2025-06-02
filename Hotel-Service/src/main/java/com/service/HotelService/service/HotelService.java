package com.service.HotelService.service;

import java.util.List;

import com.service.HotelService.entity.Hotel;

public interface HotelService {
	// create
	
	Hotel create(Hotel hotel);
	
	// get all
	
	List<Hotel> getAll();
	// get Single
	Hotel get(String id);
}
