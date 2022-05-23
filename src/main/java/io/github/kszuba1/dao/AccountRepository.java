package io.github.kszuba1.dao;

import io.github.kszuba1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {

    Optional<Account> findByUsername(String username);

}
