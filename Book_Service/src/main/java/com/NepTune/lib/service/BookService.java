package com.NepTune.lib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.NepTune.lib.entities.Book;
import com.NepTune.lib.entities.BookWrapper;
import com.NepTune.lib.repositories.BookRepository;
import com.NepTune.lib.constants.ConstantValues;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public ResponseEntity<List<Book>>getAllBooks()
	{
		ResponseEntity<List<Book>> result = null;
		
		try
		{
			result = new ResponseEntity<>(bookRepository.findAll() , HttpStatus.OK);
		}
		catch(Exception e)
		{	
			e.printStackTrace();
			result = new ResponseEntity<>(new ArrayList() , HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	
	public ResponseEntity<List<Book>>getBooksByTitle(String title)
	{
		ResponseEntity<List<Book>> result = null;
		
		try
		{
			result = new ResponseEntity<>(bookRepository.findByTitle(title), HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = new ResponseEntity<>(new ArrayList() , HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}
	
	/*
	 * 
	 * controllers
	 * issuing service
	 * development pipeline
	 * 
	 * */
	
	public void addBookInLibrary(Book book)
	{
		try
		{
			bookRepository.save(book);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void removeBookFromLibrary(int id)
	{
		try
		{
			bookRepository.deleteById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResponseEntity<BookWrapper> getBookWrappersByTitle(String title) {
		// TODO Auto-generated method stub
		
		ResponseEntity<BookWrapper> result = null;
		
		try
		{
			List<Book>books = bookRepository.findByTitle(title);
			
			BookWrapper bookWrapper = null;
			
			for(Book book : books)
			{
				if(book.getIsIssued().equals(ConstantValues.BOOK_NOT_ISSUED))
				{
					bookWrapper = new BookWrapper(book.getTitle() , book.getISBN_NUMBER());
					book.setIsIssued(ConstantValues.BOOK_ISSUED);
					bookRepository.save(book);
					break;
				}
			}
			
			if(bookWrapper == null)
			{
				bookWrapper = new BookWrapper();
			}
			
			result = new ResponseEntity<>(bookWrapper, HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result = new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
		}
		
		return result;
		
	}

	public ResponseEntity<String> returnBookBasedOnISBN_NUMBER(String iSBN_Number) {
		// TODO Auto-generated method stub
		// 978-0-7434-1899
		ResponseEntity<String> result = null;
		
		try
		{
			List<Book>books = bookRepository.findAll();
			
			for(Book book : books)
			{
				if(book.getISBN_NUMBER().equals(iSBN_Number))
				{
					book.setIsIssued(ConstantValues.BOOK_NOT_ISSUED);
					bookRepository.save(book);
					break;
				}
			}
			
			result = new ResponseEntity<>(ConstantValues.BOOK_RETURNED_MESSAGE , HttpStatus.OK);
		}
		catch(Exception e)
		{
			result = new ResponseEntity<>(ConstantValues.SOME_ERROR , HttpStatus.BAD_GATEWAY);
			e.printStackTrace();
		}
		return result;
	}
}
