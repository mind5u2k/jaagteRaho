package com.ghosh.jaagteyRahoBackend;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	public static final String ROLE_SUPERADMIN = "SUPER ADMIN";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_SALESMANAGER = "SALES MANAGER";
	public static final String ROLE_SALESORGANIZER = "SALES ORGANIZER";
	public static final String ROLE_SALESREPRESENTATIVE = "SALES REPRESENTATIVE";
	public static final String ROLE_CLIENT = "CLIENT";

	public static List<String> superAdminRoles() {
		List<String> roles = new ArrayList<String>();
		roles.add(ROLE_SUPERADMIN);
		roles.add(ROLE_ADMIN);
		return roles;
	}

	public static List<String> adminRoles() {
		List<String> roles = new ArrayList<String>();
		roles.add(ROLE_SALESMANAGER);
		roles.add(ROLE_SALESORGANIZER);
		return roles;
	}

	public static final String STATUS_ASSIGNED = "ASSIGNED";
	public static final String STATUS_TRIAL = "Trial";
	public static final String STAUS_ACTIVE = "Active";
	public static final String STATUS_DEACTIVATE = "Deactivated";

	private static final int MAX_VERIFICATION_CODE = 100000;
	private static final int MIN_VERIFICATION_CODE = 999999;

	public static String generateVerificationCode() {
		Random rand = new Random();
		Integer code = rand.nextInt(MIN_VERIFICATION_CODE
				- MAX_VERIFICATION_CODE + 1)
				+ MAX_VERIFICATION_CODE;
		return code.toString();
	}

	public static final String DURATION_MONTHLY = "Monthly";
	public static final String DURATION_QUARTERLY = "Quarterly";
	public static final String DURATION_HAlF_YEARLY = "Half Yearly";
	public static final String DURATION_YEARLY = "Yearly";

	public static List<String> getAllPaymentDuration() {
		List<String> durations = new ArrayList<String>();
		durations.add(DURATION_MONTHLY);
		durations.add(DURATION_QUARTERLY);
		durations.add(DURATION_HAlF_YEARLY);
		durations.add(DURATION_YEARLY);
		return durations;
	}

	public static String changeTimestampToString3(Timestamp timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"HH:mm aaa, dd MMMMM yyyy ");
		String string = dateFormat.format(timestamp);
		System.out.println(string);
		return string;
	}

	public static void main(String[] args) {
		System.out.println("generated verification code is ---");
		System.out.println(generateVerificationCode());
	}

}
