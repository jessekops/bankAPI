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

    @ManyToOne
    private Account from;

    private String to;
    private Double amount;
    private UUID userPerforming;


}
