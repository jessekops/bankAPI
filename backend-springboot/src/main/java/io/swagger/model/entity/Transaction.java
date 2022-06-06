package io.swagger.model.entity;

import lombok.Data;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate timestamp;

    @ManyToOne
    private Account from;

    private String to;
    private Double amount;
    private UUID userPerforming;


}
