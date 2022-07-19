package com.example.music.MusicApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music.MusicApplication.model.Songs;

public interface SongsRepository extends JpaRepository<Songs, Long>{

}
