package com.RoomService.RoomService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RoomService.RoomService.entity.Room;
import com.RoomService.RoomService.repo.RoomDetailsRepo;

@Service
public class RoomServiceFinalImpl  implements RoomServciefinal{

	
	
	public RoomServiceFinalImpl(RoomDetailsRepo rdfr) {
		super();
		this.rdfr = rdfr;
	}

	private RoomDetailsRepo rdfr;
	
	


	@Override
	public List<Room> findAllRooms() {
		
		 List<Room> roomdetailsfinal =new ArrayList<Room>();
		try {
		  roomdetailsfinal = rdfr.findAll();
		  System.out.println("roomdetailsfinal"+roomdetailsfinal);
		}
		catch(Exception e)
		{
			System.out.println("exception occured when retrivieng from db");
		}
		
		return null;
	}

}
