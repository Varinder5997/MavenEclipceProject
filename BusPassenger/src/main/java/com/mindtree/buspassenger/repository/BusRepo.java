package com.mindtree.buspassenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.buspassenger.entity.Bus;
@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

}
