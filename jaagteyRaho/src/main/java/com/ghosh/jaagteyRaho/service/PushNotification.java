package com.ghosh.jaagteyRaho.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Notification;

public class PushNotification {

	public void initializePushNotification() throws IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(
				"jaagte-raho-firebase-adminsdk-bzukw-c6db723468.json")
				.getFile());

		FileInputStream serviceAccount = new FileInputStream(file);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://jaagte-raho.firebaseio.com").build();

		FirebaseApp.initializeApp(options);
		 
	}

	public static void main(String[] args) {
		PushNotification notification = new PushNotification();
		try {
			notification.initializePushNotification();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
