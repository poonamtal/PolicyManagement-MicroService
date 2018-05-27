package com.example.spring.mail.kafka;

//import eu.dreamix.ms.entity.dto.UserDto;
//import eu.dreamix.ms.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.spring.mail.MailService_generic;
import com.example.spring.mail.bean.GenricMailInfo;
import com.example.spring.mail.MailService_generic;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.apache.kafka.common.serialization.LongDeserializer;


public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    //private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private MailService_generic emailservice;
    

    /*@KafkaListener(topics = "${spring.kafka.template.default-topic}", containerFactory = "kafkaListenerContainerFactory") 
    public void receive(GenricMailInfo payload)
    {
    	System.out.println("PAYLOAD++++++"+payload);
    }*/
  
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(GenricMailInfo payload) {
    	System.out.println("M here------------");
        LOGGER.info("received payload='{}'", payload);
        emailservice.SendMail(payload.getSendTo(),payload.getSubject(),payload.getContent());
      //  latch.countDown();
    }
}
