package com.Neptune.IssueService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Neptune.IssueService.entity.BookWrapper;
import com.Neptune.IssueService.entity.IssuerWrapper;
import com.Neptune.IssueService.entity.ReturnBookWrapper;
import com.Neptune.IssueService.service.BookIssuingService;

@RestController
@RequestMapping("/LibraryBookIssueService")
public class ServiceController {
	
	@Autowired
	BookIssuingService bookIssuingService;
	
	@PostMapping("/AddUser/{name}")
	public ResponseEntity<String>addIssuerName(@PathVariable("name") String name)
	{
		return bookIssuingService.addIssuerInDB(name);
	}
	
	@PostMapping("/IssueBook")
	public ResponseEntity<BookWrapper>IssueBook(@RequestBody IssuerWrapper issuerWrapper)
	{
		return bookIssuingService.issueBook(issuerWrapper);
	}
	
	@PostMapping("/ReturnBook")
	public ResponseEntity<String>ReturnBook(@RequestBody ReturnBookWrapper returnBookWrapper)
	{
		return bookIssuingService.returnBook(returnBookWrapper);
	}
	
	@GetMapping("/CheckEnpoints")
	public ResponseEntity<String>checkEndpoint()
	{
		return bookIssuingService.checkEndPoint();
	}
	
	@GetMapping("/CheckMailEndPoint")
	public ResponseEntity<String>checkMailEndPoint()
	{	
		return bookIssuingService.checkMailEndPoint();
	}
	
}
