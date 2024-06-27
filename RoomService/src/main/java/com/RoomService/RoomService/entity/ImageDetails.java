package com.RoomService.RoomService.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImageDetails implements Serializable{
	private String title;
	private String description;
	private byte[] imageFile;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ImageDetails [title=" + title + ", imageFile=" + imageFile + ", description=" + description + "]";
	}

}