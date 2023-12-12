package com.example.bankingapplicationspringboot.repository;

import com.example.bankingapplicationspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    Boolean existsByEmail(String email);

}
