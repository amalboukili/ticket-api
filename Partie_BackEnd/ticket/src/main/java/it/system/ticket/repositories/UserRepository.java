package it.system.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.system.ticket.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}