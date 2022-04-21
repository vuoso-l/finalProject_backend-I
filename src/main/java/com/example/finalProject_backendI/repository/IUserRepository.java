package com.example.finalProject_backendI.repository;

import com.example.finalProject_backendI.entity.login.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    //esto lo armé diferente al video...puede romper
    //@Query("select u from User u where u.email like %:email%")
    Optional<User> findOneUserByEmail(String email);
}
