package it.system.ticket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.system.ticket.entities.Ticket;
import it.system.ticket.repositories.TicketRepository;

@Service
public class TicketService {
    @Autowired
    public TicketRepository ticketRepository;

    // Get Ticket
    public Ticket getTicket(Long id) {
        return ticketRepository.getOne(id);
    }

    // Add Ticket
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

}