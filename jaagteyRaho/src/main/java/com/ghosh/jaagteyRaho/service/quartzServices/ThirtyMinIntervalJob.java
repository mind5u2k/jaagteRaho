package com.ghosh.jaagteyRaho.service.quartzServices;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ghosh.jaagteyRaho.service.PushNotifictionHelper;
import com.ghosh.jaagteyRaho.service.msgService.SendSms;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.User;

public class ThirtyMinIntervalJob {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	public void execute() {
		AutoCheckinSetting autoCheckinSetting = systemSetupDAO
				.getAutoCheckinSetting();
		if (autoCheckinSetting != null) {
			int startTime = Integer.parseInt(autoCheckinSetting.getStartTime()
					.substring(0, 2));
			String startExt = autoCheckinSetting.getStartTime().substring(3, 5);
			int endTime = Integer.parseInt(autoCheckinSetting.getEndTime()
					.substring(0, 2));
			String endExt = autoCheckinSetting.getEndTime().substring(3, 5);
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			Calendar c = Calendar.getInstance();
			if (startExt.equals("AM")) {
				c.set(Calendar.HOUR_OF_DAY, startTime);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
			} else if (startExt.equals("PM")) {
				c.set(Calendar.HOUR, startTime);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
			}
			Timestamp startTimeStamp = new Timestamp(c.getTimeInMillis());
			c = Calendar.getInstance();
			if (endExt.equals("AM")) {
				c.set(Calendar.HOUR_OF_DAY, endTime);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
			} else if (endExt.equals("PM")) {
				c.set(Calendar.HOUR, endTime);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
			}
			Timestamp endTimeStamp = new Timestamp(c.getTimeInMillis());
			if (Util.compareTwoTimeStamps(currentTime, startTimeStamp) > 0
					&& Util.compareTwoTimeStamps(endTimeStamp, currentTime) > 0) {
				if (autoCheckinSetting.getAutoCheckinIntTime().equals(
						Util.INTERVAL_TIME_30MIN)) {
					List<User> users = userDAO
							.getAllUsersByRole(Util.ROLE_USER);
					String userNos = "";
					if (users != null) {
						for (User u : users) {
							if (u.getPushNotificationToken() != null) {
								try {
									String otp = Util.generateOTP();
									String st = PushNotifictionHelper
											.sendPushNotification(
													u.getPushNotificationToken(),
													otp);

									PushNotificationsStatus noStatus = new PushNotificationsStatus();
									noStatus.setEmployee(u);
									noStatus.setLatestStatus(1);
									noStatus.setSentOtp(otp);
									noStatus.setSentStatus(Util.SUCCESS);
									noStatus.setSentTimestamp(new Timestamp(
											System.currentTimeMillis()));

									List<PushNotificationsStatus> ss = systemSetupDAO
											.getLatestPushNotifications();
									for (PushNotificationsStatus p : ss) {
										p.setLatestStatus(0);
										systemSetupDAO
												.UpdatePustNotificationStatus(p);
									}
									systemSetupDAO
											.addPustNotificationStatus(noStatus);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							userNos = userNos + u.getContactNumber();
						}
					}
					SendSms sendSms = new SendSms();
					// sendSms.sendSms(userNos);
				}
			}
		}
	}
}
