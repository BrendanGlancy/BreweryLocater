package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.reviewDao;
import com.techelevator.application.model.Review;

@Component
public class jdbcReviewDao implements reviewDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public jdbcReviewDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//GET REVIEWS
	@Override
	public List<Review> getReviews(Long beerId){
		 List<Review> reviews = new ArrayList<>();
		 String sqlGetReviewByBeerId = "SELECT * FROM reviews WHERE beer_id = ?";
		 SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetReviewByBeerId, beerId);
		 
		 while(results.next()) {
			 Review aReview = mapRowToReview(results);
			 reviews.add(aReview);
		 }
		 return reviews;
	}
	
	
	
	
	private Review mapRowToReview(SqlRowSet row) {
		Review review = new Review();
		
		review.setId(row.getLong("reviews_id"));
		review.setName(row.getString("name"));
		review.setDescription(row.getString("description"));
		review.setRating(row.getInt("rating"));
		review.setCreateTime(row.getTimestamp("create_date").toLocalDateTime());
		review.setBeerId(row.getLong("beer_id"));
		review.setUserId(row.getLong("user_id"));
		return review;
	}
	
	

}
