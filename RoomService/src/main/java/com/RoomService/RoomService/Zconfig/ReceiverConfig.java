package com.RoomService.RoomService.Zconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.ErrorHandler;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class ReceiverConfig {

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("5-10");
		
		factory.setErrorHandler(myErrorHandler());
		return factory;
	}
	

	
	
	 @Bean
	    public ErrorHandler myErrorHandler() {
	        return t -> {
	            System.out.println("In error handler");
	            t.printStackTrace();
	        };
	    }
  

}
