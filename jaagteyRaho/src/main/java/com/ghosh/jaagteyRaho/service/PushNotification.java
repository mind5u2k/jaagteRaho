package com.ghosh.jaagteyRaho.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

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

		FirebaseApp.initializeApp(options); ;

	}

	public static void main(String[] args) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", "key=AIzaSyBSxxxxsXevRq0trDbA9mhnY_2jqMoeChA");

			JSONObject message = new JSONObject();
			message.put("to", "dBbB2BFT-VY:APA91bHrvgfXbZa-K5eg9vVdUkIsHbMxxxxxc8dBAvoH_3ZtaahVVeMXP7Bm0iera5s37ChHmAVh29P8aAVa8HF0I0goZKPYdGT6lNl4MXN0na7xbmvF25c4ZLl0JkCDm_saXb51Vrte");
			message.put("priority", "high");

			JSONObject notification = new JSONObject();
			notification.put("title", "Java");
			notification.put("body", "Notificação do Java");

			message.put("notification", notification);

			post.setEntity(new StringEntity(message.toString(), "UTF-8"));
			HttpResponse response = client.execute(post);
			System.out.println(response);
			System.out.println(message);


			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
