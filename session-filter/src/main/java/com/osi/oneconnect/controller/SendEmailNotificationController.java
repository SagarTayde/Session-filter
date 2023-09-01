package com.osi.oneconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osi.oneconnect.dto.EmailDTO;
import com.osi.oneconnect.service.impl.SendEmailNotificationImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/send-mail-notification")
@Slf4j
@CrossOrigin(value = "*")
public class SendEmailNotificationController {

	@Autowired
	private SendEmailNotificationImpl sendEmailNotificationImpl;
	
	@PostMapping("/sendmail")
	public ResponseEntity<String> sendEmail(@RequestBody EmailDTO email ) throws Exception {
		sendEmailNotificationImpl.send(email);
		return ResponseEntity.ok("mail send successfully........!!");
	}
}
