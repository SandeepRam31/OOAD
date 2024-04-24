package com.lms.demo.data.repository;

import com.lms.demo.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByAddressAndPassword(String address, String password);
}
