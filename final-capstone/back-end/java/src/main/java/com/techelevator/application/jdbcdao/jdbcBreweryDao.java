package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.breweryDao;
import com.techelevator.application.model.Brewery;

@Component
public class jdbcBreweryDao implements breweryDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public jdbcBreweryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
// CRUD METHODS BELOW
	
// GET ALL BREWERIES
	
	@Override
	public List<Brewery> getAllBreweries(){
		List<Brewery> allBreweries = new ArrayList<>();
		String sqlGetAllBreweries = "SELECT * FROM breweries";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllBreweries);
		
		while(results.next()) {
			Brewery aBrewery = mapRowToBrewery(results);
			allBreweries.add(aBrewery);
		}
		return allBreweries;
	}
	
// GET BREWERY BY ID
	@Override
	public Brewery getBreweryById(Long breweryId) {
		Brewery aBrewery = new Brewery();
		String sqlGetABrewery = "SELECT * FROM breweries WHERE brewery_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetABrewery, breweryId);
		
		while(results.next()) {
			aBrewery = mapRowToBrewery(results);
		}
		
		return aBrewery;
	}
	
// CREATE A BREWERY
	@Override
	public void addNewBrewery(Brewery aBrewery) {
		String sqlAddBrewery = "INSERT INTO breweries (name, address, city,"
				+ "zipcode, phone_number, description, brewery_logo_url,"
				+ "user_id, hours, lat, lng) VALUES (?, ?, ?, ?, ?, ?, ?, ?,"
				+ "?, ?, ?)";
		jdbcTemplate.update(sqlAddBrewery, aBrewery.getName(), aBrewery.getAddress(),
				aBrewery.getCity(), aBrewery.getZipcode(), aBrewery.getPhoneNumber(),
				aBrewery.getDescription(), aBrewery.getBreweryLogoUrl(), aBrewery.getUserId(),
				aBrewery.getHours(), aBrewery.getLat(), aBrewery.getLng());
	}
	
// UPDATE A BREWERY
	
	@Override
	public void updateBrewery(Brewery aBrewery) {
		String sqlUpdateBrewery = "UPDATE breweries SET name = ?, address = ?,"
				+ " city = ?, zipcode = ?, phone_number = ?, description = ?, "
				+ "brewery_logo_url = ?, user_id = ?, hours = ?, lat = ?, lng = ?"
				+ "WHERE brewery_id = ?";
		jdbcTemplate.update(sqlUpdateBrewery, aBrewery.getName(), aBrewery.getAddress(),
				aBrewery.getCity(), aBrewery.getZipcode(), aBrewery.getPhoneNumber(),
				aBrewery.getDescription(), aBrewery.getBreweryLogoUrl(), aBrewery.getUserId(),
				aBrewery.getHours(), aBrewery.getLat(), aBrewery.getLng(), aBrewery.getBreweryId());
	}
	
// DELETE A BREWERY
	
	
	  @Override 
	  public void deleteBrewery(Long breweryId) {
		  String sqlDeleteBrewery = "DELETE FROM breweries WHERE brewery_id = ?";
		  jdbcTemplate.update(sqlDeleteBrewery, breweryId);
	  }
	 
	
	// MAP ROW TO BREWERY
	
	private Brewery mapRowToBrewery(SqlRowSet row) {
	Brewery newBrewery = new Brewery();
	newBrewery.setBreweryId(row.getInt("brewery_id"));
	newBrewery.setName(row.getString("name"));
	newBrewery.setAddress(row.getString("address"));
	newBrewery.setCity(row.getString("city"));
	newBrewery.setZipcode(row.getString("zipcode"));
	newBrewery.setPhoneNumber(row.getString("phone_number"));
	newBrewery.setDescription(row.getString("description"));
	newBrewery.setBreweryLogoUrl(row.getString("brewery_logo_url"));
	newBrewery.setWebsiteUrl(row.getString("website_url"));
	return newBrewery;
	}
}
