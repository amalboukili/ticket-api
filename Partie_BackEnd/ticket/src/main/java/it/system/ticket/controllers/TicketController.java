package it.system.ticket.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.system.ticket.entities.Ticket;
import it.system.ticket.services.TicketService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // get all tickets
    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getAll();
    }

    // get ticket
    @GetMapping("/ticket/{id}")
    public Ticket getTicket(@PathVariable("id") Long id) {
        return ticketService.getTicket(id);
    }

    // create tikcet
    @PostMapping("/ticket")
    public Ticket addTicket(@Valid @RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    // update ticket
    @PatchMapping(value = "ticket/{id}")
    public Ticket patchTicket(@PathVariable("id") Long id, @RequestBody Ticket ticket) {
        log.info(ticket.toString());
        return ticketService.patchTicket(id, ticket);
    }

    // delete ticket
    @DeleteMapping("ticket/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<String>("Deleted", HttpStatus.ACCEPTED);
    }
}
