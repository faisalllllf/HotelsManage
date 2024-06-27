<<<<<<< HEAD
<<<<<<< HEAD
package com.HotelManagement.service;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequest;
import com.HotelManagement.dto.RoomRequestForm;

@Service
public class sendmessageJms {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String sendmessagetoRoomService(String msg, RoomRequestForm roomRequestForm) {
		try {

			RoomRequest roomRequest = new RoomRequest();
			roomRequest.setGuestNo(roomRequestForm.getGuestNo());
			roomRequest.setPicByte(roomRequestForm.getPicByte().getBytes());
			roomRequest.setPrice(roomRequestForm.getPrice());
			roomRequest.setRoomDesc(roomRequestForm.getRoomDesc());
			roomRequest.setRoomNo(roomRequestForm.getRoomNo());
			roomRequest.setRoomType(roomRequestForm.getRoomType());

			jmsTemplate.send("messagetoroomservice", session -> {

				System.out.println("sendoing message to jms");
				BytesMessage message = session.createBytesMessage();
				message.setIntProperty("roomNo", roomRequest.getRoomNo());
				message.setStringProperty("roomType", roomRequest.getRoomType());
				message.setIntProperty("guestNo", roomRequest.getGuestNo());
				message.setIntProperty("price", roomRequest.getPrice());
				message.setStringProperty("roomDesc", roomRequest.getRoomDesc());
				
				message.writeBytes(roomRequest.getPicByte());
				System.out.println("message send succesfullt  room servcie");
				return message;
			});

			return "Succesfull";
		} catch (Exception e) {
			return "Upload failed: " + e.getMessage(); // Return error message
		}

	}

}
=======
package com.HotelManagement.service;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequest;
import com.HotelManagement.dto.RoomRequestForm;

@Service
public class sendmessageJms {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String sendmessagetoRoomService(String msg, RoomRequestForm roomRequestForm) {
		try {

			RoomRequest roomRequest = new RoomRequest();
			roomRequest.setGuestNo(roomRequestForm.getGuestNo());
			roomRequest.setPicByte(roomRequestForm.getPicByte().getBytes());
			roomRequest.setPrice(roomRequestForm.getPrice());
			roomRequest.setRoomDesc(roomRequestForm.getRoomDesc());
			roomRequest.setRoomNo(roomRequestForm.getRoomNo());
			roomRequest.setRoomType(roomRequestForm.getRoomType());

			jmsTemplate.send("messagetoroomservice", session -> {

				System.out.println("sendoing message to jms");
				BytesMessage message = session.createBytesMessage();
				message.setIntProperty("roomNo", roomRequest.getRoomNo());
				message.setStringProperty("roomType", roomRequest.getRoomType());
				message.setIntProperty("guestNo", roomRequest.getGuestNo());
				message.setIntProperty("price", roomRequest.getPrice());
				message.setStringProperty("roomDesc", roomRequest.getRoomDesc());
				
				message.writeBytes(roomRequest.getPicByte());
				System.out.println("message send succesfullt  room servcie");
				return message;
			});

			return "Succesfull";
		} catch (Exception e) {
			return "Upload failed: " + e.getMessage(); // Return error message
		}

	}

}
>>>>>>> 26f4154 (lll)
=======
package com.HotelManagement.service;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Service;

import com.HotelManagement.dto.ImageDetails;
import com.HotelManagement.dto.ImageDetailsForm;
import com.HotelManagement.dto.RoomRequest;
import com.HotelManagement.dto.RoomRequestForm;

@Service
public class sendmessageJms {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String sendmessagetoRoomService(String msg, RoomRequestForm roomRequestForm) {
		try {

			RoomRequest roomRequest = new RoomRequest();
			roomRequest.setGuestNo(roomRequestForm.getGuestNo());
			roomRequest.setPicByte(roomRequestForm.getPicByte().getBytes());
			roomRequest.setPrice(roomRequestForm.getPrice());
			roomRequest.setRoomDesc(roomRequestForm.getRoomDesc());
			roomRequest.setRoomNo(roomRequestForm.getRoomNo());
			roomRequest.setRoomType(roomRequestForm.getRoomType());

			jmsTemplate.send("messagetoroomservice", session -> {

				System.out.println("sendoing message to jms");
				BytesMessage message = session.createBytesMessage();
				message.setIntProperty("roomNo", roomRequest.getRoomNo());
				message.setStringProperty("roomType", roomRequest.getRoomType());
				message.setIntProperty("guestNo", roomRequest.getGuestNo());
				message.setIntProperty("price", roomRequest.getPrice());
				message.setStringProperty("roomDesc", roomRequest.getRoomDesc());
				
				message.writeBytes(roomRequest.getPicByte());
				System.out.println("message send succesfullt  room servcie");
				return message;
			});

			return "Succesfull";
		} catch (Exception e) {
			return "Upload failed: " + e.getMessage(); // Return error message
		}

	}

}
<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
