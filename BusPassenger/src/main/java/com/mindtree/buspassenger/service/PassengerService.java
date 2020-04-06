package com.mindtree.buspassenger.service;

import java.util.List;

import com.mindtree.buspassenger.entity.Passenger;

public interface PassengerService {
	String addPesenger(Passenger passenger);
	List<Passenger> allPassengers();

}
