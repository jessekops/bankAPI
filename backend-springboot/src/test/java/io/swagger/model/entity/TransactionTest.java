package io.swagger.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TransactionTest {

    private Transaction transaction;

    @BeforeEach
    void Setup() {
        transaction = new Transaction();
    }

    @Test
    void newTransactionShouldNotBeNull() {
        Assertions.assertNotNull(transaction);
    }
}
