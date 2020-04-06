package com.mindtree.buspassenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.buspassenger.entity.Passenger;
import com.mindtree.buspassenger.repository.PassengerRepo;

@Service
public class PassengerServiceImpl implements PassengerService {
	@Autowired
	PassengerRepo passengerRepo;

	@Override
	public String addPesenger(Passenger passenger) {
		this.passengerRepo.save(passenger);
		return null;
	}

	@Override
	public List<Passenger> allPassengers() {
		return this.passengerRepo.findAll();
	}

}
