package com.example.music.MusicApplication.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.music.MusicApplication.model.Songs;
import com.example.music.MusicApplication.repository.SongsRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "songs")
public class SongsController {
	
	@Autowired
	private SongsRepository repository;
	
	private byte[] bytes;
	
	@GetMapping("/get")
	public List<Songs> getAllSongs() {
		return repository.findAll();
	}
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
		System.out.println("File has been dispatched");
	}
	@PostMapping("/add")
	public void addSong(@RequestBody Songs song) {
		song.setPicByte(this.bytes);
		repository.save(song);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public Songs deleteSong(@PathVariable Long id) {
		Optional<Songs> song = repository.findById(id);
		if(song.isPresent()) {
			repository.deleteById(id);
			System.out.println("Deleted Successfully");
			return song.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/update")
	public void updateSong(@RequestBody Songs song) {
		repository.save(song);
		System.out.println("Updated Successfully");
	}
	
}
