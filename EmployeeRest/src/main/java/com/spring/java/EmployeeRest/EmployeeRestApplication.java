package com.spring.java.EmployeeRest;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApplication.class, args);
		
		//String message = "Hello , Dear, this is message for security check . ";
		
		System.out.println("preparing to send message ...");
		String message = "Hello , I am checking all mails and send you back ";
		String subject = "TestMessage : Confirmation";
		String to = "marut.kumar34@gmail.com";
		String from = "vinodsinghchauhan777@gmail.com";
		
		sendEmail(message,subject,to,from);
	}



private static void sendEmail(String message, String subject, String to, String from) {
	
	//Variable for gmail
	String host="smtp.gmail.com";
	
	//get the system properties
	Properties properties = System.getProperties();
	System.out.println("PROPERTIES "+properties);
	
	//setting important information to properties object
	
	//host set
	properties.put("mail.smtp.host", host);
	properties.put("mail.smtp.port","465");
	properties.put("mail.smtp.ssl.enable","true");
	properties.put("mail.smtp.auth","true");
	
	//Step 1: to get the session object..
	Session session=Session.getInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {				
			return new PasswordAuthentication("vinodsinghchauhan777@gmail.com", "cfua mbkh cnrf cmuu");
		}
		
		
		
	});
	
	session.setDebug(true);
	
	//Step 2 : compose the message [text,multi media]
	MimeMessage m = new MimeMessage(session);
	
	try {
	
	//from email
	m.setFrom(from);
	
	//adding recipient to message
	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
	//adding subject to message
	m.setSubject(subject);

	
	//adding text to message
	m.setText(message);
	
	//send 
	
	//Step 3 : send the message using Transport class
	Transport.send(m);
	
	System.out.println("Sent success...................");
	
	
	}catch (Exception e) {
		e.printStackTrace();
	}
		
}
}