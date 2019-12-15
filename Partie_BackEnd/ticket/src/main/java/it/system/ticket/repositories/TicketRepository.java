package it.system.ticket.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import it.system.ticket.entities.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

}