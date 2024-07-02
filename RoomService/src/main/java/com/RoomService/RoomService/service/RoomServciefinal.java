package com.RoomService.RoomService.service;

import java.util.List;

import com.RoomService.RoomService.entity.Room;


public interface RoomServciefinal {


   void findAllRooms();
  List<Room> getAllRooms();
 Room findByRoomNumber(String roomNumber);
 
  void bookRoom(String roomno);
  
}
