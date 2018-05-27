package com.example.spring.mail.kafka;

//import eu.dreamix.ms.entity.dto.UserDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;



import java.util.HashMap;
import java.util.Map;
import com.example.spring.mail.bean.*;
@Configuration
@EnableKafka
//@PropertySource("classpath:application.yml")
public class ReceiverConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;


    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //props.put(ConsumerConfig.CLIENT_ID_CONFIG, "MailMicroService.client.id");
        //props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "Group1");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    @Bean
    public ConsumerFactory<String, HashMap<String,String>> consumerFactory() {
    	
    	
       /* return new DefaultKafkaConsumerFactory(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(java.util.HashMap.class));*/
    	
    	// return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    	
    	return new DefaultKafkaConsumerFactory(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(GenricMailInfo.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, HashMap<String,String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, HashMap<String,String>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        
        
        return factory;
    }

    

    
    @Bean
    public Receiver receiver() {
    	
    	  
        return new Receiver();
    }
}
