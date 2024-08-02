package com.Neptune.IssueService.entity;

public class IssuerWrapper {
	
	private int id;
	private String title;
	
	public IssuerWrapper() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IssuerWrapper [id=" + id + ", title=" + title + "]";
	}


	
}
