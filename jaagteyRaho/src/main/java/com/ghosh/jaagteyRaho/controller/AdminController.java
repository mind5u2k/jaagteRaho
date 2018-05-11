package com.ghosh.jaagteyRaho.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.User;

@Controller
@RequestMapping("/ad")
public class AdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@Autowired
	private GlobalController globalController;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("page");
		User admin = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());

		mv.addObject("title", "Home");
		mv.addObject("userClickAdminHome", true);
		return mv;
	}

	@RequestMapping("/manageDesignation")
	public ModelAndView manageDesignation(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");
		User admin = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg", "Designation has been added successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg",
						"Getting Error while saving Designation");
			}
		}

		List<Designation> designations = userDAO.getAllDesignations();
		mv.addObject("designations", designations);

		Designation designation = new Designation();
		mv.addObject("designation", designation);

		mv.addObject("title", "Designation");
		mv.addObject("userClickAdminManageDesignation", true);
		return mv;
	}

	@RequestMapping(value = "/addDesignation", method = RequestMethod.POST)
	public String addDesignation(
			@ModelAttribute("designation") Designation designation) {
		boolean status = userDAO.addDesignation(designation);
		if (status) {
			return "redirect:/ad/manageDesignation?status=success";
		} else {
			return "redirect:/ad/manageDesignation?status=failure";
		}
	}

	@RequestMapping("/addEmployees")
	public ModelAndView addEmployees(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");
		User admin = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg", "User has been added successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg",
						"Getting Error while Creating New User");
			} else if (status.equals("updateSuccess")) {
				mv.addObject("msg",
						"Employee Details has been updated successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating User");
			}
		}
		List<Designation> designations = userDAO.getAllDesignations();
		mv.addObject("designations", designations);
		User user = new User();
		user.setGender("Male");
		mv.addObject("user", user);

		List<User> users = userDAO.getAllUsers();
		mv.addObject("users", users);
		mv.addObject("title", "Employees");
		mv.addObject("userClickAdminAddEmployees", true);
		return mv;
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("user") User user) {
		user.setRole(Util.ROLE_USER);
		boolean status = userDAO.add(user);
		if (status) {
			return "redirect:/ad/addEmployees?status=success";
		} else {
			return "redirect:/ad/addEmployees?status=failure";
		}
	}

	@RequestMapping("/editUser")
	public ModelAndView editUser(
			@RequestParam(name = "userId", required = false) Integer userId) {
		ModelAndView mv = new ModelAndView("editUser");
		User admin = userDAO.getByEmail(globalController.getUserModel()
				.getEmail());

		User user = userDAO.get(userId);

		List<Designation> designations = userDAO.getAllDesignations();
		mv.addObject("designations", designations);
		mv.addObject("employee", user);
		return mv;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") User employee) {

		employee.setRole(Util.ROLE_USER);
		boolean status = userDAO.updateUser(employee);
		;
		if (status) {
			return "redirect:/ad/addEmployees?status=updateSuccess";
		} else {
			return "redirect:/ad/addEmployees?status=updateFailure";
		}
	}

	@RequestMapping("/autoCheckinSetting")
	public ModelAndView autoCheckinSetting(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");

		if (status != null) {
			if (status.equals("updateSuccess")) {
				mv.addObject("msg", "Updated Successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating");
			}
		}

		AutoCheckinSetting autoCheckinSetting = systemSetupDAO
				.getAutoCheckinSetting();
		if (autoCheckinSetting == null) {
			autoCheckinSetting = new AutoCheckinSetting();
		}
		mv.addObject("autoCheckinSetting", autoCheckinSetting);
		mv.addObject("intervalTimes", Util.getIntervalTimes());
		mv.addObject("times", Util.getTimes());
		mv.addObject("title", "Auto Checkin Setting");
		mv.addObject("userClickAdminAutoCheckinSetting", true);
		return mv;
	}

	@RequestMapping(value = "/updateAutoCheckin", method = RequestMethod.POST)
	public String updateAutoCheckin(
			@ModelAttribute("autoCheckinSetting") AutoCheckinSetting autoCheckinSetting) {

		boolean status = systemSetupDAO
				.updateAutoCheckinSetting(autoCheckinSetting);
		if (status) {
			return "redirect:/ad/autoCheckinSetting?status=updateSuccess";
		} else {
			return "redirect:/ad/autoCheckinSetting?status=updateFailure";
		}
	}
}
