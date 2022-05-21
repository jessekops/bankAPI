package io.swagger.model.entity;

import io.swagger.model.enumeration.UserType;
import lombok.Data;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private UserType userType;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;
    private OffsetDateTime registeredOn;
    private Double dayLimit;
    private Double transLimit;
    private Boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;
}
