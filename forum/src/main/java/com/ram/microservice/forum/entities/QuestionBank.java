package com.ram.microservice.forum.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

/*@Entity
@Table(name = "EP_QUESTION_BANK")*/
@Document(collection="question_bank")
public class QuestionBank {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	// @SequenceGenerator(name="bankidgenerator",sequenceName="QBANKID_SQ",allocationSize=1)
	//@Column(name = "qbank_id")
	private long qBankID;
	//@Column(name = "qbank_name")
	private String qBankName;
	//@Column(name = "qbank_count")
	private int qBankCount;


	@Transient
	private MultipartFile qbankFile;

	public QuestionBank(String qBankName) {
		this.qBankName = qBankName;
	}

	public long getQBankID() {
		return qBankID;
	}

	public String getQBankName() {
		return qBankName;
	}

	public void setQBankName(String qBankName) {
		this.qBankName = qBankName;
	}

	public int getQBankCount() {
		return qBankCount;
	}

	public void setQBankCount(int qBankCount) {
		this.qBankCount = qBankCount;
	}

	public MultipartFile getQbankFile() {
		return qbankFile;
	}

	public void setQbankFile(MultipartFile qbankFile) {
		this.qbankFile = qbankFile;
	}

}
