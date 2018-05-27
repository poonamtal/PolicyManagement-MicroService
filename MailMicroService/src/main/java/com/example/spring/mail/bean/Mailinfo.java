package com.example.spring.mail.bean;

import org.springframework.data.annotation.Id;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "Mailinfo")
public class Mailinfo {

	public Mailinfo(String id,String sendTo, String fromID, String mailSubject, String mailContent,
			String mailForStatus) {
		super();
		this.id=id;
		this.sendTo = sendTo;
		this.fromID = fromID;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
		this.mailForStatus = mailForStatus;
	}
	
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String Id) {
		this.id = Id;
	}
	
	 
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getFromID() {
		return fromID;
	}
	public void setFromID(String fromID) {
		this.fromID = fromID;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public String getMailForStatus() {
		return mailForStatus;
	}
	public void setMailForStatus(String mailForStatus) {
		this.mailForStatus = mailForStatus;
	}

	@Field(value="SendTo")
	private String sendTo;

	@Field(value="FromID")
	private String fromID;

	@Field(value="MailSubject")
	private String mailSubject;

	@Field(value="MailContent")
	private String mailContent;
	
	@Field(value="MailForStatus")
	private String mailForStatus;
	
	
	
	
}
