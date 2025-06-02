package com.service.HotelService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.HotelService.entity.Hotel;
import com.service.HotelService.exceptions.ResourceNotFoundException;
import com.service.HotelService.repository.HotelRepository;

@Service
public class HotelServiceimpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub.
		/*
		 * return hotelRepository.findById(id) .orElseThrow(() -> new
		 * ResourceNotFoundException("hotel with given Id Not Found !!"+id));
		 */
		
		return hotelRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Resource with given ID not found on server: "));
	}

}
