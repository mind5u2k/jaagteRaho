package com.ghosh.jaagteyRahoWebServces.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.ghosh.jaagteyRahoWebServces.model.AuthUser;
import com.ghosh.jaagteyRahoWebServces.model.LoginCredentials;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ClientManagementDao clientManagementDao;

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<LoginCredentials> getuser(
			@RequestBody AuthUser employee) {
		HttpHeaders headers = new HttpHeaders();

		System.out.println("asdfasdfasdf [" + employee + "" + "]");

		if (employee == null) {
			LoginCredentials credentials = new LoginCredentials();
			credentials.setStatus(Util.FAILURE);
			credentials.setMsg("!! Bad Requery !!");
			return new ResponseEntity<LoginCredentials>(credentials, headers,
					HttpStatus.OK);
		}

		String username = employee.getContactNo();
		String password = employee.getPassword();

		System.out.println("----------[" + username + "][" + password
				+ "]------------");

		User u = userDAO.getUserByMobileNo(username);
		if (u == null) {
			LoginCredentials credentials = new LoginCredentials();
			credentials.setStatus(Util.FAILURE);
			credentials.setMsg("!! Not Registered !!");
			return new ResponseEntity<LoginCredentials>(credentials, headers,
					HttpStatus.OK);
		}

		boolean status = passwordEncoder.matches(password, u.getPassword());
		System.out.println("****************[" + status + "]***************");

		if (status) {
			LoginCredentials credentials = new LoginCredentials();
			credentials.setUser(u);

			String auth = u.getContactNumber() + ":" + password;
			byte[] encodedAuth = Base64.encode(auth
					.getBytes(StandardCharsets.ISO_8859_1));
			String authHeader = "Basic " + new String(encodedAuth);
			System.out.println("hahahahahahahahaha  [" + authHeader + "]");
			credentials.setAuthorizationToken(authHeader);
			credentials.setStatus(Util.SUCCESS);
			credentials.setMsg("you have logged In successfully");
			return new ResponseEntity<LoginCredentials>(credentials, headers,
					HttpStatus.OK);
		} else {
			LoginCredentials credentials = new LoginCredentials();
			credentials.setStatus(Util.FAILURE);
			credentials.setMsg("!! Wrong Credentials !!");
			return new ResponseEntity<LoginCredentials>(headers,
					HttpStatus.UNAUTHORIZED);
		}
	}
}
