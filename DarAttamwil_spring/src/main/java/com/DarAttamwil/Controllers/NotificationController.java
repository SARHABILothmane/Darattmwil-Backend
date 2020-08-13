package com.DarAttamwil.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Services.IserviceClient;
import com.DarAttamwil.Services.IserviceNotification;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NotificationController {
@Autowired 
private IserviceNotification serviceNotification;
@Autowired
private IserviceClient serviceClient;
@PostMapping("/sendmail/{id}")
public void sendMail(@PathVariable("id") int id
		             ,@RequestParam("subject") String subject
		             ,@RequestParam("html") String html) {
	Clients client = serviceClient.selectByIdClient(id).get();
	String mail = client.getEmail();
	serviceNotification.sendEmail(mail, subject, html);
}
}
