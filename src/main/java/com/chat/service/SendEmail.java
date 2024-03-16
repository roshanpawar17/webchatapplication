package com.chat.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendEmail {
	public boolean sendMail(String emailTo,String msg, String sub  ) {
		
		boolean s=false;
		
		String from="roshanp1712@gmail.com";
		String password="oxxiunlfgohktnoa";
		
		Properties properties=System.getProperties();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from,password);
            }
        });
		
		MimeMessage m=new MimeMessage(session);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			m.setSubject(sub);
			m.setText(msg);

			Transport.send(m);
			s=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
}
