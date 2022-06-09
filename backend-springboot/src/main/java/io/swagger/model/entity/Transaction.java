package io.swagger.model.entity;

import lombok.Data;
import lombok.ToString;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

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

    private String to;

    private Double amount;

    private UUID userPerforming;

    private Integer pinCode;


}
