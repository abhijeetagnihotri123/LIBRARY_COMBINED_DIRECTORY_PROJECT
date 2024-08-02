package com.NepTune.lib.entities;

import com.NepTune.lib.constants.ConstantValues;

public class BookWrapper {
	
	private String BookTitle;
	private String BookISBN_Number;
	
	public BookWrapper()
	{
		this(ConstantValues.UNDEFINED_BOOK_ISSUED_TITLE , ConstantValues.UNDEFINED_BOOK_ISSUED_ISBN_NUMBER);	
	}
	
	public BookWrapper(String bookTitle , String bookISBN_Number)
	{
		super();
		this.BookTitle = bookTitle;
		this.BookISBN_Number = bookISBN_Number;
	}
	
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getBookISBN_Number() {
		return BookISBN_Number;
	}
	public void setBookISBN_Number(String bookISBN_Number) {
		BookISBN_Number = bookISBN_Number;
	}
	
	
	
}
