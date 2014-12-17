package com.examprep.entities;

public class QuestionBank {

	private long qBankID;
	private String qBankName;
	private int qBankCount;
	
	public QuestionBank(String qBankName)
	{
		this.qBankName=qBankName;
	}
	
	public long getqBankID() {
		return qBankID;
	}

	public String getqBankName() {
		return qBankName;
	}

	public void setqBankName(String qBankName) {
		this.qBankName = qBankName;
	}

	public int getqBankCount() {
		return qBankCount;
	}

	public void setqBankCount(int qBankCount) {
		this.qBankCount = qBankCount;
	}
	
}
