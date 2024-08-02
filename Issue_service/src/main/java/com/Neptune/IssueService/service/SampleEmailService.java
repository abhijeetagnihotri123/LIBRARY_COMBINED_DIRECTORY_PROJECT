package com.Neptune.IssueService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Neptune.IssueService.constants.ConstantValues;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class SampleEmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public ResponseEntity<String> getSuccessMessage()
	{
		ResponseEntity<String> result = null;
		try
		{
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			
			simpleMailMessage.setFrom(ConstantValues.FROM_EMAIL_ADDRESS);
			simpleMailMessage.setTo(ConstantValues.TO_EMAIL_ADDRESS);
			simpleMailMessage.setSubject(ConstantValues.MAIL_SUBJECT);
			simpleMailMessage.setText(ConstantValues.SAMPLE_MESSAGE);
			
			javaMailSender.send(simpleMailMessage);
			result = new ResponseEntity<>("Mail Send" , HttpStatus.OK);
		}
		catch(Exception e)
		{
			result = new ResponseEntity<>("Some problem" , HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	public void sendMail(String toEmail , String subject , String message)
	{
		
		try
		{
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			
			simpleMailMessage.setFrom(ConstantValues.FROM_EMAIL_ADDRESS);
			simpleMailMessage.setTo(toEmail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(message);
			
			javaMailSender.send(simpleMailMessage);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
