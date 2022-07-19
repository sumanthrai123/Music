package com.example.music.MusicApplication.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.music.MusicApplication.model.Artist;
import com.example.music.MusicApplication.repository.ArtistRepository;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "artist")
public class ArtistController {
	
	@Autowired
	private ArtistRepository repository;
	
	@GetMapping("/get")
	public List<Artist> getAllArtists() {
		System.out.println("Getting all Artist");
		return repository.findAll();
	}
	
	@PostMapping("/add")
	public void createArtist(@RequestBody Artist artist) {
		repository.save(artist);
		System.out.println("Saved Successfully");
	}
	@DeleteMapping(path = { "/{id}" })
	public Artist deleteArtist(@PathVariable("id") long id) {
		Optional<Artist> artist = repository.findById(id);
		if(artist.isPresent()) {
			repository.deleteById(id);
			System.out.println("Deleted Successfully");
			return artist.get();
		}
		else {
			return null;
		}	
	}
	@PutMapping("/update")
	public void updateArtist(@RequestBody Artist artist) {
		repository.save(artist);
		System.out.println("Updated Successfully");
	}
}
