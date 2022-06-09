package io.swagger.model.entity;

import lombok.Data;
import lombok.ToString;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate timestamp;

//    private String from;
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Account from;

    public void setFrom(Account from) {
        this.from = from;
    }

    private String to;

    private Double amount;

    private UUID userPerforming;

    private Integer pinCode;


}
