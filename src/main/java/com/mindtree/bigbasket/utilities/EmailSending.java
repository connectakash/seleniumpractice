package com.mindtree.bigbasket.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSending {

	public static void sendEmail(final String mailId,final String password) {
		
		
		String fromEmail=mailId;
		String toEmail="dd07091998@gmail.com";
		
		
		
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props,
				 
				new javax.mail.Authenticator() {
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication(mailId, password);
 
					}
 
				});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Extent Report");
			Multipart econtent=new MimeMultipart();
			
			MimeBodyPart textbody = new MimeBodyPart();
			
			textbody.setText("Hello\n"+"This my extent report on Bigbasket automation test generated");
			
			MimeBodyPart attachment=new MimeBodyPart();
			
			attachment.attachFile(System.getProperty("user.dir")+"/reports/"+ExtentUtility.fileLoc);
			
			econtent.addBodyPart(textbody);
			econtent.addBodyPart(attachment);
			
			msg.setContent(econtent);
			
			Transport.send(msg);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
