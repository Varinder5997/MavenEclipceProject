package com.mindtree.buspassenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.buspassenger.entity.Passenger;
@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

	Passenger findBypassengerName(String name);

}
