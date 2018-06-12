package com.ghosh.jaagteyRaho.service.msgService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSms {
	public String sendSms(String nos) {
		try {

			System.out.println("hello");
			String apiKey = "apikey="
					+ "wcL+7qODu9E-MjFusywZMom2yP5Gad6YoD0EpjUMOw";

			String message = "&message="
					+ "Hi Navnit !! what's up ? call me once you free";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + nos;
			HttpURLConnection conn = (HttpURLConnection) new URL(
					"https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length",
					Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("asdfasdfasfd");
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	public static void main(String[] args) {
		SendSms sendSms = new SendSms();
	}
}
