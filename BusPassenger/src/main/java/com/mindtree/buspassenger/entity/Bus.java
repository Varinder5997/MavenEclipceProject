package com.mindtree.buspassenger.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	private String busName;
	private int busCapacity;
	private int freeSeats;
	@JsonIgnoreProperties("bus")
	@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
	Set<Passenger>passengers=new HashSet<>();
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getBusCapacity() {
		return busCapacity;
	}
	public void setBusCapacity(int busCapacity) {
		this.busCapacity = busCapacity;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	public Set<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
