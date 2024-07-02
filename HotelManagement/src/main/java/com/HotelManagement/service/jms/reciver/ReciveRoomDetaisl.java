package com.HotelManagement.service.jms.reciver;

import java.util.concurrent.CountDownLatch;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.servlet.http.HttpSession;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.HotelManagement.dto.RoomRequest;


@Component
public class ReciveRoomDetaisl {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	/*
	 * @JmsListener(destination = "messagetoroomservice") public void receive(String
	 * message) { System.out.println("received message='{}'"+ message);
	 * latch.countDown(); }
	 */

	/*
	 * @JmsListener(destination = "roomDetails") public void
	 * receiveMessage(BytesMessage message) { // Process the received ImageMessage
	 * object System.out.println("processing message='{}'" + message); //
	 * processImage(message);
	 * 
	 * try { int roomNo = message.getIntProperty("roomNo"); String roomType =
	 * message.getStringProperty("roomType");
	 * 
	 * int guestNo = message.getIntProperty("guestNo"); int price =
	 * message.getIntProperty("price");
	 * 
	 * String roomDesc = message.getStringProperty("roomDesc");
	 * 
	 * byte[] imageData = new byte[(int) message.getBodyLength()];
	 * message.readBytes(imageData);
	 * 
	 * // Process the received image data (e.g., save to file, process, etc.)
	 * System.out.println( "Received Image: " + roomNo + ", Description: " +
	 * roomType + ", Size: " + imageData.length);
	 * 
	 * // Example: Save image to file // saveImageToFile(title, description,
	 * imageData); System.out.println("saving in db calling servcie layer");
	 * process(roomNo, roomType, guestNo, price, roomDesc, imageData); } catch
	 * (JMSException e) { throw new
	 * RuntimeException("Failed to process image message", e); } }
	 * 
	 * public void process(int roomNo, String roomType,int guestNo,int price,String
	 * roomDesc,byte[] image)
	 * 
	 * { System.out.println("in process method in ProcessImageFromHotel");
	 * RoomRequest room = new RoomRequest(); room.setGuestNo(guestNo);
	 * 
	 * room.setPicByte(image); room.setPrice(price); room.setRoomDesc(roomDesc);
	 * room.setRoomNo(roomNo); room.setRoomType(roomType); try {
	 * System.out.println("Showing rooms to user"); // HttpSession session =
	 * getCurrentSession(); // HttpSession session=
	 * 
	 * System.out.println("succesffuly stored  in   session"); } catch (Exception e)
	 * { System.out.println("exception while trying store in db" + e.getMessage());
	 * } }
	 * 
	 */
}
