package com.techelevator.application.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.application.dao.beerDao;
import com.techelevator.application.dao.reviewDao;
import com.techelevator.application.model.Review;

@CrossOrigin
@RestController
public class ReviewController {

	@Autowired
	// Should not be private 
	reviewDao reviewDAO;
	
	@Autowired
	// Should not be private 
	beerDao beerDAO;
	
	public ReviewController(reviewDao reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	/****************************************
	 * Request Mapping to show reviews for a beer by id
	 *
	 ***/
	
	@RequestMapping(path = "/reviews/{beerId}", method = RequestMethod.GET)
	public List<Review> getReviews(@PathVariable Long beerId) throws NotFoundException {
		return reviewDAO.getReviews(beerId);
	}
	
	/****************************************
	 * Request Mapping to add a review for a beer by id
	 *
	 ***/
	
	@RequestMapping(path = "/reviews", method = RequestMethod.POST)
	public void addReviews(@RequestBody Review aReview) throws NotAllowedException {
		reviewDAO.addReview(aReview);
	}
	
	@RequestMapping(path="/beerDetails/{id}/review", method=RequestMethod.POST)
	public String createNewMessage(@PathVariable("id") long beerId, @Valid @ModelAttribute("newReview") Review review, BindingResult result, RedirectAttributes flash) throws NotFoundException {
		flash.addFlashAttribute("newReview", review);
		
		if (beerDAO.getBeerbyID(beerId) == null) {
			throw new NotFoundException();
		}
		
		if(result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newReview", result);
			return "redirect://beerDetails/{id}/review";
		}
		review.setCreateTime(LocalDateTime.now());
		
		reviewDAO.saveReview(review);
		
		return "redirect:/beerDetails/"+ beerId;
	}
}
