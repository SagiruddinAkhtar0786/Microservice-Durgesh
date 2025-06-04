package com.service.Rating_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.Rating_Service.Entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {

}
