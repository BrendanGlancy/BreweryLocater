package com.techelevator.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.beerDao;
import com.techelevator.application.dao.breweryDao;
import com.techelevator.application.dao.reviewDao;
import com.techelevator.application.model.Beer;
import com.techelevator.application.model.Brewery;
import com.techelevator.application.model.User;

@RestController
@CrossOrigin 
public class BeerController {
	@Autowired
	private beerDao beerDAO;
	
	@Autowired
	private breweryDao breweryDAO;
	
	@Autowired
	private reviewDao reviewDAO;
	
	
	/****************************************
	 * Controller
	 *
	 ***/
	
	public BeerController(beerDao beerDAO) {
		this.beerDAO = beerDAO;
	}
	
	/****************************************
	 * Request Mapping, shows beers
	 *
	 ***/
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/beers", method=RequestMethod.GET)
	public List<Beer> showAllBeers(ModelMap modelHolder) {
		List<Beer> beerList = beerDAO.getAllBeer();
		List<Brewery> breweries = breweryDAO.getAllBreweries();
		
		modelHolder.put("allBeers", beerList);
		modelHolder.put("allBreweries", breweries);
		return beerList;
	}
	
	/****************************************
	 * Request Mapping, show a beer by beerId
	 *
	 ***/
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/beers/{beerId}", method = RequestMethod.GET)
	public Beer getBeerByID(@PathVariable Long beerId) throws NotFoundException {
		return beerDAO.getBeerbyID(beerId);
	}
	
	/****************************************
	 * Request Mapping, add Beer
	 *
	 ***/
	
	@RequestMapping(path="/addBeer", method=RequestMethod.GET)
	public String showAddBeer() throws NotAllowedException {
		return "addBeer";
	}
	
	/****************************************
	 * Request Mapping, delete Beer
	 *
	 ***/
	
	@RequestMapping(path = "/beers/{beerId}", method = RequestMethod.DELETE)
	public void deleteABeer(@PathVariable Long beerId) throws NotAllowedException {
		beerDAO.deleteBeer(beerId);
	}
	
	/****************************************
	 * For Beads, getBeerByBreweryId 
	 *
	 ***/
	
	@PreAuthorize("permitAll")
	@RequestMapping(path="/breweries/{breweryId}/beers", method = RequestMethod.GET)
	public List<Beer> getBeerByBreweryID(@PathVariable Long breweryId) throws NotFoundException {
		return beerDAO.getBeerByBreweryID(breweryId);
	}
}
