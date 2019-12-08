package it.system.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.system.ticket.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}