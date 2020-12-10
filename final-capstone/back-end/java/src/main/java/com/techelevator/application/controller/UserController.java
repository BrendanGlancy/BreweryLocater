package com.techelevator.application.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.breweryDao;
import com.techelevator.security.model.User;
import com.techelevator.security.dao.UserDAO;
import com.techelevator.security.dao.UserSqlDAO;

@CrossOrigin
@RestController
public class UserController {

	private UserDAO userDAO;

	@Autowired
	breweryDao breweryDAO;
	UserSqlDAO userSqlDao;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/****************************************
	 * Request Mapping to show display password form
	 *
	 ***/

	@RequestMapping(path = "/users/{userName}/changePassword", method = RequestMethod.GET)
	public String displayChangePasswordForm(Map<String, Object> model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}

	/****************************************
	 * Request Mapping to update password
	 *
	 ***/

	@RequestMapping(path = "/users/{userName}/changePassword", method = RequestMethod.POST)
	public String changePassword(@PathVariable String userName, @RequestParam String password) {
		userDAO.updatePassword(userName, password);
		return "userDashboard";
	}

	/****************************************
	 * Request Mapping to get user by id
	 *
	 ***//*
			 * 
			 * @RequestMapping(path="/users/{userId}", method = RequestMethod.GET) public
			 * User getUserByID(@PathVariable Long userId) { return
			 * userSqlDao.getUserById(userId); }
			 */
}
