package com.example.spring.mail.bean;

import org.springframework.stereotype.Component;

@Component
public class GenricMailInfo {
	String sendTo;
	String Subject;
	String Content;
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
