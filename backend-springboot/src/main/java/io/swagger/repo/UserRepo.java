package io.swagger.repo;

import io.swagger.model.entity.User;
import io.swagger.model.enumeration.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    User findByUsername(String username);

    User findByEmail(String email);

//    @Modifying
//    @Query(value = "UPDATE USER_USER_TYPES ut set ut.USER_TYPES = ? where ut.USER_ID = ?",
//            nativeQuery = true)
//    void updateUserTypes(List<UserType> types, UUID userId);

//    @Modifying
//    @Query(value = "UPDATE USER u set u.USERNAME = ?, u.PASSWORD = ?, u.FIRSTNAME = ?, u.LASTNAME = ?, u.DOB = ?, u.ADDRESS = ?, u.EMAIL = ?, u.PHONE = ?, u.REGISTERED_ON = ?, u.DAY_LIMIT = ?, u.TRANS_LIMIT = ?, u.ACTIVE = ? WHERE u.USER_ID = ?",
//            nativeQuery = true)
//    User updateUser(String username, String password, String firstname, String lastname, LocalDate dob, String address, String email, String phone, OffsetDateTime registeredOn, Double dayLimit, Double transLimit, Boolean active, UUID id);
}
