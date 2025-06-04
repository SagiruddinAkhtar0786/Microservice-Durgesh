package com.service.Rating_Service.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_Rating")
public class Rating {
	
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private String rating;
	private String remark;
	
}
