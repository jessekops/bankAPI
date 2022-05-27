package io.swagger.model.entity;

import lombok.Data;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    private OffsetDateTime timestamp;
    private String from;
    private String to;
    private Double amount;
    private UUID userPerforming;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

}
