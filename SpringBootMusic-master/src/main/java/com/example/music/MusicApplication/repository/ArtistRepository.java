package com.example.music.MusicApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music.MusicApplication.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
