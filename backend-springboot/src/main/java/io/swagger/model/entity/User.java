package io.swagger.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class User {

    //This is a dummy class, think about your code!
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
