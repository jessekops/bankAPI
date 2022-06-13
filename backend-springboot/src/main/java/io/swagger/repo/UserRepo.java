package io.swagger.repo;

import io.swagger.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    // AddUser (uses .save() in UserService)

    // UpdateUser (uses .save() in UserService)

    User findUserById(UUID id);

    User findByUsername(String username);

    User findByEmail(String email);

    User findByPhone(String phone);

    // Select all Users who do not have an account via JPQL
    @Query(value = "SELECT u FROM User u WHERE NOT EXISTS (SELECT a FROM u.accounts a)")
    List<User> findAllWithoutAccount();

}
