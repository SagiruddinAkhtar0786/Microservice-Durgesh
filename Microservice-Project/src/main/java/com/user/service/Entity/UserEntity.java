package com.user.service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

}
