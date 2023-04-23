package com.tickettrackersystem.TicketTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tickettrackersystem.TicketTracker.model.TicketTracker;
import com.tickettrackersystem.TicketTracker.service.TicketTrackerService;


@Controller
public class TicketController {
	
	private TicketTrackerService ticketService;

	public TicketController(TicketTrackerService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	// handler method to handle list employees and return mode and view
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		System.out.println("in controller...");
		model.addAttribute("tickets", ticketService.getAllTickets());
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {

		// create employee object to hold employee form data
		TicketTracker ticket = new TicketTracker();
		model.addAttribute("ticket", ticket);
		return "create_ticket";

	}
	
	@GetMapping("/tickets/view/{id}")
	public String ViewTicket(@PathVariable Integer id,Model model) {

		model.addAttribute("tickets", ticketService.getTicketById(id));
		return "ticket";

	}

	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") TicketTracker ticket) {

		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editicketForm(@PathVariable Integer id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String editTicket(@PathVariable Integer id, @ModelAttribute("ticket") TicketTracker ticket) {

		// get employee from database by id

		TicketTracker existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setCreatedOn(ticket.getCreatedOn());

		// save updated employee object
		ticketService.editTicket(existingTicket);

//		model.addAttribute("tickets", );
		return "redirect:/tickets";
	}

	// handler method to handle delete employee request

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Integer id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}
	
	@GetMapping("/search")
    public String SearchTickets(Model model, @Param("keyword")  String keyword) {
        List<TicketTracker> listTickets = ticketService.searchTicket(keyword);
        model.addAttribute("tickets", listTickets);
         
        return "tickets";
    }

}
