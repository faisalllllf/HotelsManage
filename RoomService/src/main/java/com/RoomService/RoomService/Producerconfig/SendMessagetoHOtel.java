package com.RoomService.RoomService.Producerconfig;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.RoomService.RoomService.entity.Room;
import com.RoomService.RoomService.entity.RoomRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SendMessagetoHOtel {

	@Autowired
	private JmsTemplate jmsTemplate;

	// send message to jms3
	public void sendRoomThroughJMS(List<RoomRequest> roomRequest) {
		try {
			/*
			 * jmsTemplate.send("roomDetails", session -> {
			 * 
			 * System.out.println("sendoing message to jms"); BytesMessage message =
			 * session.createBytesMessage(); message.setIntProperty("roomNo",
			 * roomRequest.getRoomNo()); message.setStringProperty("roomType",
			 * roomRequest.getRoomType()); message.setIntProperty("guestNo",
			 * roomRequest.getGuestNo()); message.setIntProperty("price",
			 * roomRequest.getPrice()); message.setStringProperty("roomDesc",
			 * roomRequest.getRoomDesc());
			 * 
			 * message.writeBytes(roomRequest.getPicByte());
			 * System.out.println("message send succesfullt  room servcie"); return message;
			 * });
			 */

			ObjectMapper objectMapper = new ObjectMapper();
			String jsonRooms = "";
			try {
				// Serialize rooms list to JSON string
				jsonRooms = objectMapper.writeValueAsString(roomRequest);
				System.out.println("Serialized JSON:");
				System.out.println(jsonRooms);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println("Sendintg room with RoomNo   to JMS queue");
			jmsTemplate.convertAndSend("roomDetails", jsonRooms);
			System.out.println("Sent sucessfull room with RoomNo   to JMS queue");
		} catch (JmsException e) {
			e.printStackTrace();
			System.out.println("Exception occured while sending message to jms room detaisl" + e.getMessage());
			// Handle JMS exception as needed
		}
	}

}
