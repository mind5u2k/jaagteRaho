package com.ghosh.jaagteyRaho.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ghosh.jaagteyRaho.model.UserModel;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;
	private User user = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext()
					.getAuthentication();

			if (!authentication.getPrincipal().equals("anonymousUser")) {
				// get the user from the database
				user = userDAO.getByEmail(authentication.getName());

				if (user != null) {
					userModel = new UserModel();
					userModel.setId(user.getId());
					userModel.setFullName(user.getFirstName() + " "
							+ user.getLastName());
					userModel.setEmail(user.getEmail());
					userModel.setRole(user.getRole());
					session.setAttribute("userModel", userModel);
					return userModel;
				}
			}
		}

		return (UserModel) session.getAttribute("userModel");
	}

}
