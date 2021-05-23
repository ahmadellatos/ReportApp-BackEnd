package com.reportapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reportapp.entity.UserData;
import com.reportapp.repository.UserDataRepository;

@RestController
@RequestMapping("/")
public class UserDataController {

	@Autowired
	UserDataRepository userDataRepo;
	
	@GetMapping("/userdata")
	public List<UserData> getUserData() {
		return (List<UserData>) userDataRepo.findAll();
	}
	
	@PostMapping("/register")
	public String addUserData(@RequestBody UserData userData) {
		userDataRepo.save(userData);
		return "Insert Berhasil";
	}
}
