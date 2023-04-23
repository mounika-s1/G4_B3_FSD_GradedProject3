package com.tickettrackersystem.TicketTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tickettrackersystem.TicketTracker.model.TicketTracker;
import com.tickettrackersystem.TicketTracker.repository.TicketTrackerRepositoty;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService{
	private TicketTrackerRepositoty tickerRepository;

	public TicketTrackerServiceImpl(TicketTrackerRepositoty tickerRepository) {
		this.tickerRepository = tickerRepository;
	}
	
	@Override
	public List<TicketTracker> getAllTickets() {
		return (List<TicketTracker>) tickerRepository.findAll();
	}

//	public List<TicketTracker> getAllTickets() {
//		
//		List<TicketTracker> templist = new ArrayList<TicketTracker>();
//		
//		templist.add((TicketTracker) tickerRepository.findAll());
//		
//		return (List<TicketTracker>) tickerRepository.findAll();
//		
//	}

	public TicketTracker saveTicket(TicketTracker ticket) {
		return tickerRepository.save(ticket);
	}

	public TicketTracker getTicketById(Integer id) {
		return tickerRepository.findById(id).get();
	}

	public TicketTracker editTicket(TicketTracker ticket) {
		return tickerRepository.save(ticket);
	}

	public void deleteTicketById(Integer id) {
		tickerRepository.deleteById(id);
	}

	public List<TicketTracker> searchTicket(String keyword){
		return tickerRepository.searchTicket(keyword);
	}
}
