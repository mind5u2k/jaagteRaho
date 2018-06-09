package com.ghosh.jaagteyRahoBackend.dao;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.Address;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);

	User getUserByMobileNo(String no);

	User get(int id);

	boolean add(User user);

	User addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);

	List<User> getAllUsers();

	List<User> getAllUsersByRole(String role);

	List<Designation> getAllDesignations();

	boolean addDesignation(Designation designation);

	Address getAddress(int addressId);

	boolean addAddress(Address address);

	boolean updateAddress(Address address);

	Address getAddressByUser(int userId);

}
