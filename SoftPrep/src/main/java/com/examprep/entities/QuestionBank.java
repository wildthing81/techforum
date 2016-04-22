package com.examprep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="EP_QUESTION_BANK")
public class QuestionBank {
    
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bankidgenerator")
        @SequenceGenerator(name="bankidgenerator",sequenceName="QBANKID_SQ",allocationSize=1)
        @Column(name="qbank_id")
	private long qBankID;
        @Column(name="qbank_name")
	private String qBankName;
        @Column(name="qbank_count")
	private int qBankCount;
        @Transient
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
