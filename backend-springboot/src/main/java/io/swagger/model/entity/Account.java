package io.swagger.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private String iban;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;



}
