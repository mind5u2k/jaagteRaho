package com.ghosh.jaagteyRahoWebServces.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.ghosh.jaagteyRahoWebServces.model.GetOtp;
import com.ghosh.jaagteyRahoWebServces.model.GetPushNotiToken;

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

	@RequestMapping(value = "/Contacts", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ContactPerson>> Contacts() {

		HttpHeaders headers = new HttpHeaders();
		List<ContactPerson> contactPersons = systemSetupDAO
				.getAllContactPersons();

		if (contactPersons == null) {
			return new ResponseEntity<List<ContactPerson>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number Of Records Found",
				String.valueOf(contactPersons.size()));
		return new ResponseEntity<List<ContactPerson>>(contactPersons, headers,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getEmployee(
			@PathVariable("id") Integer employeeId) {
		User employee = userDAO.get(employeeId);
		if (employee == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteEmployee(
			@PathVariable("id") Integer employeeId) {
		HttpHeaders headers = new HttpHeaders();
		User employee = userDAO.get(employeeId);
		if (employee == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userDAO.deleteUser(employee);
		headers.add("Employee Deleted - ", String.valueOf(employeeId));
		return new ResponseEntity<User>(employee, headers,
				HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> createEmployee(@RequestBody User employee) {
		HttpHeaders headers = new HttpHeaders();
		if (employee == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		userDAO.add(employee);
		headers.add("Employee Created  - ", String.valueOf(employee.getEmpId()));
		return new ResponseEntity<User>(employee, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/pushNotificationToken", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<GetPushNotiToken> pushNotificationToken(
			@RequestBody User employee) {
		HttpHeaders headers = new HttpHeaders();
		User user = userDAO.getUserByMobileNo(employee.getContactNumber());
		System.out.println("total users are [" + user + "]");
		if (user == null) {
			GetPushNotiToken getOtp = new GetPushNotiToken();
			getOtp.setStatus(Util.FAILURE);
			getOtp.setMsg("!! Wrong Credentials !!");
			return new ResponseEntity<GetPushNotiToken>(getOtp, headers,
					HttpStatus.NOT_FOUND);
		}
		user.setPushNotificationToken(employee.getPushNotificationToken());
		userDAO.updateUser(user);

		GetPushNotiToken getOtp = new GetPushNotiToken();
		getOtp.setStatus(Util.SUCCESS);
		getOtp.setMsg("!! Notification token updated successfully !!");
		return new ResponseEntity<GetPushNotiToken>(getOtp, headers,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/sendOtp", method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<GetOtp> getOtp(
			@RequestBody PushNotificationsStatus notification) {
		HttpHeaders headers = new HttpHeaders();

		User user = userDAO.getUserByMobileNo(notification.getContactNumber());
		if (user == null) {
			GetOtp getOtp = new GetOtp();
			getOtp.setStatus(Util.FAILURE);
			getOtp.setMsg("!! Wrong Credentials !!");
			return new ResponseEntity<GetOtp>(getOtp, headers,
					HttpStatus.NOT_FOUND);
		}

		PushNotificationsStatus no = systemSetupDAO
				.getLatestPushNotificationByUser(user);
		if (no == null) {
			GetOtp getOtp = new GetOtp();
			getOtp.setStatus(Util.FAILURE);
			getOtp.setMsg("!! Wrong Credentials !!");
			return new ResponseEntity<GetOtp>(getOtp, headers,
					HttpStatus.NOT_FOUND);
		}

		Timestamp sendTime = no.getSentTimestamp();
		Timestamp receiTime = new Timestamp(System.currentTimeMillis());

		if (notification.getOtp().equals(no.getSentOtp())) {
			if (Util.compareTwoTimeStamps(receiTime, sendTime) > 5) {
				GetOtp getOtp = new GetOtp();
				getOtp.setStatus(Util.FAILURE);
				getOtp.setMsg("!! OTP has been expired !!");
				return new ResponseEntity<GetOtp>(getOtp, headers,
						HttpStatus.OK);
			} else {
				GetOtp getOtp = new GetOtp();
				getOtp.setStatus(Util.SUCCESS);
				getOtp.setMsg("!! Cheers !!");
				no.setReceivedStatus(Util.SUCCESS);
				no.setReceivedTimestamp(receiTime);
				no.setLatestStatus(false);
				systemSetupDAO.UpdatePustNotificationStatus(no);
				return new ResponseEntity<GetOtp>(getOtp, headers,
						HttpStatus.OK);
			}
		} else {
			GetOtp getOtp = new GetOtp();
			getOtp.setStatus(Util.FAILURE);
			getOtp.setMsg("!! You have entered a wrong OTP !!");
			return new ResponseEntity<GetOtp>(getOtp, headers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateEmployee(
			@PathVariable("id") Integer employeeId, @RequestBody User employee) {
		HttpHeaders headers = new HttpHeaders();
		User isExist = userDAO.get(employeeId);
		if (isExist == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else if (employee == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		userDAO.updateUser(employee);
		headers.add("Employee Updated  - ", String.valueOf(employeeId));
		return new ResponseEntity<User>(employee, headers, HttpStatus.OK);
	}

}
