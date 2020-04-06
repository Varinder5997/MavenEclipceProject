package com.mindtree.buspassenger.service;

import java.util.List;

import com.mindtree.buspassenger.entity.Bus;
import com.mindtree.buspassenger.entity.Passenger;
import com.mindtree.buspassenger.exception.service.ServiceException;

public interface BusService {
	String addBus(Bus bus);
	List<Bus> allBusses();
	List<Passenger> allPassengersOfBus(int busId);
	String board(int busId,int passengerId) throws ServiceException;
	String deBoard(String name) throws ServiceException;

}
