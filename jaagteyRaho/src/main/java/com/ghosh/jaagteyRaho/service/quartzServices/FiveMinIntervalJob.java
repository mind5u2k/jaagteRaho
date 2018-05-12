package com.ghosh.jaagteyRaho.service.quartzServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ghosh.jaagteyRaho.service.msgService.SendSms;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.User;

public class FiveMinIntervalJob {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	public void execute() {

		AutoCheckinSetting autoCheckinSetting = systemSetupDAO
				.getAutoCheckinSetting();
		if (autoCheckinSetting != null) {
			if (autoCheckinSetting.getAutoCheckinIntTime().equals(
					Util.INTERVAL_TIME_5MIN)) { 
				List<User> users = userDAO.getAllUsers();
				String userNos = "";
				if (users != null) {
					for (User u : users) {
						userNos = userNos + u.getContactNumber();
					}
				}
				SendSms sendSms = new SendSms();
				// sendSms.sendSms(userNos);
			}
		}
	}
}
