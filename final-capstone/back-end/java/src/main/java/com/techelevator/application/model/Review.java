package com.techelevator.application.model;

import java.time.LocalDateTime;

public class Review {
	// Instance Variables
	private Long id;
	private String description;
	private int rating;
	private LocalDateTime createTime;
	private Long beerId;
	private Long userId;
	private String name;
	

	/****************************************
	 * Getters and Setters
	 *
	 ***/
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public long getBeerId() {
		return beerId;
	}
	
	public void setBeerId(Long beerId) {
		this.beerId = beerId;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
