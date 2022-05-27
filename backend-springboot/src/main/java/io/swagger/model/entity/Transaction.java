package io.swagger.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import java.util.List;
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

    @ManyToMany
    private List<Account> accounts;

}
