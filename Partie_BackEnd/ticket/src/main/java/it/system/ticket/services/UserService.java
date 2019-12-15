package it.system.ticket.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.system.ticket.entities.Ticket;
import it.system.ticket.entities.User;
import it.system.ticket.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Get All Users
    public List<User> getUsers() {
        Iterable<User> iterable = userRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    // Get Single User
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    // Add User
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update User
    public User patchUser(User user, Long id) {
        User currentUser = this.getUser(id);
        if (user.getEmail() != null)
            currentUser.setEmail(user.getEmail());
        if (user.getName() != null)
            currentUser.setName(user.getName());
        if (user.getPassword() != null)
            currentUser.setPassword(user.getPassword());
        return userRepository.save(currentUser);
    }

    // Get User Creator Tikets
    public List<Ticket> getUserTickets(Long id) {
        return this.getUser(id).getCreatedTickets();
    }

    // Get User Resolved Tickets
    public List<Ticket> getUserResolvedTickets(Long id) {
        return this.getUser(id).getResolvedTickets();
    }
}
