package com.osi.oneconnect.config;

import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
//@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class MailConfig {

//	private Log logger = LogFactory.getLog(getClass());

	private ResourceBundle bundle = ResourceBundle.getBundle("application");

	@Bean(name = "mailSender")
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		Properties mailProperties = new Properties();
		String auth = bundle.getString("spring.mail.properties.mail.smtp.auth");
		String protocol = bundle.getString("spring.mail.protocol");
		String host = bundle.getString("spring.mail.host");
		String port = bundle.getString("spring.mail.port");
		String starttls = bundle.getString("spring.mail.properties.mail.smtp.starttls.enable");
		String startlls_required = bundle.getString("spring.mail.properties.mail.smtp.starttls.required");
		String username = bundle.getString("spring.mail.username");
		String password = bundle.getString("spring.mail.password");
		String timeout = bundle.getString("spring.mail.properties.mail.smtp.timeout");
		String connectionTimeOut = bundle.getString("spring.mail.properties.mail.smtp.connectiontimeout");
		String tls=bundle.getString("mail.smtp.ssl.protocols");
		//		mailProperties.put("mail.smtp.auth", auth);
		mailProperties.put("mail.smtp.starttls.enable", starttls);
//		mailProperties.put("mail.smtp.starttls.required", startlls_required);
		// mailProperties.put("mail.smtp.socketFactory.port", socketPort);
		// mailProperties.put("mail.smtp.debug", debug);
//		mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// mailProperties.put("mail.smtp.socketFactory.fallback", fallback);
		mailProperties.put("mail.smtp.timeout", timeout);
		mailProperties.put("mail.smtp.ssl.protocols", tls);
		mailProperties.put("mail.smtp.connectiontimeout", connectionTimeOut);

		mailSender.setJavaMailProperties(mailProperties);
		mailSender.setHost(host);
		mailSender.setPort(Integer.parseInt(port));
		mailSender.setProtocol(protocol);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}
}
