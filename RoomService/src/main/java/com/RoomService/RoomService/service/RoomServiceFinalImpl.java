package com.RoomService.RoomService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoomService.RoomService.Producerconfig.SendMessagetoHOtel;
import com.RoomService.RoomService.entity.Room;
import com.RoomService.RoomService.entity.RoomRequest;
import com.RoomService.RoomService.repo.RoomDetailsRepo;

@Service
public class RoomServiceFinalImpl implements RoomServciefinal {

	@Autowired
	private SendMessagetoHOtel sendMessagetoHOtel;

	public RoomServiceFinalImpl(RoomDetailsRepo rdfr) {
		super();
		this.rdfr = rdfr;
	}

	private RoomDetailsRepo rdfr;

	@Override
	public void findAllRooms() {

		List<Room> roomdetailsfinal = new ArrayList<Room>();
		List<RoomRequest> roomDTOs = new ArrayList<>();
		// get in db

		roomdetailsfinal = getAllRooms();
		if (roomdetailsfinal != null) {
			for (Room room : roomdetailsfinal) {

				RoomRequest rr = new RoomRequest();
				rr.setId(room.getId());
				rr.setGuestNo(room.getGuestNo());
				rr.setPicByte(room.getPicByte());
				rr.setPrice(room.getPrice());
				rr.setRoomDesc(room.getRoomDesc());
				rr.setRoomNo(room.getRoomNo());
				rr.setRoomType(room.getRoomType());
				roomDTOs.add(rr);
				// sendMessagetoHOtel.sendRoomThroughJMS(rr);
				System.out.println("pricessing room message inservice");
			}
			System.out.println("Sending room deatils");
			sendMessagetoHOtel.sendRoomThroughJMS(roomDTOs);
			for(RoomRequest rr:roomDTOs) {
			System.out.println("roomDTOs" + rr);
			}
		} else {
			System.out.println("response from getall erooms is null");
		}

	}

	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		List<Room> roomdetailsfinal = new ArrayList<Room>();
		try {
			roomdetailsfinal = rdfr.findAll();
		} catch (Exception e) {
			System.out.println("exception occured when retrivieng from db");
		}
		return roomdetailsfinal;

	}

	@Override
	public void bookRoom(String roomNo) {
		// TODO Auto-generated method stub
		findByRoomNumber(roomNo);
		
	}

	@Override
	public Room findByRoomNumber(String roomNumber) {
		// TODO Auto-generated method stub
		return rdfr.findByRoomNumber(roomNumber);
	}



}
