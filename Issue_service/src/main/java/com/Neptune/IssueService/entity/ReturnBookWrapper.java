package com.Neptune.IssueService.entity;

public class ReturnBookWrapper {
	
	private int id;
	private String isbnnumber;
	
	public ReturnBookWrapper()
	{
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbnnumber() {
		return isbnnumber;
	}

	public void setIsbnnumber(String isbnnumber) {
		this.isbnnumber = isbnnumber;
	}

	@Override
	public String toString() {
		return "ReturnBookWrapper [id=" + id + ", isbnnumber=" + isbnnumber + "]";
	}
	
}
