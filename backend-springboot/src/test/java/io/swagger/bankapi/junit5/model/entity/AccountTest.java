package io.swagger.bankapi.junit5.model.entity;

import io.swagger.model.entity.Account;
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