package io.swagger.model.entity;

import io.swagger.model.enumeration.AccountType;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Account {

    @Id
    private String iban;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<AccountType> accountTypes;

    private Double balance;
    private Double absLimit;
    private Boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "from")
    private List<Transaction> transactions;



}
