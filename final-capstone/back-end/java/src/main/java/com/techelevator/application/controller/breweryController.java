package com.techelevator.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.breweryDao;
import com.techelevator.application.model.Brewery;

@RestController
@CrossOrigin 
public class breweryController {
	
	@Autowired
	private breweryDao breweryDao;
	
	public breweryController(breweryDao breweryDao) {
		this.breweryDao = breweryDao;
	}
	
	// Get all breweries
	@PreAuthorize("permitAll")
	@RequestMapping(path = "/breweries", method = RequestMethod.GET)
	public List<Brewery> getAllBreweries(){
		return breweryDao.getAllBreweries();
	}
	
	// Get Brewery by ID
	@PreAuthorize("permitAll")
	@RequestMapping(path = "/breweries/{breweryId}", method = RequestMethod.GET)
	public Brewery getBrewerybyBreweryID(@PathVariable Long breweryId) throws NotFoundException {
		return breweryDao.getBreweryById(breweryId);
	}
	
	// Add a new brewery
	// This needs to limited to just "Brewer" users
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "/breweries", method = RequestMethod.POST)
	public void addNewBrewery(@RequestBody Brewery aBrewery) throws NotAllowedException {
		breweryDao.addNewBrewery(aBrewery);
	}
	
	// Update a brewery
	@PreAuthorize("hasRole('ROLE_BREWER')")
	@RequestMapping(path = "/breweries", method = RequestMethod.PUT)
	public void updateBrewery(@RequestBody Brewery aBrewery) throws NotAllowedException {
		breweryDao.updateBrewery(aBrewery);
	}
	
	// Delete a brewery
	// Should be limited to Admin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path = "/breweries/{breweryId}", method = RequestMethod.DELETE)
	public void deleteBrewery(@PathVariable Long breweryId) throws NotAllowedException {
		breweryDao.deleteBrewery(breweryId);
	}
	
	//Get Brewery by user id
	@RequestMapping(path = "/users/{userId}/breweries", method = RequestMethod.GET)
	public List<Brewery> getBreweriesByUserId(@PathVariable Long userId) throws NotFoundException{
		return breweryDao.getBreweryByUserID(userId);
	}
	
}
