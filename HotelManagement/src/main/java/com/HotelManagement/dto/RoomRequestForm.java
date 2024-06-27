<<<<<<< HEAD

package com.HotelManagement.dto;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class RoomRequestForm implements Serializable {

	private Long id;

	private int roomNo;

	private String roomType;

	private int guestNo;

	private int price;

	private String roomDesc;

	private MultipartFile picByte;

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
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		guestNo = guestNo;
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

	public MultipartFile getPicByte() {
		return picByte;
	}

	public void setPicByte(MultipartFile picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "RoomRequest [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", GuestNo=" + guestNo
				+ ", price=" + price + ", roomDesc=" + roomDesc + ", picByte=" + picByte + "]";
	}

	public RoomRequestForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomRequestForm(Long id, int roomNo, String roomType, int guestNo, int price, String roomDesc,
			MultipartFile picByte) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.guestNo = guestNo;
		this.price = price;
		this.roomDesc = roomDesc;
		this.picByte = picByte;
	}

}
=======

package com.HotelManagement.dto;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class RoomRequestForm implements Serializable {

	private Long id;

	private int roomNo;

	private String roomType;

	private int guestNo;

	private int price;

	private String roomDesc;

	private MultipartFile picByte;

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
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		guestNo = guestNo;
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

	public MultipartFile getPicByte() {
		return picByte;
	}

	public void setPicByte(MultipartFile picByte) {
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "RoomRequest [id=" + id + ", roomNo=" + roomNo + ", roomType=" + roomType + ", GuestNo=" + guestNo
				+ ", price=" + price + ", roomDesc=" + roomDesc + ", picByte=" + picByte + "]";
	}

	public RoomRequestForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomRequestForm(Long id, int roomNo, String roomType, int guestNo, int price, String roomDesc,
			MultipartFile picByte) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.guestNo = guestNo;
		this.price = price;
		this.roomDesc = roomDesc;
		this.picByte = picByte;
	}

}
>>>>>>> 8e11644 (First Commit)
