package io.swagger.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private UUID iban;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "from")
    private List<Transaction> transactions;



}
