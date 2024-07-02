package com.RoomService.RoomService.Producerconfig;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class ProducerConfig {

	
	   @Bean
	    public ActiveMQConnectionFactory senderActiveMQConnectionFactory() {
	      ActiveMQConnectionFactory activeMQConnectionFactory =
	          new ActiveMQConnectionFactory();
	      activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");

	      return activeMQConnectionFactory;
	    }

	    @Bean
	    public CachingConnectionFactory cachingConnectionFactory() {
	      return new CachingConnectionFactory(
	          senderActiveMQConnectionFactory());
	    }

	    @Bean
	    public JmsTemplate jmsTemplate() {
	        return new JmsTemplate(cachingConnectionFactory());
	    }
	    
	    
	  
}
