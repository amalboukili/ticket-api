package it.system.ticket.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @Email
    @NotEmpty
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
    private List<Ticket> createdTicket;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "affectTo")
    private List<Ticket> resolvedTicket;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}