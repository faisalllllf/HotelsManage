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
			roomRequest.setId(roomRequestForm.getId());
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

	public void sendRoomRequestDetails(String checkInDate, String checkoutDate) {
		try {

			jmsTemplate.send("sendRoomRequestDetails", session -> {

				System.out.println("sendoing message to jms");
				BytesMessage message = session.createBytesMessage();

				message.setStringProperty("checkInDate", checkInDate);

				message.setStringProperty("checkoutDate", checkoutDate);

				System.out.println("message send succesfullt  room servcie");
				return message;
			});

		} catch (Exception e) {
			System.out.println("Upload failed: " + e.getMessage()); // Return error message
		}

	}

	public void sendBookRoom(String roomNo) {
		try {

			jmsTemplate.send("sendBookRoomRequest", session -> {

				System.out.println("sending message to jms");
				BytesMessage message = session.createBytesMessage();

				message.setStringProperty("roomNo", roomNo);

				System.out.println("message Request Book room send  succesfull  room servcie for room Booking");
				return message;
			});

		} catch (Exception e) {
			System.out.println("Upload failed: " + e.getMessage()); // Return error message
		}

	}

}
