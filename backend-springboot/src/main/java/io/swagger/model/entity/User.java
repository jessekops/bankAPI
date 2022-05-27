package io.swagger.model.entity;
import io.swagger.model.enumeration.UserType;
import lombok.Data;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    //Makes sure a User can have multiple UserTypes and fills in a users UserType automatically when getting from the DB
    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserType> userTypes;

    private String username;
    private String password;
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;


}
