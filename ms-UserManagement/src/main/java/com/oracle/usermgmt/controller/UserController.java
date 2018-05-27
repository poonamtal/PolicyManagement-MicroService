package com.oracle.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.usermgmt.kafka.Sender;
import com.oracle.usermgmt.model.GenricMailInfo;
import com.oracle.usermgmt.model.User;
import com.oracle.usermgmt.model.UserDetails;
import com.oracle.usermgmt.repository.UserDetailsRepository;
import com.oracle.usermgmt.repository.UserManagementRepository;

@RestController
public class UserController {
	
	
    @Autowired
	UserManagementRepository usermgmtrepo;
    
    @Autowired
    UserDetailsRepository userdetrepo;
    
    @Value("${spring.kafka.topic.userRegistered}")
    private String USER_CREATED_TOPIC;

    @Autowired
    Sender sender;
    @Autowired
    GenricMailInfo mailinfo;
   
    

	@RequestMapping(value = "/validateusercreds", method = RequestMethod.POST)
	public Boolean validateUserCreds(@RequestBody User user) {

		User retUser = usermgmtrepo.findByuserid(user.getUserid());		
		if (retUser == null) {
			return false;
		} else {

			if ((retUser.getUserid().equals(user.getUserid())) && 
				(retUser.getPassword().equals(user.getPassword()))) {
				return true;

			} else {
				return false;
			}
		}
	}
	
/*	@RequestMapping(value = "/registeruser", method=RequestMethod.POST)
	public String registerUser(@RequestBody UserDetails userDetails) {
		try {
			userdetrepo.save(userDetails);
			User user= new User();
			user.setUserid(userDetails.getUserId());
			user.setPassword(userDetails.getPassword());
			usermgmtrepo.save(user);
			
		}catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
		return "SUCCESS";
	}
	*/
	@RequestMapping(value = "/registeruser", method=RequestMethod.POST)
	public String registerUser(@RequestBody UserDetails userDetails) {
		try {
			userdetrepo.save(userDetails);
			User user= new User();
			user.setUserid(userDetails.getUserId());
			user.setPassword(userDetails.getPassword());
			usermgmtrepo.save(user);

			mailinfo.setSendTo(userDetails.getEmailId());
			mailinfo.setSubject("Policy User Registration Successfull");
			mailinfo.setContent("Your have been successfully reistered");
			sender.send(USER_CREATED_TOPIC, mailinfo);
		}catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
		return "SUCCESS";
	}


}
