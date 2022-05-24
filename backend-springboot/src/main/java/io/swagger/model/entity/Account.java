package io.swagger.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private String iban;

    @ManyToMany(mappedBy = "accounts")
    private List<Transaction> transactions;

}
