package com.example.bankapplication.repository;

import com.example.bankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
