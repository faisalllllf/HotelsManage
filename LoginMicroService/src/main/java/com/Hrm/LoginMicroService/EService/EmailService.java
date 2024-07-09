package com.Hrm.LoginMicroService.EService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendPasswordResetEmail(String recipientEmail, String token) {
		System.out.println("sending mail started");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject("Password Reset Request");
		message.setText("To reset your password, click the link below:\n\n"
				+ "http://localhost:3000/reset-password?token=" + token); // Replace with your frontend reset password
																			// URL
		emailSender.send(message);
		System.out.println("sending mail completed");
	}
}
