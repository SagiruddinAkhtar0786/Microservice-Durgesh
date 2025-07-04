package com.user.service.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class UserEntity {

	@Id // I dont want to generate it by automatically so not provide
		// GeneratedValue(stretegry=GenerationType.identity)
	@Column(name = "ID")
	private String userId;
	@Column(name = "NAME",length=20)
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
	
	
	

}
