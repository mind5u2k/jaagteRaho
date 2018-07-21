package com.ghosh.jaagteyRaho.service.MailNotificationServices;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailNotification {

	private static String username = "anurag.ghosh.1014@gmail.com";
	private static String password = "asdf";

	public static boolean sendMail(String to, String cc, String bcc,
			String subject, String messageText) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");// us2.imap.mailhostbox.com
		props.put("mail.smtp.port", "587");// 143

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			Message msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to, false));
			msg.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(cc, false));
			msg.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(bcc, false));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(messageText, "text/html");

			Transport.send(msg);

			System.out.println("Done");
			return true;

		} catch (Exception e) {
			System.out.println("exception occurs [" + e + "]");
			return false;
		}
	}

	public static void main(String[] args) {
		MailNotification.sendMail("anurag.ghosh.1014@gmail.com", "", "",
				"hello there ! this is subject",
				"hello there ! this is mail body");
	}
}
