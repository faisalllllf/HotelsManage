package com.RoomService.RoomService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RoomService.RoomService.entity.Room;

import com.RoomService.RoomService.entity.RoomRequest;
import com.RoomService.RoomService.service.RoomServciefinal;


@RestController
public class RoomservcieController {


	
	@Autowired
	private RoomServciefinal roomServiceFinal;
	
    @GetMapping("/getAllRooms")
    public  ResponseEntity<List<Room>> getAllRooms()
    {

    	List<Room> responsefromdb = roomServiceFinal.findAllRooms();
    	System.out.println("responsefromdb"+responsefromdb.toString());
        return ResponseEntity.ok(responsefromdb);
    }
    
    @PostMapping("/AddRooms")
    public  ResponseEntity<List<Room>> AddRooms(@RequestBody RoomRequest room)
    {
        
    	List<Room> responsefromdb = roomServiceFinal.findAllRooms();
    	System.out.println("responsefromdb"+responsefromdb.toString());
        return ResponseEntity.ok(responsefromdb);
    }

}
