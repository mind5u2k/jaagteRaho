package com.ghosh.jaagteyRaho.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class PushNotifictionHelper {

	public final static String AUTH_KEY_FCM = "AAAA_dzN42U:APA91bFIdmX2cdFlywBjyrYVYt3LddyHmWK2mUByNt6UJi6krDU4_uFXih_Gu_MnNPwwXm54n0ykRouU_8DhRQ_tfO-p8aR8dZgJmz3SdRyqiLQVsAiVWTSMrQ6HFmIrWhRU-_wK9D5x";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	public static String sendPushNotification(String deviceToken, String otp)
			throws IOException {
		String result = "";
		URL url = new URL(API_URL_FCM);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();

		json.put("to", deviceToken.trim());
		JSONObject info = new JSONObject();
		info.put("title", "sale kutte"); // Notification title
		info.put("body", "OTP - " + otp); // Notification
		// body
		json.put("notification", info);
		try {
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "Failuer";
		}
		System.out.println("GCM Notification is sent successfully");

		return result;
	}

	public static void main(String[] args) {
		PushNotifictionHelper helper = new PushNotifictionHelper();

		for (int i = 0; i < 2000; i++) {
			try {
				helper.sendPushNotification(
						"dmUaxznGXcY:APA91bF5BWqMz1SPQN8qcgv5A0IIh2bD2ot0z-P3hZZJKZ94h4mBg8McI0X2__F-LGS0UIspa8waMVnBZCVBNrczrAr-Qe2Czx45A9RM2GXrX3O4ZvJawsmXc4uCCVTDiREUEvUBJkJq",
						"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}