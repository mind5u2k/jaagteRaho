package com.ghosh.jaagteyRaho.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ghosh.jaagteyRaho.service.PdfGeneration.PdfGeneration;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.Address;
import com.ghosh.jaagteyRahoBackend.dto.User;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory
			.getLogger(PageController.class);

	@Autowired
	private GlobalController globalController;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public String index(
			@RequestParam(name = "logout", required = false) String logout) {

		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		if (logout != null) {
			return "redirect:/logout";
		}

		User user = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());
		if (user.getRole().equals(Util.ROLE_SUPERADMIN)) {
			return "redirect:/su/home";
		} else if (user.getRole().equals(Util.ROLE_ADMIN)) {
			return "redirect:/ad/home";
		} else if (user.getRole().equals(Util.ROLE_SALESMANAGER)) {
			return "redirect:/sm/home";
		} else if (user.getRole().equals(Util.ROLE_SALESORGANIZER)) {
			return "redirect:/so/home";
		} else if (user.getRole().equals(Util.ROLE_SALESREPRESENTATIVE)) {
			return "redirect:/sr/home";
		} else if (user.getRole().equals(Util.ROLE_CLIENT)) {
			return "redirect:/cl/home";
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page1");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page1");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all the products and based on category
	 */

	/*
	 * Viewing a single product
	 */

	@RequestMapping(value = "/membership")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		logger.info("Page Controller membership called!");
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title", "Login");
		if (error != null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if (logout != null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription",
				"You are not authorized to view this page!");
		mv.addObject("title", "403 Access Denied");
		return mv;
	}

	@RequestMapping(value = "/downloadBill")
	public void downloadBill(HttpServletRequest request,
			HttpServletResponse response) {
		PdfGeneration generation = new PdfGeneration();
		try {
			generation.generateBill(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/editProfile")
	public ModelAndView downloadBill() {
		User client = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfilePage", true);
		mv.addObject("title", "Edit Profile");
		mv.addObject("client", client);

		Address address = null;
		address = userDAO.getAddressByUser(client.getId());
		if (address == null) {
			address = new Address();
			address.setUser(client);
			mv.addObject("address", address);
		} else {
			mv.addObject("address", address);
		}
		return mv;
	}

}
