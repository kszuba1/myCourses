package io.github.kszuba1.dao;

import io.github.kszuba1.entity.Account;
import io.github.kszuba1.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    Instructor findByAccount(Account account);
}
