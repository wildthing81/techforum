package com.examprep.entities;

import org.springframework.web.multipart.MultipartFile;

public class QuestionBank {

	private long qBankID;
	private String qBankName;
	private int qBankCount;
	private MultipartFile qbankFile;
	
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

	public MultipartFile getQbankFile() {
		return qbankFile;
	}

	public void setQbankFile(MultipartFile qbankFile) {
		this.qbankFile = qbankFile;
	}
	
	
}
