package com.HotelManagement.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.HotelManagement.dto.RoomRequest;
import com.HotelManagement.dto.RoomRequestForm;
import com.HotelManagement.dto.ShowRooms;
import com.HotelManagement.dto.UserDto;
import com.HotelManagement.security.CustomUserDetailsService;
import com.HotelManagement.service.UserService;
import com.HotelManagement.service.sendmessageJms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private sendmessageJms sendmessagejms;

	private ShowRooms roomDetails;

	private List<ShowRooms> showroomlist;

	@GetMapping("/user/home")
	public String userHome(Authentication authentication, Principal principal, Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		session.setAttribute("userName", principal.getName());

		System.out.println("name from auth" + auth.getName());
		System.out.println("principla get anme from princiapl" + principal.getName());
		model.addAttribute("userName", auth.getName());

		return "userHome";
	}

	@GetMapping("/user/SearchRoom")
	public String searchHotel(HttpSession session, Model model) {

		String userName = (String) session.getAttribute("userName");

		System.out.println("userName from seesion in searchRoom Api" + userName);
		model.addAttribute("roomRequest", new RoomRequest());
		return "SearchRooms";
	}

	
	

//	/user/SearchRoom

	@PostMapping("/user/getHotelsDetails")
	public String getHotelsDetails(Model model, HttpSession session, @RequestParam("checkInDate") String checkInDate,
			@RequestParam("checkOutDate") String checkOutDate) {

		String userName = (String) session.getAttribute("userName");

		System.out.println("userName from seesion in searchRoom Api" + userName);

		// connect micro servcie and get deytails

		if (checkInDate != null && checkOutDate != null) {
			// get rooms details by checkin date and cehckout date
			System.out.println("get rooms details by checkin date and cehckout date");

			sendmessagejms.sendRoomRequestDetails(checkInDate, checkOutDate);
			System.out.println("Repsonse from get detaisl sucessfull");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// get details from session
			if (showroomlist != null) {
				// session.getAttribute("roomDetails");
				System.out.println("room detaisl are not empty");
				// RoomRequest roomDetails = (RoomRequest) session.getAttribute("roomDetails");
				model.addAttribute("roomDetails", showroomlist);
			} else {
				System.out.println("room detaisl are empty");
			}
		}
		return "DisplayRooms";
	}

	
	
	
	
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
	 */

	public void process(int roomNo, String roomType, int guestNo, int price, String roomDesc, byte[] image)

	{
		System.out.println("in process method in ProcessImageFromHotel");
		ShowRooms room = new ShowRooms();
		String base64Image = Base64.encodeBase64String(image);
		room.setGuestNo(guestNo);

		room.setPicByte(base64Image);
		room.setPrice(price);
		room.setRoomDesc(roomDesc);
		room.setRoomNo(roomNo);
		room.setRoomType(roomType);

		// Add Base64 string to the model

		try {
			System.out.println("Showing rooms to user");
			// HttpSession session = getCurrentSession();
			// HttpSession session=
			// setting value to roodetails
			// roomDetails = room;
			System.out.println("succesffuly stored  in   room");
		} catch (Exception e) {
			System.out.println("exception while trying store in db" + e.getMessage());
		}
	}

	@JmsListener(destination = "roomDetails")
	public void receiveMessagelist(String message) {
		// Process the received ImageMessage object
		System.out.println("processing message='{}'" + message);
		ObjectMapper objectMapper = new ObjectMapper();
		List<RoomRequest> rromm = new ArrayList<RoomRequest>();
		try {
			rromm = objectMapper.readValue(message, new TypeReference<List<RoomRequest>>() {
			});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in process method in roomdetails");
		showroomlist = new ArrayList<ShowRooms>();
		for (RoomRequest roomRequest : rromm) {
			ShowRooms room = new ShowRooms();
			String base64Image = Base64.encodeBase64String(roomRequest.getPicByte());
			room.setId(roomRequest.getId());
			room.setGuestNo(roomRequest.getGuestNo());

			room.setPicByte(base64Image);
			room.setPrice(roomRequest.getPrice());
			room.setRoomDesc(roomRequest.getRoomDesc());
			room.setRoomNo(roomRequest.getRoomNo());
			room.setRoomType(roomRequest.getRoomType());

			// Add Base64 string to the model

			System.out.println("Showing rooms to user" + room.toString());
			// HttpSession session = getCurrentSession();
			// HttpSession session=
			// setting value to roomdetails
			roomDetails = room;
			showroomlist.add(roomDetails);
			System.out.println("succesffuly stored  in   room");

		}

	}
	
	
	
	
	
	@PostMapping("/user/bookRoom")
	@ResponseBody
    public String bookRoom(@RequestBody String roomNumber) {
        // Process the roomNumber (e.g., save to database)
		System.out.println("Processing to book  room no: " + roomNumber);
		
		sendmessagejms.sendBookRoom(roomNumber);
		
		
		
		
        System.out.println("Book Room Request send to book room for roomnumber " + roomNumber);
        
        
        
        // Return a response (if needed)
        return "Booking successful";
    }
}