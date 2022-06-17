package io.swagger.model.entity;

import io.swagger.model.enumeration.AccountType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Account {

    @Id
    private String iban;
    private Integer pinCode;

    private AccountType accountType;

    private Double balance;
    private Double absLimit;
    private Boolean active;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    public void setActive(Boolean active) {
        this.active = Objects.requireNonNullElse(active, true);
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "from")
    private List<Transaction> transactions;





}
