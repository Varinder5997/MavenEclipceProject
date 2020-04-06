package com.mindtree.buspassenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.buspassenger.entity.Passenger;
import com.mindtree.buspassenger.service.PassengerService;

@RestController
public class PassengerController {
	
	@Autowired
	PassengerService service;
	
	@PostMapping("/passenger")
	public String addpassenger(Passenger passenger) {
		return this.service.addPesenger(passenger);
		
	}
	
	@GetMapping("/passenger")
	public List<Passenger> allPassenger(){
		return this.service.allPassengers();
	}
	
}
