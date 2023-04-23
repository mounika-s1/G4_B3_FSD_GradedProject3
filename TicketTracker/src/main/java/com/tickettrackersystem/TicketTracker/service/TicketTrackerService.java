package com.tickettrackersystem.TicketTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tickettrackersystem.TicketTracker.model.TicketTracker;

@Service
public interface TicketTrackerService {
	
	List<TicketTracker> getAllTickets();

	TicketTracker saveTicket(TicketTracker ticket);
	
	TicketTracker getTicketById(Integer id);

	TicketTracker editTicket(TicketTracker ticket);

	void deleteTicketById(Integer id);
	
	List<TicketTracker> searchTicket(String keyword);
}
