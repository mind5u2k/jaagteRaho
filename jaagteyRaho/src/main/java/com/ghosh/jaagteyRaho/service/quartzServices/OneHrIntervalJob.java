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

public class OneHrIntervalJob {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	public void execute() {

		List<AutoCheckinSetting> autoCheckinSettings = systemSetupDAO
				.getAutoCheckinSetting();

		for (AutoCheckinSetting autoCheckinSetting : autoCheckinSettings) {
			if (autoCheckinSetting != null) {
				int startTime = Integer.parseInt(autoCheckinSetting
						.getStartTime().substring(0, 2));
				String startExt = autoCheckinSetting.getStartTime().substring(
						3, 5);
				int endTime = Integer.parseInt(autoCheckinSetting.getEndTime()
						.substring(0, 2));
				String endExt = autoCheckinSetting.getEndTime().substring(3, 5);
				Timestamp currentTime = new Timestamp(
						System.currentTimeMillis());
				Calendar c = Calendar.getInstance();
				if (startExt.equals("AM")) {
					if (startTime == 12) {
						startTime = 00;
					}
					c.set(Calendar.HOUR_OF_DAY, startTime);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
				} else if (startExt.equals("PM")) {
					if (startTime != 12) {
						startTime = startTime + 12;
					}
					c.set(Calendar.HOUR_OF_DAY, startTime);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
				}
				Timestamp startTimeStamp = new Timestamp(c.getTimeInMillis());
				c = Calendar.getInstance();
				if (endExt.equals("AM")) {
					if (endTime == 12) {
						endTime = 00;
					}
					c.set(Calendar.HOUR_OF_DAY, endTime);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
				} else if (endExt.equals("PM")) {
					if (endTime != 12) {
						endTime = endTime + 12;
					}
					c.set(Calendar.HOUR_OF_DAY, endTime);
					c.set(Calendar.MINUTE, 0);
					c.set(Calendar.SECOND, 0);
				}
				Timestamp endTimeStamp = new Timestamp(c.getTimeInMillis());
				if (Util.compareTwoTimeStamps(currentTime, startTimeStamp) > 0
						&& Util.compareTwoTimeStamps(endTimeStamp, currentTime) > 0) {
					if (autoCheckinSetting.getAutoCheckinIntTime().equals(
							Util.INTERVAL_TIME_1HR)) {
						String userNos = "";
						User u = autoCheckinSetting.getEmployee();
						if (autoCheckinSetting.getPushNotification() == 1) {
							if (u.getPushNotificationToken() != null) {
								try {
									String otp = Util.generateOTP();
									String st = PushNotifictionHelper
											.sendPushNotification(
													u.getPushNotificationToken(),
													otp);

									systemSetupDAO.updateAllNotifications(u);

									PushNotificationsStatus noStatus = new PushNotificationsStatus();
									noStatus.setEmployee(u);
									noStatus.setLatestStatus(1);
									noStatus.setSentOtp(otp);
									noStatus.setSentBy(Util.NOTIFICATION);
									noStatus.setSentStatus(Util.SUCCESS);
									noStatus.setSentTimestamp(new Timestamp(
											System.currentTimeMillis()));
									systemSetupDAO
											.addPustNotificationStatus(noStatus);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						} else if (autoCheckinSetting.getMsg() == 1) {
							SendSms sendSms = new SendSms();
							String otp = Util.generateOTP();
							String msgStatus = sendSms.sendSms(u, otp);

							systemSetupDAO.updateAllNotifications(u);

							PushNotificationsStatus noStatus = new PushNotificationsStatus();
							noStatus.setEmployee(u);
							noStatus.setLatestStatus(1);
							noStatus.setSentOtp(otp);
							noStatus.setSentBy(Util.MSG);
							if (msgStatus.toString().substring(0, 5)
									.equals("error")) {
								noStatus.setSentStatus(Util.FAILURE);
							} else {
								noStatus.setSentStatus(Util.SUCCESS);
							}
							noStatus.setSentTimestamp(new Timestamp(System
									.currentTimeMillis()));
							systemSetupDAO.addPustNotificationStatus(noStatus);
						}
					}
				}
			}
		}

		try {
			Thread.sleep(300000);
			for (AutoCheckinSetting autoCheckinSetting : autoCheckinSettings) {
				if (autoCheckinSetting != null) {
					int startTime = Integer.parseInt(autoCheckinSetting
							.getStartTime().substring(0, 2));
					String startExt = autoCheckinSetting.getStartTime()
							.substring(3, 5);
					int endTime = Integer.parseInt(autoCheckinSetting
							.getEndTime().substring(0, 2));
					String endExt = autoCheckinSetting.getEndTime().substring(
							3, 5);
					Timestamp currentTime = new Timestamp(
							System.currentTimeMillis());
					Calendar c = Calendar.getInstance();
					if (startExt.equals("AM")) {
						if (startTime == 12) {
							startTime = 00;
						}
						c.set(Calendar.HOUR_OF_DAY, startTime);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
					} else if (startExt.equals("PM")) {
						if (startTime != 12) {
							startTime = startTime + 12;
						}
						c.set(Calendar.HOUR_OF_DAY, startTime);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
					}
					Timestamp startTimeStamp = new Timestamp(
							c.getTimeInMillis());
					c = Calendar.getInstance();
					if (endExt.equals("AM")) {
						if (endTime == 12) {
							endTime = 00;
						}
						c.set(Calendar.HOUR_OF_DAY, endTime);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
					} else if (endExt.equals("PM")) {
						if (endTime != 12) {
							endTime = endTime + 12;
						}
						c.set(Calendar.HOUR_OF_DAY, endTime);
						c.set(Calendar.MINUTE, 0);
						c.set(Calendar.SECOND, 0);
					}
					Timestamp endTimeStamp = new Timestamp(c.getTimeInMillis());
					if (Util.compareTwoTimeStamps(currentTime, startTimeStamp) > 0
							&& Util.compareTwoTimeStamps(endTimeStamp,
									currentTime) > 0) {
						if (autoCheckinSetting.getAutoCheckinIntTime().equals(
								Util.INTERVAL_TIME_1HR)) {
							String userNos = "";
							User u = autoCheckinSetting.getEmployee();
							if (autoCheckinSetting.getPushNotification() == 2) {
								if (u.getPushNotificationToken() != null) {
									try {
										String otp = Util.generateOTP();
										if (systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.MSG) != null) {
											String st = PushNotifictionHelper
													.sendPushNotification(
															u.getPushNotificationToken(),
															otp);
											systemSetupDAO
													.updateAllNotifications(u);

											PushNotificationsStatus noStatus = new PushNotificationsStatus();
											noStatus.setEmployee(u);
											noStatus.setLatestStatus(1);
											noStatus.setSentOtp(otp);
											noStatus.setSentBy(Util.NOTIFICATION);
											noStatus.setSentStatus(Util.SUCCESS);
											noStatus.setSentTimestamp(new Timestamp(
													System.currentTimeMillis()));
											systemSetupDAO
													.addPustNotificationStatus(noStatus);
										}
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							} else if (autoCheckinSetting.getMsg() == 2) {
								SendSms sendSms = new SendSms();
								String otp = Util.generateOTP();
								if (u.getPushNotificationToken() != null) {
									if (systemSetupDAO
											.getLatestPushNotificationByUser(u,
													Util.NOTIFICATION) != null) {
										String msgStatus = sendSms.sendSms(u,
												otp);
										systemSetupDAO
												.updateAllNotifications(u);
										PushNotificationsStatus noStatus = new PushNotificationsStatus();
										noStatus.setEmployee(u);
										noStatus.setLatestStatus(1);
										noStatus.setSentOtp(otp);
										noStatus.setSentBy(Util.MSG);

										if (msgStatus.toString()
												.substring(0, 5)
												.equals("error")) {
											noStatus.setSentStatus(Util.FAILURE);
										} else {
											noStatus.setSentStatus(Util.SUCCESS);
										}
										noStatus.setSentTimestamp(new Timestamp(
												System.currentTimeMillis()));
										systemSetupDAO
												.addPustNotificationStatus(noStatus);
									}
								} else {
									String msgStatus = sendSms.sendSms(u, otp);
									systemSetupDAO.updateAllNotifications(u);
									PushNotificationsStatus noStatus = new PushNotificationsStatus();
									noStatus.setEmployee(u);
									noStatus.setLatestStatus(1);
									noStatus.setSentOtp(otp);
									noStatus.setSentBy(Util.MSG);
									if (msgStatus.toString().substring(0, 5)
											.equals("error")) {
										noStatus.setSentStatus(Util.FAILURE);
									} else {
										noStatus.setSentStatus(Util.SUCCESS);
									}
									noStatus.setSentTimestamp(new Timestamp(
											System.currentTimeMillis()));
									systemSetupDAO
											.addPustNotificationStatus(noStatus);
								}
							}
						}
					}
				}
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
