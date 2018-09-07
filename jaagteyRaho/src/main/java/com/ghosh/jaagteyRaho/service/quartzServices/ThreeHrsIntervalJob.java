package com.ghosh.jaagteyRaho.service.quartzServices;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ghosh.jaagteyRaho.service.PushNotifictionHelper;
import com.ghosh.jaagteyRaho.service.callService.CallTrigger;
import com.ghosh.jaagteyRaho.service.msgService.SendSms;
import com.ghosh.jaagteyRahoBackend.Util;
import com.ghosh.jaagteyRahoBackend.dao.SystemSetupDAO;
import com.ghosh.jaagteyRahoBackend.dao.UserDAO;
import com.ghosh.jaagteyRahoBackend.dto.AutoCheckinSetting;
import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;
import com.ghosh.jaagteyRahoBackend.dto.User;

public class ThreeHrsIntervalJob {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SystemSetupDAO systemSetupDAO;

	public void execute() {

		List<AutoCheckinSetting> autoCheckinSettings = systemSetupDAO
				.getAutoCheckinSetting();

		List<User> users = new ArrayList<User>();

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
							Util.INTERVAL_TIME_3HRS)) {
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
						} else if (autoCheckinSetting.getCalls() == 1) {
							users.add(u);
						}
					}
				}
			}
		}
		List<String> numbers = new ArrayList<String>();
		for (User u : users) {
			numbers.add(u.getContactNumber());
			systemSetupDAO.updateAllNotifications(u);
			PushNotificationsStatus noStatus = new PushNotificationsStatus();
			noStatus.setEmployee(u);
			noStatus.setLatestStatus(1);
			noStatus.setSentStatus(Util.SUCCESS);
			noStatus.setSentBy(Util.CALL);
			noStatus.setSentTimestamp(new Timestamp(System.currentTimeMillis()));
			systemSetupDAO.addPustNotificationStatus(noStatus);
		}

		CallTrigger callTrigger = new CallTrigger();
		try {
			callTrigger.sendCall(numbers);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		users = new ArrayList<User>();
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
								Util.INTERVAL_TIME_3HRS)) {
							String userNos = "";
							User u = autoCheckinSetting.getEmployee();
							if (autoCheckinSetting.getPushNotification() == 2) {
								if (u.getPushNotificationToken() != null) {
									try {
										String otp = Util.generateOTP();
										if (systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.MSG) != null
												|| systemSetupDAO
														.getLatestPushNotificationByUser(
																u, Util.CALL) != null) {
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
								if (systemSetupDAO
										.getLatestPushNotificationByUser(u,
												Util.NOTIFICATION) != null
										|| systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.CALL) != null) {
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

							} else if (autoCheckinSetting.getCalls() == 2) {
								if (systemSetupDAO
										.getLatestPushNotificationByUser(u,
												Util.NOTIFICATION) != null
										|| systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.MSG) != null) {
									users.add(u);
								}
							}
						}
					}
				}
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		numbers = new ArrayList<String>();
		for (User u : users) {
			numbers.add(u.getContactNumber());
			systemSetupDAO.updateAllNotifications(u);
			PushNotificationsStatus noStatus = new PushNotificationsStatus();
			noStatus.setEmployee(u);
			noStatus.setLatestStatus(1);
			noStatus.setSentBy(Util.CALL);
			noStatus.setSentStatus(Util.SUCCESS);
			noStatus.setSentTimestamp(new Timestamp(System.currentTimeMillis()));
			systemSetupDAO.addPustNotificationStatus(noStatus);
		}
		try {
			callTrigger.sendCall(numbers);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		users = new ArrayList<User>();
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
								Util.INTERVAL_TIME_3HRS)) {
							String userNos = "";
							User u = autoCheckinSetting.getEmployee();
							if (autoCheckinSetting.getPushNotification() == 3) {
								if (u.getPushNotificationToken() != null) {
									try {
										String otp = Util.generateOTP();
										if (systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.MSG) != null
												|| systemSetupDAO
														.getLatestPushNotificationByUser(
																u, Util.CALL) != null) {
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
							} else if (autoCheckinSetting.getMsg() == 3) {
								SendSms sendSms = new SendSms();
								String otp = Util.generateOTP();
								if (systemSetupDAO
										.getLatestPushNotificationByUser(u,
												Util.NOTIFICATION) != null
										|| systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.CALL) != null) {
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

							} else if (autoCheckinSetting.getCalls() == 3) {
								if (systemSetupDAO
										.getLatestPushNotificationByUser(u,
												Util.NOTIFICATION) != null
										|| systemSetupDAO
												.getLatestPushNotificationByUser(
														u, Util.MSG) != null) {
									users.add(u);
								}
							}
						}
					}
				}
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		numbers = new ArrayList<String>();
		for (User u : users) {
			numbers.add(u.getContactNumber());
			systemSetupDAO.updateAllNotifications(u);
			PushNotificationsStatus noStatus = new PushNotificationsStatus();
			noStatus.setEmployee(u);
			noStatus.setLatestStatus(1);
			noStatus.setSentBy(Util.CALL);
			noStatus.setSentStatus(Util.SUCCESS);
			noStatus.setSentTimestamp(new Timestamp(System.currentTimeMillis()));
			systemSetupDAO.addPustNotificationStatus(noStatus);
		}
		try {
			callTrigger.sendCall(numbers);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}
