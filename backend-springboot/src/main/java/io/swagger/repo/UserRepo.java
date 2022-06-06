package io.swagger.repo;

import io.swagger.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    // AddUser (uses .save() in UserService)

    // UpdateUser (uses .save() in UserService)

    User findUserById(UUID ID);

    User findByUsername(String username);

    User findByEmail(String email);

}
