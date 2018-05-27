package com.example.spring.mail.MongoDBservice;

import java.util.List;

import com.example.spring.mail.bean.Mailinfo;


public interface IMongoDBService {
	
	
	Mailinfo findByMailForStatus(String mailForStatus);
	
	
	 
}
