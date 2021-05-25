package com.mph.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The Class MailHelper.
 */
public class MailHelper {

	/**
	 * Send mail.
	 * 
	 * @author NavyaSree
	 * @param toMailId This param includes the mail id to which the information of
	 *                 their loan request has to be sent
	 * @param result   This param includes the message to be displayed in the mail
	 */
	public void sendMail(String toMailId, String result) {

		// Recipient's email ID needs to be mentioned.

		// Sender's email ID needs to be mentioned
		String from = "divya11223026@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		String pwd = "navya3026";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, pwd);

			}

		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMailId));

			// Set Subject: header field
			message.setSubject("Information About Your Loan Application");

			// Now set the actual message
			message.setText("" + result);

			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}
