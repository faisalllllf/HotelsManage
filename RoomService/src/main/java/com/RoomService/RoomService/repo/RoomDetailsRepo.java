package com.RoomService.RoomService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RoomService.RoomService.entity.Room;

@Repository
public interface RoomDetailsRepo extends JpaRepository<Room, Long> {
	// Room findByName(String email);
	Room findByRoomNumber(String roomNumber);

}
