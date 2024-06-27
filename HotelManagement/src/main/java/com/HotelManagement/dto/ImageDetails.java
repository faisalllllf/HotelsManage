<<<<<<< HEAD
<<<<<<< HEAD
package com.HotelManagement.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImageDetails implements Serializable{
	private String title;
	private byte[] imageFile;
	private String description;

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

=======
package com.HotelManagement.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImageDetails implements Serializable{
	private String title;
	private byte[] imageFile;
	private String description;

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

>>>>>>> 26f4154 (lll)
=======
package com.HotelManagement.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImageDetails implements Serializable{
	private String title;
	private byte[] imageFile;
	private String description;

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

<<<<<<< HEAD
>>>>>>> 8e11644 (First Commit)
=======
>>>>>>> eadf201 (first)
>>>>>>> 26f4154 (lll)
}