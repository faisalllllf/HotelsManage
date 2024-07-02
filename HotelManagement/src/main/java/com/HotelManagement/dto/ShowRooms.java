
package com.HotelManagement.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ShowRooms implements Serializable {

	private Long id;

	private int roomNo;

	private String roomType;

	private int GuestNo;

	private int price;

	private String roomDesc;

	private String picByte;

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

	public String getPicByte() {
		return picByte;
	}

	public void setPicByte(String picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "RoomRequest [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", GuestNo=" + GuestNo
				+ ", price=" + price + ", roomDesc=" + roomDesc + ", picByte=" + picByte + "]";
	}

	public ShowRooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowRooms(Long id, int roomNo, String roomType, int guestNo, int price, String roomDesc, String picByte) {
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
