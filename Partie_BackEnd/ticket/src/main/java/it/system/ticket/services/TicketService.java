package it.system.ticket.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.system.ticket.entities.Ticket;
import it.system.ticket.entities.User;
import it.system.ticket.repositories.TicketRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserService userService;

    // Get All Tickets
    public List<Ticket> getAll() {
        log.info("Getting all tickets from the db");
        Iterable<Ticket> iterable = ticketRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    // Get Single Ticket
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ticket not found"));
    }

    // Add Ticket
    public Ticket addTicket(Ticket ticket) {
        User creator = userService.getUser(ticket.getCreator().getId());
        User affectTo = userService.getUser(ticket.getAffectTo().getId());
        ticket.setAffectTo(affectTo);
        ticket.setCreator(creator);
        return ticketRepository.save(ticket);
    }

    // delete Ticket
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    // Update Ticket
    public Ticket patchTicket(Long id, Ticket ticket) {
        Ticket currentTicket = this.getTicket(id);
        // check if we have a description field then update it
        if (ticket.getDescription() != null)
            currentTicket.setDescription(ticket.getDescription());
        // samething for comment field
        if (ticket.getComment() != null)
            currentTicket.setComment(ticket.getComment());
        // isResolved field
        if (ticket.getIsResolved() != null)
            currentTicket.setIsResolved(ticket.getIsResolved());
        // update the affected to user
        if (ticket.getAffectTo() != null) {
            User affectTo = userService.getUser(ticket.getAffectTo().getId());
            currentTicket.setAffectTo(affectTo);
        }
        // in all case update the priority
        currentTicket.setPriority(ticket.getPriority());
        return ticketRepository.save(currentTicket);
    }
}