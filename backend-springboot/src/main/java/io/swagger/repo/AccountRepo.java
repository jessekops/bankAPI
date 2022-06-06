package io.swagger.repo;

import io.swagger.model.entity.Account;
import io.swagger.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepo extends JpaRepository<Account, UUID> {
    Account findAccountByUserId(UUID userid);

    Account findAccountByIban(String iban);

    List<Account> findAllByUser(User user);
}
