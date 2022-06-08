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

    User findUserById(UUID ID);

    User findByUsername(String username);

    User findByEmail(String email);

    // Select all Users who do not have an account
    @Query(value = "SELECT * FROM `USER` WHERE ID NOT IN (SELECT USER_ID FROM ACCOUNT);", nativeQuery = true)
    List<User> findAllWithoutAccount();

}
