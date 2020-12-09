package com.techelevator.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/****************************************
	 * Request Mapping to show reviews for a beer by id
	 *
	 ***/
	
	@RequestMapping(path = "/reviews/{beerId}", method = RequestMethod.GET)
	public List<Review> getReviews(@PathVariable Long beerId) throws NotFoundException {
		return reviewDao.getReviews(beerId);
	}
	
	/****************************************
	 * Request Mapping to add a review for a beer by id
	 *
	 ***/
	
	@RequestMapping(path = "/reviews", method = RequestMethod.POST)
	public void addReviews(@RequestBody Review aReview) throws NotAllowedException {
		reviewDao.addReview(aReview);
	}
	
}
