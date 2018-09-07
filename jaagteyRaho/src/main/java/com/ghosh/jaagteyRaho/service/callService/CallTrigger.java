package com.ghosh.jaagteyRaho.service.callService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

public class CallTrigger {

	public void sendCall(List<String> numbers) throws HttpException,
			IOException {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(
				"http://enterprise.smsgupshup.com/GatewayAPI/rest");
		ClassLoader classLoader = getClass().getClassLoader();
		File voice = new File(classLoader.getResource("sample.mp3").getFile());
		String strNumbers = "";
		for (String n : numbers) {
			strNumbers = strNumbers + "," + n;
		}
		Part[] parts = { new StringPart("method", "VOICE_POST_CAMPAIGN"),
				new StringPart("userid", "2000179599"),
				new StringPart("password", "VxGGyDQuL"),
				new StringPart("contactsType", "LIST"),
				new StringPart("contactsList", strNumbers),
				new StringPart("audioType", "FILE"),
				new FilePart("audioFile", voice),
				new StringPart("format", "json"), new StringPart("v", "1.1"),
				new StringPart("auth_scheme", "PLAIN"), };
		method.setRequestEntity(new MultipartRequestEntity(parts, method
				.getParams()));
		int statusCode = client.executeMethod(method);
		System.out.println("--------------" + statusCode);
	}

	private static void generateCsvFile(String fileName) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			writer.append("Name");
			writer.append(',');
			writer.append("Number");
			System.out.println("CSV file is created...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(
				"http://enterprise.smsgupshup.com/GatewayAPI/rest");

		File voice = new File("C://sample.mp3");

		Part[] parts = { new StringPart("method", "VOICE_POST_CAMPAIGN"),
				new StringPart("userid", "2000179599"),
				new StringPart("password", "VxGGyDQuL"),
				new StringPart("contactsType", "LIST"),
				new StringPart("contactsList", "8171908867,9554163150"),
				new StringPart("audioType", "FILE"),
				new FilePart("audioFile", voice),
				new StringPart("format", "json"), new StringPart("v", "1.1"),
				new StringPart("auth_scheme", "PLAIN"), };
		method.setRequestEntity(new MultipartRequestEntity(parts, method
				.getParams()));
		int statusCode = client.executeMethod(method);
		System.out.println("--------------" + statusCode);

	}

}
