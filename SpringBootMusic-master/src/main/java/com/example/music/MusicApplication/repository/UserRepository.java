package com.example.music.MusicApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.music.MusicApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
