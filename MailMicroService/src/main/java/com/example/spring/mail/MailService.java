package com.example.spring.mail;

import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.example.spring.mail.dao.IMailDAORepository;
import com.example.spring.mail.dao.MailInfoDAO;
import com.example.spring.mail.MongoDBservice.MongoDBService;
import com.example.spring.mail.bean.Mailinfo;
import org.springframework.data.mongodb.core.MongoTemplate;


@RestController
public class MailService {
	
	@Autowired
    private JavaMailSender sender;
  	
  	
  	//IMailDAORepository mailInfoDAO;
  	
	public final MongoDBService iMailDAORepository;
  	
	@Autowired
	public MailService(MongoDBService MailDAORepository){
		this.iMailDAORepository=MailDAORepository;
		
		
	}
	
	

	@RequestMapping(value="/sendMail" , method=RequestMethod.GET)
	public String SendMail(@RequestParam(value="status", defaultValue="In Process" ) String status)
	{
		
		System.out.println("This is form Mail Service"+status);
		
		String mailStatus="";
		
		try {
		
		 MimeMessage message = sender.createMimeMessage();
		
	     MimeMessageHelper helper = new MimeMessageHelper(message);
		
	      
	     System.out.println("This is form" );
	     
	     Mailinfo filterMailinfo=iMailDAORepository.findByMailForStatus(status);
	     
	     if(null!=filterMailinfo) {
	    	 
	    	 helper.setFrom(filterMailinfo.getFromID()); 
	    	 
		     helper.setTo(filterMailinfo.getSendTo());
		     
		    // String subject=new StringBuffer("Hi All, /\\n")
			
		    helper.setText(filterMailinfo.getMailSubject() +":current status  " +filterMailinfo.getMailForStatus() );
			
		    helper.setSubject(filterMailinfo.getMailContent()); 
	    	 
	    	 sender.send(message); 
	     }
	     
	      
	    
	    mailStatus= "mail sent"; 
		
		}catch(Exception e) {
			
			System.out.println("Exception occured while sending Mail "+e.getMessage());
			mailStatus= "problem with mail sent";
			
		}
		
		return mailStatus;
	}
	
	
	
	

}
