package com.tickettrackersystem.TicketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tickettrackersystem.TicketTracker.model.TicketTracker;

public interface TicketTrackerRepositoty extends JpaRepository<TicketTracker, Integer>  {
	
	@Query(value = "SELECT * FROM tickets t WHERE t.title like %:keyword% or t.description1 LIKE %:keyword%", nativeQuery = true)
	public List<TicketTracker> searchTicket(@Param("keyword") String keyword);

}
