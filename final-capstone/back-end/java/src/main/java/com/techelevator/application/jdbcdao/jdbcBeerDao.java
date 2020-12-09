package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

import com.techelevator.application.dao.beerDao;
import com.techelevator.application.model.Beer;

@Component
public class jdbcBeerDao implements beerDao {
	
	// Initialize the JDBC template
	private JdbcTemplate jdbcTemplate;
	
	/****************************************
	 * Constructor
	 *
	 ***/
	
	@Autowired
	public jdbcBeerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/****************************************
	 * get all the beers
	 *
	 ***/
	
	@Override
	public List<Beer> getAllBeer() {
		List<Beer> allBeers = new ArrayList<>();
		String sqlSelectAllBeers = "SELECT * FROM beers";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllBeers);
		
		while(results.next()) {
			Beer aBeer = mapRowToBeer(results);
			allBeers.add(aBeer);
		}
		return allBeers;
	}
	
	/****************************************
	 * get beer by id
	 *
	 ***/
	
	@Override
	public Beer getBeerbyID(Long beerId) {
		Beer aBeer = new Beer();
		String sqlGetABeer = "SELECT * FROM beers WHERE beer_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetABeer, beerId);
		
		while(results.next()) {
			aBeer = mapRowToBeer(results);
		}
		
		return aBeer;
	}
	
	/****************************************
	 * Delete a beer
	 *
	 ***/
	@Override
	public void deleteBeer(Long beerId) {
		String sqlDeleteABeer = "DELETE FROM beers WHERE beer_id = ?";
		jdbcTemplate.update(sqlDeleteABeer, beerId);
	}
	
	/****************************************
	 * Save a newBeer object
	 *
	 ***/
	
	@Override
	public void saveBeer(Beer newBeer) {
		jdbcTemplate.update("INSERT INTO beers(name, abv, ibu, type, info, img_url, brewery_id, is_active) VALUES (?,?,?,?,?,?,?,?)",
				newBeer.getName(), newBeer.getAbv(), newBeer.getIbu(), newBeer.getType(), newBeer.getInfo(), newBeer.getImgUrl(), newBeer.getBreweryId(), newBeer.isActive());
	}
	
	/****************************************
	 * SQL row set for Beer Pojo
	 *
	 ***/
	
	private Beer mapRowToBeer(SqlRowSet row) {
		Beer newBeer = new Beer();
		
		newBeer.setId(row.getLong("beer_id"));
		newBeer.setName(row.getString("name").toUpperCase());
		newBeer.setAbv(row.getFloat("abv"));
		newBeer.setIbu(row.getInt("ibu"));
		newBeer.setType(row.getString("type"));
		newBeer.setInfo(row.getString("info"));
		newBeer.setImgUrl(row.getString("img_url"));
		newBeer.setBreweryId(row.getLong("brewery_id"));
		newBeer.setActive(row.getBoolean("is_active"));

		return newBeer;
	}
	
	/****************************************
	 * For Beads, getBeerByBreweryID
	 *
	 ***/

	@Override
	public List<Beer> getBeerByBreweryID(Long breweryId) {
		List<Beer> allBeersByBreweryID = new ArrayList<>();
		String sqlGetBeerByBreweryId = "SELECT * FROM beers WHERE brewery_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetBeerByBreweryId, breweryId);
		
		while(results.next()) {
			Beer aBeer = mapRowToBeer(results);
			allBeersByBreweryID.add(aBeer);
		}
		
		return allBeersByBreweryID;
	}
}
