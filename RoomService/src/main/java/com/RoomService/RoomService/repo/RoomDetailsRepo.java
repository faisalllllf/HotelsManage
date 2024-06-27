package com.RoomService.RoomService.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.RoomService.RoomService.entity.Room;


public interface RoomDetailsRepo extends JpaRepository<Room, Long> {
   // Room findByName(String email);
}
