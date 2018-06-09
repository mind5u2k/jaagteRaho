package com.ghosh.jaagteyRaho.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ghosh.jaagteyRaho.model.SiteEmpReport;
import com.ghosh.jaagteyRaho.service.MailNotificationServices.MailNotification;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.Client;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.Designation;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteContactMapping;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;
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

	@Autowired
	private ClientManagementDao clientManagementDao;

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
			} else if (status.equals("mailExist")) {
				mv.addObject("errorMsg", "Mail Id is already Registerd");
			} else if (status.equals("numberExist")) {
				mv.addObject("errorMsg", "Contact Number is already registered");
			} else if (status.equals("updateSuccess")) {
				mv.addObject("msg",
						"Employee Details has been updated successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating User");
			} else if (status.equals("updateFailureMail")) {
				mv.addObject("errorMsg",
						"Mail Id already registered with Other Employee");
			} else if (status.equals("updateFailureNumber")) {
				mv.addObject("errorMsg",
						"Contact Number already registered with other Employee");
			}
		}
		List<Designation> designations = userDAO.getAllDesignations();
		mv.addObject("designations", designations);
		User user = new User();
		user.setGender("Male");
		mv.addObject("user", user);

		List<Site> sites = clientManagementDao.getAllSites();
		mv.addObject("sites", sites);

		List<String> roles = Util.getRoles();
		mv.addObject("roles", roles);

		List<User> users = userDAO.getAllUsers();
		mv.addObject("users", users);
		mv.addObject("title", "Employees");
		mv.addObject("userClickAdminAddEmployees", true);
		return mv;
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("user") User user) {

		String passCode = "";
		User user2 = userDAO.getByEmail(user.getEmail());
		User user3 = userDAO.getUserByMobileNo(user.getContactNumber());
		boolean status = false;
		if (user2 == null && user3 == null) {
			passCode = Util.getSaltString();
			String password = passwordEncoder.encode(passCode);
			user.setPassword(password);
			User u = userDAO.addUser(user);
			if (u != null) {
				System.out.println("user id is [" + u.getId() + "]");
				System.out.println("''''''''''[" + user.getSite().getId()
						+ "]''''''''");
				if (user.getSite().getId() != 0) {
					Site site = clientManagementDao.getSiteById(user.getSite()
							.getId());
					System.out.println("==[" + site + "]==");
					SiteEmployeeMapping siteEmployeeMapping = new SiteEmployeeMapping();
					siteEmployeeMapping.setEmployee(u);
					siteEmployeeMapping.setSite(site);
					SiteEmployeeMapping s = clientManagementDao
							.getSiteEmpMappingByEmpAndSite(site, u);
					System.out.println("`````----``[" + s + "]");
					if (s == null) {
						boolean st = clientManagementDao
								.saveOrUpdateSiteEmployeeMapping(siteEmployeeMapping);
						System.out.println("```````[" + st + "]");
					}
				}
				status = true;
			}

			if (status) {
				MailNotification.sendMail(user.getEmail(), "", "",
						"Jaagtey Raho - *Confidential*",
						"Your password for Jaagtey Raho Tool is <br>"
								+ passCode);
				return "redirect:/ad/addEmployees?status=success";
			} else {
				return "redirect:/ad/addEmployees?status=failure";
			}
		} else {
			if (user2 != null) {
				return "redirect:/ad/addEmployees?status=mailExist";
			} else if (user3 != null) {
				return "redirect:/ad/addEmployees?status=numberExist";
			} else {
				return "redirect:/ad/addEmployees?status=failure";
			}
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

		List<String> roles = Util.getRoles();
		mv.addObject("roles", roles);

		mv.addObject("employee", user);
		return mv;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") User employee) {

		User u1 = userDAO.getByEmail(employee.getEmail());
		if (u1.getId() == employee.getId()) {
			u1 = null;
		}
		User u2 = userDAO.getUserByMobileNo(employee.getContactNumber());
		if (u2.getId() == employee.getId()) {
			u2 = null;
		}
		if (u1 == null && u2 == null) {
			User user = userDAO.get(employee.getId());
			user.setEmpId(employee.getEmpId());
			user.setEmail(employee.getEmail());
			user.setFirstName(employee.getFirstName());
			user.setMiddleName(employee.getMiddleName());
			user.setLastName(employee.getLastName());
			user.setDob(employee.getDob());
			user.setContactNumber(employee.getContactNumber());
			user.setAlternateNumber(employee.getAlternateNumber());
			user.setGender(employee.getGender());
			user.setDesignation(employee.getDesignation());
			user.setRole(employee.getRole());

			user.setCorredpondenceAddress(employee.getCorredpondenceAddress());
			user.setCorredpondencePostalCode(employee
					.getCorredpondencePostalCode());
			user.setCorredpondenceState(employee.getCorredpondenceState());
			user.setCorredpondenceCity(employee.getCorredpondenceCity());

			user.setPermanentAddress(employee.getPermanentAddress());
			user.setPermanentPostalCode(employee.getPermanentPostalCode());
			user.setPermanentState(employee.getPermanentState());
			user.setPermanentCity(employee.getPermanentCity());
			boolean status = userDAO.updateUser(user);
			if (status) {
				return "redirect:/ad/addEmployees?status=updateSuccess";
			} else {
				return "redirect:/ad/addEmployees?status=updateFailure";
			}
		} else {
			if (u1 != null) {
				return "redirect:/ad/addEmployees?status=updateFailureMail";
			} else if (u2 != null) {
				return "redirect:/ad/addEmployees?status=updateFailureNumber";
			} else {
				return "redirect:/ad/addEmployees?status=updateFailure";
			}
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

	@RequestMapping("/manageChecklist")
	public ModelAndView manageChecklist(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");

		if (status != null) {
			if (status.equals("updateSuccess")) {
				mv.addObject("msg", "Updated Successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating");
			}
		}

		mv.addObject("title", "Manage Checklist");
		mv.addObject("userClickAdminManageChecklist", true);
		return mv;
	}

	@RequestMapping("/manageContact")
	public ModelAndView manageContact(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg", "New Contact Added Successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg",
						"Getting Error while Adding New Contact Person");
			} else if (status.equals("updateSuccess")) {
				mv.addObject("msg", "Contact person Updated Successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg",
						"Getting Error while Updating Contact Person");
			} else if (status.equals("deleteSuccess")) {
				mv.addObject("msg", "Contact person Deleted Successfully");
			} else if (status.equals("deleteFailure")) {
				mv.addObject("errorMsg",
						"Getting Error while Deleting Contact Person");
			}
		}

		List<ContactPerson> contactPersons = systemSetupDAO
				.getAllContactPersons();
		mv.addObject("contactPersons", contactPersons);

		ContactPerson contactPerson = new ContactPerson();
		mv.addObject("contactPerson", contactPerson);
		mv.addObject("title", "Manage Contact");
		mv.addObject("userClickAdminManageContact", true);
		return mv;
	}

	@RequestMapping(value = "/addNewContact", method = RequestMethod.POST)
	public String addNewContact(
			@ModelAttribute("contactPerson") ContactPerson contactPerson) {

		boolean status = systemSetupDAO.addUpdatedContactPerson(contactPerson);
		if (status) {
			return "redirect:/ad/manageContact?status=success";
		} else {
			return "redirect:/ad/manageContact?status=failure";
		}
	}

	@RequestMapping("/editContactPerson")
	public ModelAndView editContactPerson(
			@RequestParam(name = "contactPersonId", required = false) Integer contactPersonId) {
		ModelAndView mv = new ModelAndView("editContactPerson");
		ContactPerson selectedContactPerson = systemSetupDAO
				.getContactPersonById(contactPersonId);
		mv.addObject("selectedContactPerson", selectedContactPerson);
		return mv;
	}

	@RequestMapping(value = "/updatedContactPerson", method = RequestMethod.POST)
	public String updatedContactPerson(
			@ModelAttribute("selectedContactPerson") ContactPerson selectedContactPerson) {

		boolean status = systemSetupDAO
				.addUpdatedContactPerson(selectedContactPerson);
		if (status) {
			return "redirect:/ad/manageContact?status=updateSuccess";
		} else {
			return "redirect:/ad/manageContact?status=updateFailure";
		}
	}

	@RequestMapping(value = "/deleteContactPerson")
	public String deleteContactPerson(
			@RequestParam(name = "contactPersonId", required = false) Integer contactPersonId) {

		ContactPerson contactPerson = systemSetupDAO
				.getContactPersonById(contactPersonId);
		boolean status = systemSetupDAO.deleteContactPerson(contactPerson);
		if (status) {
			return "redirect:/ad/manageContact?status=deleteSuccess";
		} else {
			return "redirect:/ad/manageContact?status=deleteFailure";
		}
	}

	@RequestMapping("/manageClient")
	public ModelAndView manageClient(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg", "Client has been added successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg", "Getting Error while Saving Client");
			} else if (status.equals("deleteSuccess")) {
				mv.addObject("msg", "Deleted Successfully");
			} else if (status.equals("deleteFailure")) {
				mv.addObject("errorMsg",
						"Client can not be deleted as the reference of the Client exist");
			} else if (status.equals("updateSuccess")) {
				mv.addObject("msg", "Updated Successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating Client");
			}
		}

		List<Client> clients = clientManagementDao.getAllClients();
		mv.addObject("clients", clients);

		Client client = new Client();
		mv.addObject("client", client);

		mv.addObject("title", "Clients");
		mv.addObject("userClickAdminManageClient", true);
		return mv;
	}

	@RequestMapping(value = "/deleteClient/{id}")
	public String deleteClient(@PathVariable int id) {
		Client client = clientManagementDao.getClientById(id);
		boolean status = false;
		try {
			status = clientManagementDao.deleteClient(client);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("hello there [" + status + "]");
		if (status) {
			return "redirect:/ad/manageClient?status=deleteSuccess";
		} else {
			return "redirect:/ad/manageClient?status=deleteFailure";
		}
	}

	@RequestMapping(value = "/addNewClient", method = RequestMethod.POST)
	public String addNewClient(@ModelAttribute("client") Client client) {

		boolean status = clientManagementDao.saveOrUpdateClient(client);
		if (status) {
			return "redirect:/ad/manageClient?status=success";
		} else {
			return "redirect:/ad/manageClient?status=failure";
		}
	}

	@RequestMapping("/editClient")
	public ModelAndView editClient(
			@RequestParam(name = "clientId", required = false) Integer clientId) {
		ModelAndView mv = new ModelAndView("editClient");
		Client selectedClient = clientManagementDao.getClientById(clientId);
		mv.addObject("selectedClient", selectedClient);
		return mv;
	}

	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	public String updateClient(
			@ModelAttribute("selectedClient") Client selectedClient) {
		boolean status = clientManagementDao.saveOrUpdateClient(selectedClient);
		if (status) {
			return "redirect:/ad/manageClient?status=updateSuccess";
		} else {
			return "redirect:/ad/manageClient?status=updateFailure";
		}
	}

	@RequestMapping("/manageSite")
	public ModelAndView manageSite(
			@RequestParam(name = "status", required = false) String status) {
		ModelAndView mv = new ModelAndView("page");

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg", "Site has been added successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg", "Getting Error while Saving Site");
			} else if (status.equals("updateSuccess")) {
				mv.addObject("msg", "Updated Successfully");
			} else if (status.equals("updateFailure")) {
				mv.addObject("errorMsg", "Getting Error while Updating Site");
			} else if (status.equals("deleteSuccess")) {
				mv.addObject("msg", "Deleted Successfully");
			} else if (status.equals("deleteFailure")) {
				mv.addObject("errorMsg",
						"Selected Site can not be deleted as the reference of the Site exists");
			}
		}

		List<Site> sites = clientManagementDao.getAllSites();
		mv.addObject("sites", sites);

		Site site = new Site();
		mv.addObject("site", site);

		List<Client> clients = clientManagementDao.getAllClients();
		mv.addObject("clients", clients);

		List<User> employees = userDAO.getAllUsersByRole(Util.ROLE_USER);
		mv.addObject("employees", employees);

		mv.addObject("title", "Sites");
		mv.addObject("userClickAdminManageSite", true);
		return mv;
	}

	@RequestMapping(value = "/addNewSite", method = RequestMethod.POST)
	public String addNewSite(@ModelAttribute("site") Site site) {

		Client client = clientManagementDao.getClientById(site.getClient()
				.getId());
		site.setClient(client);

		Site s = clientManagementDao.saveSite(site);
		boolean status = false;
		if (s != null) {
			System.out.println("----------[" + s.getId() + "]");
			if (site.getUser().getId() != 0) {
				User user = userDAO.get(site.getUser().getId());
				System.out.println("==[" + user + "]==");
				SiteEmployeeMapping siteEmployeeMapping = new SiteEmployeeMapping();
				siteEmployeeMapping.setEmployee(user);
				siteEmployeeMapping.setSite(s);
				boolean st = clientManagementDao
						.saveOrUpdateSiteEmployeeMapping(siteEmployeeMapping);
				System.out.println("```````[" + st + "]");
			}
			status = true;
		}

		System.out.println("+++[" + status + "]++");

		if (status) {
			return "redirect:/ad/manageSite?status=success";
		} else {
			return "redirect:/ad/manageSite?status=failure";
		}
	}

	@RequestMapping("/editSite")
	public ModelAndView editSite(
			@RequestParam(name = "siteId", required = false) Integer siteId) {
		ModelAndView mv = new ModelAndView("editSite");
		Site selectedSite = clientManagementDao.getSiteById(siteId);
		mv.addObject("selectedSite", selectedSite);
		List<Client> clients = clientManagementDao.getAllClients();
		mv.addObject("clients", clients);
		return mv;
	}

	@RequestMapping(value = "/updateSite", method = RequestMethod.POST)
	public String updateSite(@ModelAttribute("selectedSite") Site selectedSite) {
		Client client = clientManagementDao.getClientById(selectedSite
				.getClient().getId());
		selectedSite.setClient(client);
		boolean status = clientManagementDao.saveOrUpdateSite(selectedSite);
		if (status) {
			return "redirect:/ad/manageSite?status=updateSuccess";
		} else {
			return "redirect:/ad/manageSite?status=updateFailure";
		}
	}

	@RequestMapping(value = "/deleteSite/{id}")
	public String deleteSite(@PathVariable int id) {
		Site site = clientManagementDao.getSiteById(id);
		boolean status = false;
		try {
			status = clientManagementDao.deleteSite(site);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("hello there [" + status + "]");
		if (status) {
			return "redirect:/ad/manageSite?status=deleteSuccess";
		} else {
			return "redirect:/ad/manageSite?status=deleteFailure";
		}
	}

	@RequestMapping("/assignEmployees")
	public ModelAndView assignEmployees(
			@RequestParam(name = "siteId", required = false) Integer siteId,
			@RequestParam(name = "status", required = false) String status) {

		ModelAndView mv = new ModelAndView("assignEmployees");

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg1", "Employee has been assigned successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg1", "Getting Error while Assigning");
			} else if (status.equals("revokesuccess")) {
				mv.addObject("msg1", "Revoked Successfully");
			} else if (status.equals("revokefailure")) {
				mv.addObject("errorMsg1", "Getting Error while Revoking");
			}
		}

		Site selectedSite = clientManagementDao.getSiteById(siteId);
		mv.addObject("selectedSite", selectedSite);

		List<SiteEmployeeMapping> employeeMappings = clientManagementDao
				.assignedEmployeestoSite(selectedSite);

		System.out
				.println("site employees mappings [" + employeeMappings + "]");

		if (employeeMappings != null) {
			System.out.println("total mapping for site ["
					+ selectedSite.getSiteName() + "] is ["
					+ employeeMappings.size() + "]");
		}

		mv.addObject("employeeMappings", employeeMappings);

		List<User> employees = clientManagementDao
				.getUnAssignedEmployees(selectedSite);
		System.out.println("total unassigned employees [" + employees.size()
				+ "]");
		mv.addObject("employees", employees);

		return mv;
	}

	@RequestMapping("/assignEmp")
	public String assignEmp(
			@RequestParam(name = "selectedSiteId", required = false) Integer selectedSiteId,
			@RequestParam(name = "empId", required = false) Integer empId) {

		Site selectedSite = clientManagementDao.getSiteById(selectedSiteId);
		User user = userDAO.get(empId);

		SiteEmployeeMapping employeeMapping = new SiteEmployeeMapping();
		employeeMapping.setEmployee(user);
		employeeMapping.setSite(selectedSite);

		boolean status = clientManagementDao
				.saveOrUpdateSiteEmployeeMapping(employeeMapping);

		if (status) {
			return "redirect:/ad/assignEmployees?siteId=" + selectedSiteId
					+ "&status=success";
		} else {
			return "redirect:/ad/assignEmployees?siteId=" + selectedSiteId
					+ "&status=failure";
		}
	}

	@RequestMapping("/revokeEmp")
	public String revokeEmp(
			@RequestParam(name = "siteMappingId", required = false) Integer siteMappingId) {

		SiteEmployeeMapping mapping = clientManagementDao
				.getSiteEmpMappingById(siteMappingId);

		Site site = mapping.getSite();

		boolean status = clientManagementDao.deleteSiteEmpMapping(mapping);

		if (status) {
			return "redirect:/ad/assignEmployees?siteId=" + site.getId()
					+ "&status=revokesuccess";
		} else {
			return "redirect:/ad/assignEmployees?siteId=" + site.getId()
					+ "&status=revokefailure";
		}
	}

	@RequestMapping("/assignContactperson")
	public ModelAndView assignContactperson(
			@RequestParam(name = "siteId", required = false) Integer siteId,
			@RequestParam(name = "status", required = false) String status) {

		ModelAndView mv = new ModelAndView("assignContactperson");

		if (status != null) {
			if (status.equals("success")) {
				mv.addObject("msg1",
						"Contact Person has been assigned successfully");
			} else if (status.equals("failure")) {
				mv.addObject("errorMsg1", "Getting Error while Assigning");
			} else if (status.equals("revokesuccess")) {
				mv.addObject("msg1", "Revoked Successfully");
			} else if (status.equals("revokefailure")) {
				mv.addObject("errorMsg1", "Getting Error while Revoking");
			}
		}

		Site selectedSite = clientManagementDao.getSiteById(siteId);
		mv.addObject("selectedSite", selectedSite);

		List<SiteContactMapping> contactMappings = clientManagementDao
				.assignedContactstoSite(selectedSite);

		mv.addObject("contactMappings", contactMappings);

		List<ContactPerson> contactPersons = clientManagementDao
				.getUnAssignedContacts(selectedSite);
		mv.addObject("contactPersons", contactPersons);

		return mv;
	}

	@RequestMapping("/assignContacts")
	public String assignContacts(
			@RequestParam(name = "selectedSiteId", required = false) Integer selectedSiteId,
			@RequestParam(name = "cpId", required = false) Integer cpId) {

		Site selectedSite = clientManagementDao.getSiteById(selectedSiteId);
		ContactPerson contactPerson = systemSetupDAO.getContactPersonById(cpId);

		SiteContactMapping contactMapping = new SiteContactMapping();
		contactMapping.setContactPerson(contactPerson);
		contactMapping.setSite(selectedSite);

		boolean status = clientManagementDao
				.saveOrUpdateSiteContactMapping(contactMapping);

		if (status) {
			return "redirect:/ad/assignContactperson?siteId=" + selectedSiteId
					+ "&status=success";
		} else {
			return "redirect:/ad/assignContactperson?siteId=" + selectedSiteId
					+ "&status=failure";
		}
	}

	@RequestMapping("/revokeContactPerson")
	public String revokeContactPerson(
			@RequestParam(name = "contactMappingId", required = false) Integer contactMappingId) {

		SiteContactMapping mapping = clientManagementDao
				.getContactMappingById(contactMappingId);

		Site site = mapping.getSite();

		boolean status = clientManagementDao.deleteSiteContactMapping(mapping);

		if (status) {
			return "redirect:/ad/assignContactperson?siteId=" + site.getId()
					+ "&status=revokesuccess";
		} else {
			return "redirect:/ad/assignContactperson?siteId=" + site.getId()
					+ "&status=revokefailure";
		}
	}

	@RequestMapping("/report")
	public ModelAndView report(
			@RequestParam(name = "userId", required = false) Integer userId) {
		ModelAndView mv = new ModelAndView("page");
		List<User> users = userDAO.getAllUsersByRole(Util.ROLE_USER);
		User emp = null;

		if (userId != null) {
			emp = userDAO.get(userId);
		} else {
			if (users != null && users.size() > 0) {
				emp = users.get(0);
			}
		}
		List<PushNotificationsStatus> pushNotificationsStatus = new ArrayList<PushNotificationsStatus>();
		if (emp != null) {
			pushNotificationsStatus = systemSetupDAO
					.getPushNotificationsByEmployee(emp);
		}

		mv.addObject("pushNotificationsStatus", pushNotificationsStatus);
		mv.addObject("users", users);
		mv.addObject("emp", emp);
		mv.addObject("title", "Report");
		mv.addObject("userClickAdminReport", true);
		return mv;
	}

	@RequestMapping("/employeeSiteReport")
	public ModelAndView employeeSiteReport() {
		ModelAndView mv = new ModelAndView("page");

		List<Site> sites = clientManagementDao.getAllSites();
		List<SiteEmpReport> reports = new ArrayList<SiteEmpReport>();
		for (Site site : sites) {
			SiteEmpReport report = new SiteEmpReport();
			report.setSite(site);
			report.setMappings(clientManagementDao
					.assignedEmployeestoSite(site));
			reports.add(report);
		}

		mv.addObject("reports", reports);
		mv.addObject("title", "Employee Site Report");
		mv.addObject("userClickAdminEmployeeSiteReport", true);
		return mv;
	}

}
