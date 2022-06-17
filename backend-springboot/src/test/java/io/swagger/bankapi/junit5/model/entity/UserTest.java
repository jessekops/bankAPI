package io.swagger.bankapi.junit5.model.entity;

import io.swagger.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    private User user;

    @BeforeEach
    void setup() {
        user = new User();
    }

    @Test
    void newUserShouldNotBeNull() {
        Assertions.assertNotNull(user);
    }
}
