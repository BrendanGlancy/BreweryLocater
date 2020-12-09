package com.techelevator.application.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.techelevator.application.model.Review;

public interface reviewDao {

	List<Review> getReviews(Long beer_id);
	
	void addReview(Review aReview);

}
