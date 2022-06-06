package io.swagger.repo;

import io.swagger.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, UUID> {

    Transaction findTransactionById(UUID id);
    List<Transaction> findAllByTimestamp(LocalDate timeStamp);
}
