package com.ghosh.jaagteyRahoBackend;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	public static final String ROLE_SUPERADMIN = "SUPER ADMIN";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_USER = "USER";

	public static List<String> superAdminRoles() {
		List<String> roles = new ArrayList<String>();
		roles.add(ROLE_SUPERADMIN);
		roles.add(ROLE_ADMIN);
		roles.add(ROLE_USER);
		return roles;
	}

	public static List<String> getRoles() {
		List<String> roles = new ArrayList<String>();
		roles.add(ROLE_ADMIN);
		roles.add(ROLE_USER);
		return roles;
	}

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";

	public static final String STATUS_ASSIGNED = "ASSIGNED";
	public static final String STATUS_TRIAL = "Trial";
	public static final String STAUS_ACTIVE = "Active";
	public static final String STATUS_DEACTIVATE = "Deactivated";

	private static final int MAX_VERIFICATION_CODE = 1000;
	private static final int MIN_VERIFICATION_CODE = 9999;

	public static String generateOTP() {
		Random rand = new Random();
		Integer code = rand.nextInt(MIN_VERIFICATION_CODE
				- MAX_VERIFICATION_CODE + 1)
				+ MAX_VERIFICATION_CODE;
		return code.toString();
	}

	public static String changeTimestampToString3(Timestamp timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"HH:mm aaa, dd MMMMM yyyy ");
		String string = dateFormat.format(timestamp);
		System.out.println(string);
		return string;
	}

	public static final String INTERVAL_TIME_5MIN = "5 Mins";
	public static final String INTERVAL_TIME_10MIN = "10 Mins";
	public static final String INTERVAL_TIME_15MIN = "15 Mins";
	public static final String INTERVAL_TIME_20MIN = "20 Mins";
	public static final String INTERVAL_TIME_30MIN = "30 Mins";
	public static final String INTERVAL_TIME_1HR = "1 Hr";
	public static final String INTERVAL_TIME_2HRS = "2 Hrs";
	public static final String INTERVAL_TIME_3HRS = "3 Hrs";

	public static List<String> getIntervalTimes() {
		List<String> intervals = new ArrayList<String>();
		intervals.add(INTERVAL_TIME_5MIN);
		intervals.add(INTERVAL_TIME_10MIN);
		intervals.add(INTERVAL_TIME_15MIN);
		intervals.add(INTERVAL_TIME_20MIN);
		intervals.add(INTERVAL_TIME_30MIN);
		intervals.add(INTERVAL_TIME_1HR);
		intervals.add(INTERVAL_TIME_2HRS);
		intervals.add(INTERVAL_TIME_3HRS);
		return intervals;
	}

	public static final String TIME_12AM = "12 AM";
	public static final String TIME_01AM = "01 AM";
	public static final String TIME_02AM = "02 AM";
	public static final String TIME_03AM = "03 AM";
	public static final String TIME_04AM = "04 AM";
	public static final String TIME_05AM = "05 AM";
	public static final String TIME_06AM = "06 AM";
	public static final String TIME_07AM = "07 AM";
	public static final String TIME_08AM = "08 AM";
	public static final String TIME_09AM = "09 AM";
	public static final String TIME_10AM = "10 AM";
	public static final String TIME_11AM = "11 AM";
	public static final String TIME_12PM = "12 PM";
	public static final String TIME_01PM = "01 PM";
	public static final String TIME_02PM = "02 PM";
	public static final String TIME_03PM = "03 PM";
	public static final String TIME_04PM = "04 PM";
	public static final String TIME_05PM = "05 PM";
	public static final String TIME_06PM = "06 PM";
	public static final String TIME_07PM = "07 PM";
	public static final String TIME_08PM = "08 PM";
	public static final String TIME_09PM = "09 PM";
	public static final String TIME_10PM = "10 PM";
	public static final String TIME_11PM = "11 PM";

	public static List<String> getTimes() {
		List<String> times = new ArrayList<String>();
		times.add(TIME_12AM);
		times.add(TIME_01AM);
		times.add(TIME_02AM);
		times.add(TIME_03AM);
		times.add(TIME_04AM);
		times.add(TIME_05AM);
		times.add(TIME_06AM);
		times.add(TIME_07AM);
		times.add(TIME_08AM);
		times.add(TIME_09AM);
		times.add(TIME_10AM);
		times.add(TIME_11AM);
		times.add(TIME_12PM);
		times.add(TIME_01PM);
		times.add(TIME_02PM);
		times.add(TIME_03PM);
		times.add(TIME_04PM);
		times.add(TIME_05PM);
		times.add(TIME_06PM);
		times.add(TIME_07PM);
		times.add(TIME_08PM);
		times.add(TIME_09PM);
		times.add(TIME_10PM);
		times.add(TIME_11PM);
		return times;
	}

	public static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 12) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static char[] OTP() {
		String numbers = "0123456789";
		Random rndm_method = new Random();
		char[] otp = new char[4];
		for (int i = 0; i < 4; i++) {
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public static long compareTwoTimeStamps(java.sql.Timestamp currentTime,
			java.sql.Timestamp oldTime) {
		long milliseconds1 = oldTime.getTime();
		long milliseconds2 = currentTime.getTime();

		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffMinutes;
	}

	public static void main(String[] args) {
		System.out.println(Util.OTP());
	}

}
