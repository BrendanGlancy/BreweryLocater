package com.techelevator.security.dao;

import java.util.List;

import com.techelevator.security.model.User;

public interface UserDAO {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password, String role);

	void updatePassword(String userName, String password);

	void deleteUser(Long userId);

	
}
