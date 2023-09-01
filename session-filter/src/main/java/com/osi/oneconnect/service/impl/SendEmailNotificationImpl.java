package com.osi.oneconnect.service.impl;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.osi.oneconnect.config.MailConfig;
import com.osi.oneconnect.dto.EmailDTO;
import com.osi.oneconnect.service.ISendEmailNotificationService;

@Service
public class SendEmailNotificationImpl implements ISendEmailNotificationService {

	private static final String SUBJECT = "subject";
	
	@Autowired
	private MailConfig mailConfig;
	
	@Value("${spring.mail.username}")
	private String fromMail;

	@Autowired
	private VelocityEngine velocityEngine;

	
	public void send(EmailDTO email) throws Exception {
		
		if (email.isHtml()==true) {
			try {
				sendHtmlMail(email);
			} catch (MessagingException | UnsupportedEncodingException e) {
				throw new Exception("Could not send email" +e.getMessage());
			}
		} else {
			sendPlainTextMail(email);
		}
	}
	
	private void sendHtmlMail( EmailDTO email) throws MessagingException, UnsupportedEncodingException {
		boolean isHtml = true;
		JavaMailSender mailSender = mailConfig.javaMailSender();
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email.getTo());
		helper.setReplyTo(fromMail);
		helper.setFrom(new InternetAddress(fromMail));
		helper.setSubject("Status of Sessions ");
		Map<String,List<String>> map= new HashMap<String,List<String>>();
		//here we are setting username as Hi Username;
		map.put("username", Arrays.asList(email.getEmpName()));
		map.put("attendedList",email.getAttendedList());
		map.put("pendingList",email.getPendingList());
		if(email.getMessage() !=null) {
			map.put("msg",Arrays.asList(email.getMessage()));
		}else {
			map.put("msg",Arrays.asList("NoMesg"));
		}
		
		Template template = velocityEngine.getTemplate("mailtemp.vm");
        VelocityContext velocityContext = new VelocityContext(map);
        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
        String emailContent = writer.toString();

        message.setContent(emailContent, "text/html; charset=utf-8");
		
		if (email.getCc() != null) {
			helper.setCc(email.getCc().toArray(new String[email.getCc().size()]));
		}
		mailSender.send(message);
	}
	
	private void sendPlainTextMail(EmailDTO eParams) {
		JavaMailSender mailSender = mailConfig.javaMailSender();
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		eParams.getTo();
		mailMessage.setTo(eParams.getTo());
		mailMessage.setReplyTo(fromMail);
		mailMessage.setFrom(fromMail);
		mailMessage.setSubject(eParams.getSubject());
		if (eParams.getMessage() != null) {
		mailMessage.setText(eParams.getMessage());
		}
		if (eParams.getCc() != null) {
			mailMessage.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
		}
		 
		mailSender.send(mailMessage);
	}
}
