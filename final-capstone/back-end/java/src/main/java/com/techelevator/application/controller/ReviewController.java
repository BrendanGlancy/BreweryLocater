package com.techelevator.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.reviewDao;
import com.techelevator.application.model.Review;

@RestController
public class ReviewController {

	@Autowired
	private reviewDao reviewDao;
	
	public ReviewController(reviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@RequestMapping(path = "/reviews/{beerId}", method = RequestMethod.GET)
	public List<Review> getReviews(@PathVariable Long beerId){
		return reviewDao.getReviews(beerId);
	}
	
}
