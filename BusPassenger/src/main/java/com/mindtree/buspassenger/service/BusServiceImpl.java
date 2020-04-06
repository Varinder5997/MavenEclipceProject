package com.mindtree.buspassenger.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.buspassenger.entity.Bus;
import com.mindtree.buspassenger.entity.Passenger;
import com.mindtree.buspassenger.exception.service.AlreadyBookBus;
import com.mindtree.buspassenger.exception.service.NoSeatAvailable;
import com.mindtree.buspassenger.exception.service.ServiceException;
import com.mindtree.buspassenger.exception.service.TicketNotBook;
import com.mindtree.buspassenger.repository.BusRepo;
import com.mindtree.buspassenger.repository.PassengerRepo;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	BusRepo busRepo;
	@Autowired
	PassengerRepo pussengerRepo;

	@Override
	public String addBus(Bus bus) {
		this.busRepo.save(bus);
		return "Bus is added succesfull";
	}

	@Override
	public List<Bus> allBusses() {
		return this.busRepo.findAll();
	}

	@Override
	public List<Passenger> allPassengersOfBus(int busId) {
		Set<Passenger> all = this.busRepo.findById(busId).get().getPassengers();
		List<Passenger> allsorted = new ArrayList<Passenger>(all);
		Collections.sort(allsorted);
		return allsorted;
	}

	@Override
	public String board(int busId, int passengerId) throws ServiceException {
		Bus bus = this.busRepo.findById(busId).get();
		Passenger passenger = this.pussengerRepo.findById(passengerId).get();
		if (passenger.getBus() == null) {
			if (bus.getFreeSeats() <= 0) {
				throw new NoSeatAvailable("Bus is Full");
			} else {
				bus.setFreeSeats(bus.getFreeSeats() - 1);
				bus.getPassengers().add(passenger);
				passenger.setBus(bus);
				this.busRepo.save(bus);
			}
		} else {
			throw new AlreadyBookBus("Person already book a bus");
		}
		return "Passenger is Boarded";
	}

	@Override
	public String deBoard(String name) throws ServiceException {
		Passenger passenger = this.pussengerRepo.findBypassengerName(name);
		Bus bus = passenger.getBus();
		if (bus == null) {
			throw new TicketNotBook("Pasenger not book Any bus");
		} else {
			passenger.setBus(null);
			this.pussengerRepo.save(passenger);
			bus.setFreeSeats(bus.getFreeSeats() + 1);
			bus.getPassengers().remove(passenger);
			this.busRepo.save(bus);
		}
		return "Passenger is debord Succesfull";
	}

}
