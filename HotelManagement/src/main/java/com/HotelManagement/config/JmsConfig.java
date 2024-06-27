<<<<<<< HEAD
package com.HotelManagement.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

  /*  @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

  */  
    
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
=======
package com.HotelManagement.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

  /*  @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

  */  
    
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
>>>>>>> 8e11644 (First Commit)
