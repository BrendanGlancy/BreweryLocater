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
	
	@Autowired
	public jdbcBeerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
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
}
