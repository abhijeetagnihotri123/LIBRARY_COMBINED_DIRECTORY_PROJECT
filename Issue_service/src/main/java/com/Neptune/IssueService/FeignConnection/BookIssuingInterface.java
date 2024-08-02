package com.Neptune.IssueService.FeignConnection;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Neptune.IssueService.entity.BookWrapper;


@FeignClient("LIB")
public interface BookIssuingInterface {

	@PostMapping("LibraryBooks/title/{title}")
	public ResponseEntity<BookWrapper>getBookWrappersBasedOnTitle(@PathVariable("title") String title);
	
	@GetMapping("LibraryBooks/sampleEndPoint")
	public ResponseEntity<String>getSuccessMessage();
	
	@PostMapping("LibraryBooks/ISBN_NUMBER/{ISBN_NUMBER}")
	public ResponseEntity<String>returnBookBasedOnISBN_NUMBER(@PathVariable("ISBN_NUMBER") String ISBN_Number);
	
}
