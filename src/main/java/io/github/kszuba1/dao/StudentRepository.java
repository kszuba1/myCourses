package io.github.kszuba1.dao;


import io.github.kszuba1.entity.Account;
import io.github.kszuba1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByAccount(Account account);

    boolean existsByNickname(String nickname);

}
