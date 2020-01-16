package com.nit.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public void sendMail(String to,String sub,String text) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(sub);
		msg.setText(text);
		mailsender.send(msg);
	}

}
