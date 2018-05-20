package com.ghosh.jaagteyRahoWebServces.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.User;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	@Autowired
	private ClientManagementDao clientManagementDao;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<User>> employees() {

		HttpHeaders headers = new HttpHeaders();
		List<User> employees = userDAO.getAllUsers();

		if (employees == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number Of Records Found", String.valueOf(employees.size()));
		return new ResponseEntity<List<User>>(employees, headers, HttpStatus.OK);
	}

}
