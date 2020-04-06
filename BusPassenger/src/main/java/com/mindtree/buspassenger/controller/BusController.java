package com.mindtree.buspassenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.buspassenger.entity.Bus;
import com.mindtree.buspassenger.entity.Passenger;
import com.mindtree.buspassenger.exception.ApplicationException;
import com.mindtree.buspassenger.service.BusService;

@RestController
public class BusController {
	@Autowired
	BusService service;
	
	@PostMapping("/bus")
	public String addBus(Bus bus) {
		return this.service.addBus(bus);
	}
	
	@GetMapping("/bus")
	public List<Bus> allBusses(){
		return this.service.allBusses();
	}
	
	@GetMapping("/bus-passengers/{busId}")
	public List<Passenger> busPasengers(@PathVariable int busId){
		return this.service.allPassengersOfBus(busId);
		
	}
	
	@PutMapping("/bording")
	public String bording(@RequestParam int busId, @RequestParam int passengerId) throws ApplicationException {
		return this.service.board(busId, passengerId);
	}
	
	@PutMapping("/debording")
	public String deBording(@RequestParam String name) throws ApplicationException {
		return this.service.deBoard(name);
	}
	
}
