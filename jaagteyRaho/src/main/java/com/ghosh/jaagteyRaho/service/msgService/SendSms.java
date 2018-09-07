package com.ghosh.jaagteyRaho.service.msgService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ghosh.jaagteyRahoBackend.dto.User;

public class SendSms {
	public String sendSms(User u, String otp) {
		try {

			System.out.println("---------------hello");

			HttpURLConnection conn = (HttpURLConnection) new URL(
					"http://enterprise.smsgupshup.com/GatewayAPI/rest?msg=Hi%20"
							+ u.getFirstName()
							+ "%20!!%20Your%20OTP%20is%20"
							+ otp
							+ "%20.%20To%20response%20for%20this%20OTP%20type%20Jagteyraho<SAPACE><your%20OTP>%20and%20send%20to%209220092200&v1.1&userid=2000179599&password=VxGGyDQuL&send_to="
							+ u.getContactNumber()
							+ "&msg_type=text&method=sendMessage")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("asdfasdfasfd");
			System.out.println(stringBuffer.toString());
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	public String wrongNoSms(String nos) {
		try {

			System.out.println("hello");

			HttpURLConnection conn = (HttpURLConnection) new URL(
					"http://enterprise.smsgupshup.com/GatewayAPI/rest?msg=Please%20send%20your%20OTP%20from%20registered%20Number&v1.1&userid=2000179599&password=VxGGyDQuL&send_to="
							+ nos + "&msg_type=text&method=sendMessage")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("asdfasdfasfd");
			System.out.println(stringBuffer.toString());
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	public String wrongOTP(String nos) {
		try {

			System.out.println("hello");

			HttpURLConnection conn = (HttpURLConnection) new URL(
					"http://enterprise.smsgupshup.com/GatewayAPI/rest?msg=Wrong%20OTP&v1.1&userid=2000179599&password=VxGGyDQuL&send_to="
							+ nos + "&msg_type=text&method=sendMessage")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("asdfasdfasfd");
			System.out.println(stringBuffer.toString());
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	public static void main(String[] args) {
		try {

			System.out.println("hello");

			HttpURLConnection conn = (HttpURLConnection) new URL(
					"http://enterprise.smsgupshup.com/GatewayAPI/rest?msg=Hi%20"
							+ "Anurag"
							+ "%20!!%20Your%20OTP%20is%20"
							+ "123123"
							+ "%20.%20To%20response%20for%20this%20OTP%20type%20Jagtheraho<SAPACE><your%20OTP>%20and%20send%20to9220092200&v1.1&userid=2000179599&password=VxGGyDQuL&send_to="
							+ "8171908867"
							+ "&msg_type=text&method=sendMessage")
					.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println(stringBuffer.toString().substring(0, 5));
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
		}
	}
}
