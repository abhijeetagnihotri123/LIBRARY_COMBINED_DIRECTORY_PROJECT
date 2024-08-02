package com.NepTune.lib.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String ISBN_NUMBER;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String isIssued;
	
	public Book() {
		super();
	}

	public Book(String iSBN_NUMBER, String title, String author, String isIssued) {
		super();
		ISBN_NUMBER = iSBN_NUMBER;
		this.title = title;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getISBN_NUMBER() {
		return ISBN_NUMBER;
	}

	public void setISBN_NUMBER(String iSBN_NUMBER) {
		ISBN_NUMBER = iSBN_NUMBER;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(String isIssued) {
		this.isIssued = isIssued;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN_NUMBER=" + ISBN_NUMBER + ", Title=" + title + ", author=" + author
				+ ", isIssued=" + isIssued + "]";
	}
	
	
	
	
}
