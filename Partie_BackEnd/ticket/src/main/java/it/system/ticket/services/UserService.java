package it.system.ticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.system.ticket.entities.Ticket;
import it.system.ticket.entities.User;
import it.system.ticket.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    // Get user by id
    public User getUser(Long id) {
        return userRepository.getOne(id);
    }

    // Add user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Get List of User's Tickets
    public List<Ticket> getUserTickets(Long id) {
        return userRepository.getOne(id).getCreatedTicket();
    }

    // Get List of User's Resolved tikets
    public List<Ticket> getUserResolvedTickets(Long id) {
        return userRepository.getOne(id).getResolvedTicket();
    }

    // update User
    public User updateUser(User user, Long id) {
        User updatedUser = this.getUser(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

}