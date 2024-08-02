package com.Neptune.IssueService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * id, name,title,isbn_number of book
 * 
 * 
 */

@Entity
@Table
public class IssuerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String bookTitle;
	
	@Column
	private String bookISBNNumber;
	
	IssuerEntity(){
		super();
	}

	public IssuerEntity(String name, String bookTitle, String bookISBNNumber) {
		super();
		this.name = name;
		this.bookTitle = bookTitle;
		this.bookISBNNumber = bookISBNNumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookISBNNumber() {
		return bookISBNNumber;
	}

	public void setBookISBNNumber(String bookISBNNumber) {
		this.bookISBNNumber = bookISBNNumber;
	}

	@Override
	public String toString() {
		return "IssuerEntity [id=" + id + ", name=" + name + ", bookTitle=" + bookTitle + ", bookISBNNumber="
				+ bookISBNNumber + "]";
	}

	
	
	
}
