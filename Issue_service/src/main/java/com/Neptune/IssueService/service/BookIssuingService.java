package com.Neptune.IssueService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Neptune.IssueService.entity.BookWrapper;
import com.Neptune.IssueService.entity.IssuerEntity;
import com.Neptune.IssueService.entity.IssuerWrapper;
import com.Neptune.IssueService.entity.ReturnBookWrapper;
import com.Neptune.IssueService.repositories.IssuerEntityRepo;
import com.Neptune.IssueService.FeignConnection.BookIssuingInterface;
import com.Neptune.IssueService.constants.ConstantValues;


@Service
public class BookIssuingService {
	
	@Autowired
	IssuerEntityRepo issuerEntityRepo;
	
	@Autowired
	BookIssuingInterface bookIssuingInterface;
	
	@Autowired
	SampleEmailService sampleEmailService;
	
	public ResponseEntity<String>addIssuerInDB(String name)
	{
		ResponseEntity<String>result = null;
		try
		{
			IssuerEntity issuerEntity = new IssuerEntity(name , ConstantValues.UNDEFINED_BOOK_ISSUED_TITLE , ConstantValues.UNDEFINED_BOOK_ISSUED_ISBN_NUMBER);
			issuerEntityRepo.save(issuerEntity);
			result = new ResponseEntity<>(ConstantValues.RESPONSE_SUCCESS , HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			result = new ResponseEntity<>(ConstantValues.RESPOSNE_FAILURE , HttpStatus.BAD_GATEWAY);
			e.printStackTrace();
		}
		return result;
	}

	public ResponseEntity<BookWrapper> issueBook(IssuerWrapper issuerWrapper) {
		// TODO Auto-generated method stub
		ResponseEntity<BookWrapper> result = null;
		BookWrapper bookWrapper = null;
		
		String title = issuerWrapper.getTitle();
		result = bookIssuingInterface.getBookWrappersBasedOnTitle(title);
		bookWrapper = result.getBody();
		IssuerEntity issuerEntity = issuerEntityRepo.findById(issuerWrapper.getId()).get();
		
		issuerEntity.setBookISBNNumber(bookWrapper.getBookISBN_Number());
		issuerEntity.setBookTitle(bookWrapper.getBookTitle());
		issuerEntityRepo.save(issuerEntity);
		
		//sampleEmailService.sendEmail(ConstantValues.TO_EMAIL_ADDRESS, ConstantValues.MAIL_SUBJECT, message);
		sampleEmailService.sendMail(ConstantValues.TO_EMAIL_ADDRESS, ConstantValues.MAIL_SUBJECT, ConstantValues.ISSUE_SUCCESS_BODY);
		
		return result;
		
	}

	public ResponseEntity<String> returnBook(ReturnBookWrapper returnBookWrapper) {
		
		IssuerEntity issuerEntity = issuerEntityRepo.findById(returnBookWrapper.getId()).get();
		
		issuerEntity.setBookTitle(ConstantValues.UNDEFINED_BOOK_ISSUED_TITLE);
		issuerEntity.setBookISBNNumber(ConstantValues.UNDEFINED_BOOK_ISSUED_ISBN_NUMBER);
		
		issuerEntityRepo.save(issuerEntity);
		//emailSenderService.sendEmail(ConstantValues.TO_EMAIL_ADDRESS, ConstantValues.MAIL_SUBJECT, ConstantValues.RETURN_SUCCESS_BODY);
		sampleEmailService.sendMail(ConstantValues.TO_EMAIL_ADDRESS, ConstantValues.MAIL_SUBJECT, ConstantValues.RETURN_SUCCESS_BODY);
		
		return bookIssuingInterface.returnBookBasedOnISBN_NUMBER(returnBookWrapper.getIsbnnumber());
	}
	
	public ResponseEntity<String> checkEndPoint() {
		// TODO Auto-generated method stub
		return bookIssuingInterface.getSuccessMessage();
	}

	public ResponseEntity<String> checkMailEndPoint() {
		// TODO Auto-generated method stub
		return sampleEmailService.getSuccessMessage();
	}

	
	
}
