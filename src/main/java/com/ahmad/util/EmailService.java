package com.ahmad.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender sender;

	@Value("${com.ahmad.util.EmailService.email.subject}")
	private String EMAIL_SUBJECT;

	@Value("${com.ahmad.util.EmailService.email.body}")
	private String EMAIL_BODY;

	public void welcomeEmail(String to) {

		MimeMessage massage = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(massage, true);
			messageHelper.setTo(to);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			sender.send(massage);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}

}
