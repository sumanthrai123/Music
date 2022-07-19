package com.example.music.MusicApplication.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Songs")
public class Songs {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dateofrelease")
	private String dateOfRelease;
	
	@Column(name = "name")
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDateOfRelease() {
		return dateOfRelease;
	}
	

	public void setDateOfRelease(String dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}


	public byte[] getPicByte() {
		return picByte;
	}


	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}


	@Override
	public String toString() {
		return "Songs [id=" + id + ", dateOfRelease=" + dateOfRelease + ", picByte=" + Arrays.toString(picByte) + "]";
	}


	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
}
