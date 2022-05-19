package io.swagger.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private String iban;


}
