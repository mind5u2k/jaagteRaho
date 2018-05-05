package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.Address;
import com.ghosh.jaagteyRahoBackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);

	User get(int id);

	boolean add(User user);

	User addUser(User user);

	boolean updateUser(User user);

	List<User> getAllUsers();

	Address getAddress(int addressId);

	boolean addAddress(Address address);

	boolean updateAddress(Address address);

	Address getAddressByUser(int userId);

}
