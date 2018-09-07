package com.ghosh.jaagteyRaho.service.quartzServices;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.httpclient.HttpException;
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

public class FiveMinIntervalJob {

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
				System.out.println("start time stamp [" + startTimeStamp + "]");
				System.out.println("End time stamp [" + endTimeStamp + "]");
				if (Util.compareTwoTimeStamps(currentTime, startTimeStamp) > 0
						&& Util.compareTwoTimeStamps(endTimeStamp, currentTime) > 0) {
					if (autoCheckinSetting.getAutoCheckinIntTime().equals(
							Util.INTERVAL_TIME_5MIN)) {
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		/*-Calendar c = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(c.getTimeInMillis());
		Date date = new Date(timestamp.getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.YEAR));*/
	}
}
