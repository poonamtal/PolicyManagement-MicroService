package com.example.spring.mail.dao;




import com.example.spring.mail.bean.Mailinfo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface IMailDAORepository  extends MongoRepository<Mailinfo, String> {
	
	public Mailinfo getMailInfoByMailForStatus(String mailForStatus);
	
}
