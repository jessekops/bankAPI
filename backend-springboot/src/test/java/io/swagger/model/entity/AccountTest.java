package io.swagger.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

    @BeforeEach
    void setup() {
        account = new Account();
    }

    @Test
    void newAccountShouldNotBeNull() {
        Assertions.assertNotNull(account);
    }
}