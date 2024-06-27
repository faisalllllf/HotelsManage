package com.RoomService.RoomService.Zconfig;

import java.util.concurrent.CountDownLatch;

import javax.jms.BytesMessage;
import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.RoomService.RoomService.entity.ImageDetails;
import com.RoomService.RoomService.service.ProcessImageFromHotel;

@Component
public class JmsReceiver {

	@Autowired
	private ProcessImageFromHotel processImageFromHotel;

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	/*
	 * @JmsListener(destination = "messagetoroomservice") public void receive(String
	 * message) { System.out.println("received message='{}'"+ message);
	 * latch.countDown(); }
	 */

	@JmsListener(destination = "messagetoroomservice")
	public void receiveMessage(BytesMessage message) {
		// Process the received ImageMessage object
		System.out.println("processing message='{}'" + message);
		// processImage(message);

		try {
			int roomNo = message.getIntProperty("roomNo");
			String roomType = message.getStringProperty("roomType");

			int guestNo = message.getIntProperty("guestNo");
			int price = message.getIntProperty("price");

			String roomDesc = message.getStringProperty("roomDesc");

			byte[] imageData = new byte[(int) message.getBodyLength()];
			message.readBytes(imageData);

			// Process the received image data (e.g., save to file, process, etc.)
			System.out.println(
					"Received Image: " + roomNo + ", Description: " + roomType + ", Size: " + imageData.length);

			// Example: Save image to file
			// saveImageToFile(title, description, imageData);
			System.out.println("saving in db calling servcie layer");
			processImageFromHotel.process(roomNo, roomType, guestNo, price, roomDesc, imageData);
		} catch (JMSException e) {
			throw new RuntimeException("Failed to process image message", e);
		}
	}

	private void processImage(ImageDetails imageMessage) {
		// Example processing logic: Print image details
		System.out.println(
				"Received Image: " + imageMessage.getTitle() + ", Size: " + imageMessage.getImageFile().length);

		// Example: Save image to file
		// saveImageToFile(imageMessage);
	}
}
