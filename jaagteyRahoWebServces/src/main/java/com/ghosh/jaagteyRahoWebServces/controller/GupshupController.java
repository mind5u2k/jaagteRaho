package com.ghosh.jaagteyRahoWebServces.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.sql.Timestamp;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.ClientManagementDao;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.User;
import com.ghosh.jaagteyRahoWebServces.model.GetOtp;
import com.ghosh.jaagteyRahoWebServces.msgService.SendSms;

@RestController
@RequestMapping("/gupshup")
public class GupshupController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	@Autowired
	private ClientManagementDao clientManagementDao;

	@RequestMapping(value = "/receivedMsg", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
	public void getuser(
			@RequestParam(name = "phonecode", required = false) String phonecode,
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "location", required = false) String location,
			@RequestParam(name = "carrier", required = false) String carrier,
			@RequestParam(name = "content", required = false) String content,
			@RequestParam(name = "msisdn", required = false) String msisdn,
			@RequestParam(name = "timestamp", required = false) String timestamp) {

		System.out.println("Received message jhahahahahahah");

		System.out.println("phonecode is [" + phonecode + "] [9220092200]");
		System.out.println("keyword is [" + keyword + "] [Jagtheraho]");
		System.out.println("location is [" + location + "] [UPWest]");
		System.out.println("carrier is [" + carrier + "] [Airtel]");
		System.out.println("content is [" + content + "] [Jagtheraho 7626]");
		System.out.println("msisdn is [" + msisdn + "] [918171908867]");
		System.out.println("timestamp is [" + timestamp + "] [1533546314367]");

		String number = msisdn.substring(2);
		User user = userDAO.getUserByMobileNo(number);
		SendSms sendSms = new SendSms();

		if (user == null) {
			sendSms.wrongNoSms(number);
		} else {
			String otp = content.replaceAll(keyword + " ", "");
			PushNotificationsStatus no = systemSetupDAO
					.getLatestPushNotificationByUser(user, Util.MSG);
			Timestamp sendTime = no.getSentTimestamp();
			Timestamp receiTime = new Timestamp(System.currentTimeMillis());
			if (otp.equals(no.getSentOtp())) {
				if (Util.compareTwoTimeStamps(receiTime, sendTime) > 5) {
					sendSms.expiredOTP(number);
				} else {
					sendSms.successOTP(number);
					no.setContactNumber(user.getContactNumber());
					no.setCurrentLocation(location);
					no.setEmployee(user);
					no.setReceivedStatus(Util.SUCCESS);
					no.setReceivedTimestamp(receiTime);
					no.setLatestStatus(0);
					systemSetupDAO.UpdatePustNotificationStatus(no);
				}
			} else {
				sendSms.wrongOTP(number);
			}
		}
	}
}
