package com.RoomService.RoomService.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "room_Number")
	private int roomNo;

	@Column(name = "room_Type")
	private String roomType;

	@Column(name = "NO_Of_Guests")
	private int GuestNo;

	@Column(name = "room_Price")
	private int price;
	@Column(name = "room_Description")
	private String roomDesc;

	@Column(name = "picByte", length = 1000)
	@Lob
	private byte[] picByte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getGuestNo() {
		return GuestNo;
	}

	public void setGuestNo(int guestNo) {
		GuestNo = guestNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", GuestNo=" + GuestNo + ", price="
				+ price + ", roomDesc=" + roomDesc + ", picByte=" + Arrays.toString(picByte) + "]";
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(Long id, int roomNo, String roomType, int guestNo, int price, String roomDesc, byte[] picByte) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		GuestNo = guestNo;
		this.price = price;
		this.roomDesc = roomDesc;
		this.picByte = picByte;
	}

}
