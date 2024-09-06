package com.projects.quickcart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "retailers")
@Getter
@Setter

public class Retailer {
	@Id
	@Column(name = "user_id")
	private long userId;

}
