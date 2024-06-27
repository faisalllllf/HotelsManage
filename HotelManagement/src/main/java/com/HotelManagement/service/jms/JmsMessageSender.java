<<<<<<< HEAD
<<<<<<< HEAD
package com.HotelManagement.service.jms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.RoomRequest;

@Service
public class JmsMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(RoomRequest detailsWithImageBean) {
    	System.out.println("sending message to consumer");
        jmsTemplate.convertAndSend("AddRooms", detailsWithImageBean);
        
    }
=======
package com.HotelManagement.service.jms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.RoomRequest;

@Service
public class JmsMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(RoomRequest detailsWithImageBean) {
    	System.out.println("sending message to consumer");
        jmsTemplate.convertAndSend("AddRooms", detailsWithImageBean);
        
    }
>>>>>>> 26f4154 (lll)
=======
package com.HotelManagement.service.jms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.RoomRequest;

@Service
public class JmsMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(RoomRequest detailsWithImageBean) {
    	System.out.println("sending message to consumer");
        jmsTemplate.convertAndSend("AddRooms", detailsWithImageBean);
        
    }
<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
}