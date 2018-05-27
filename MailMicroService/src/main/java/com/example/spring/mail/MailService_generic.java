package com.example.spring.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.spring.mail.MongoDBservice.MongoDBService;

@Component
//@RestController
public class MailService_generic {
	
	@Autowired
    private JavaMailSender sender;
  	
  	
  	//IMailDAORepository mailInfoDAO;
  	
	public final MongoDBService iMailDAORepository;
  	
	@Autowired
	public MailService_generic(MongoDBService MailDAORepository){
		this.iMailDAORepository=MailDAORepository;
		
		
	}
	
	

	//@RequestMapping(value="/sendMail" , method=RequestMethod.GET)
	//public String SendMail(@RequestParam(value="status", defaultValue="In Process" ) String status)
	public String SendMail(String sendTo, String mailSubject,String mailContent)
	{
		
		//System.out.println("This is form Mail Service"+status);
		
		String mailStatus="";
		String fromID ="poonam.talwar@oracle.com";
		try {
		
		 MimeMessage message = sender.createMimeMessage();
		
	     MimeMessageHelper helper = new MimeMessageHelper(message);
		
	      
	     System.out.println("This is form" );
	     
	     //Mailinfo filterMailinfo=iMailDAORepository.findByMailForStatus(status);
	     
	     if(null!=sendTo) {
	    	 
	    	 helper.setFrom(fromID); 
	    	 
		     helper.setTo(sendTo);
		     
		    // String subject=new StringBuffer("Hi All, /\\n")
			
		    helper.setText(mailSubject);
			
		    helper.setSubject(mailContent); 
	    	 
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
