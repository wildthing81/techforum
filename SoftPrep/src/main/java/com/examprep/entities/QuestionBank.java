package main.java.com.examprep.entities;

public class QuestionBank {

	private long qBankID;
	private String qBankName;
	
	public QuestionBank(String qBankName)
	{
		this.qBankName=qBankName;
	}
	
	public String getQuestionBankName() {
		return qBankName;
	}
	public void setQuestionBankName(String questionBankName) {
		this.qBankName = questionBankName;
	}
	public long getqBankID() {
		return qBankID;
	}
	
}
