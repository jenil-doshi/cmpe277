package com.sjsu.cmpe277.configuration;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.util.Constants;

@Component
public class EmailUtility {

	@Autowired
	private Environment environment;

	public void sendEmail(String oldPostingStatus, Posting newPosting, String status) {

		String subject = null;
		String body = null;
		final String userId = "cmpe277airbnb@gmail.com";
		final String password = "termproject";
		final String emailId = newPosting.getEmail();
		Properties props = new Properties();
		props.put(Constants.SMTP_AUTH, Constants.VALUE_TRUE);
		props.put(Constants.STARTTLS_ENABLE, Constants.VALUE_TRUE);
		props.put(Constants.SMTP_HOST, Constants.SMTP_HOST_VALUE);
		props.put(Constants.PORT, Constants.PORT_VALUE);
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		if(status.endsWith("New")){
			subject = Constants.NEW_POST_EMAIL_SUBJECT;
			body = "Dear "+ newPosting.getOwnerName()+"," + "\n\n This is a Notification email: "
					+ " \n\n A new post has been added. Please find the details below:- "
					+ "\n\n Post Name: " + newPosting.getPostingName()
					+ "\n Owner Name: " + newPosting.getOwnerName()
					+ "\n Post Status: " + newPosting.getStatus()
					+ "\n Property Type: " + newPosting.getPropertyType()
					+ "\n\n Regards, "
					+ "\n Team Cmpe 277";
		}
		else{
			subject = Constants.UPDATE_POST_EMAIL_SUBJECT;
			body = "Dear "+ newPosting.getOwnerName()+"," + "\n\n This is a Notification email: "
					+ " \n\n Status of the Post has been changed. Please find the details below for the post:- "
					+ "\n\n Post Name: " + newPosting.getPostingName()
					+ "\n Owner Name: " + newPosting.getOwnerName()
					+ "\n old Post Status: " + oldPostingStatus
					+ "\n New Post Status: " + newPosting.getStatus()
					+ "\n Property Type: " + newPosting.getPropertyType()
					+ "\n\n Regards, "
					+ "\n Team Cmpe 277";
		}
			
		
		
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userId, password);
			}
		});
		try {
			if (isValidEmailAddress(emailId)) {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userId));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));

				message.setSubject(subject);
				message.setText(body);

				Transport.send(message);
			} else {
			}
		} catch (MessagingException e) {
			System.out.println("Messaging Exception");
			e.printStackTrace();
		}
	}

	private static boolean isValidEmailAddress(String emailId) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(emailId);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

}
