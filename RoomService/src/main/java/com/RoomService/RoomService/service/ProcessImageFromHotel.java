package com.RoomService.RoomService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoomService.RoomService.entity.Room;
import com.RoomService.RoomService.repo.RoomDetailsRepo;

@Service
public class ProcessImageFromHotel {

	@Autowired
	private RoomDetailsRepo roomDetailsRepo;

	public void process(int roomNo, String roomType,int guestNo,int  price,String  roomDesc,byte[] image)

	{
		System.out.println("in process method in ProcessImageFromHotel");
		Room room = new Room();
		room.setGuestNo(guestNo);

		room.setPicByte(image);
		room.setPrice(price);
		room.setRoomDesc(roomDesc);
		room.setRoomNo(roomNo);
		room.setRoomType(roomType);
		try {
			System.out.println("calling  db");
			roomDetailsRepo.save(room);
			System.out.println("succesffuly stired in   db");
		} catch (Exception e) {
			System.out.println("exception while trying store in db" + e.getMessage());
		}
	}

}
