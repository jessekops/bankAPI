package io.swagger.bankapi.junit5.model.entity;

import io.swagger.model.entity.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void setAmountToPositiveNumberShouldSetThatPrice() {
        Double newAmount = new Random().nextDouble();
        transaction.setAmount(newAmount);
        assertEquals(newAmount, transaction.getAmount());
    }

    @Test
    void setAmountToNegativeShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> transaction.setAmount(-1.0));
    }
}
