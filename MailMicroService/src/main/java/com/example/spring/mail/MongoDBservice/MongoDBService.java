package com.example.spring.mail.MongoDBservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.mail.bean.Mailinfo;
import com.example.spring.mail.repository.IMongoRepository;


@Service
public class MongoDBService implements IMongoDBService{
	
	
	private final IMongoRepository mailInfoRepository;
	
	
	@Autowired
	MongoDBService(IMongoRepository repository) {
        this.mailInfoRepository = repository;
    }
	

	
	public Mailinfo findByMailForStatus(String mailForStatus) {
		
	     List<Mailinfo> mailinfoList=mailInfoRepository.findAll();
	     Mailinfo returnMailinfo=null;
		
		 for(Mailinfo mailinfo: mailinfoList){
			if(mailinfo.getMailForStatus().equalsIgnoreCase(mailForStatus)) {
				
				returnMailinfo= mailinfo;
				
			}
			 
			 
		 }
		return returnMailinfo;
		
	}


	

}
