package com.techelevator.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.beerDao;
import com.techelevator.application.dao.breweryDao;
import com.techelevator.application.dao.reviewDao;
import com.techelevator.application.model.Beer;
import com.techelevator.application.model.Brewery;

@RestController
public class BeerController {
	@Autowired
	private beerDao beerDAO;
	
	@Autowired
	private breweryDao breweryDAO;
	
	@Autowired
	private reviewDao reviewDAO;
	
	public BeerController(beerDao beerDAO) {
		this.beerDAO = beerDAO;
	}
	
	@RequestMapping(path="/beers", method=RequestMethod.GET)
	public List<Beer> showAllBeers(ModelMap modelHolder) {
		return beerDAO.getAllBeer();
		/* List<Brewery> breweries = breweryDAO.getAllBreweries();
		
		modelHolder.put("allBeers", beerList);
		modelHolder.put("allBreweries", breweries);
		return "beers";*/
	}
}
