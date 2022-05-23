package io.github.kszuba1.service;

import io.github.kszuba1.dao.AccountRepository;
import io.github.kszuba1.dao.StudentRepository;
import io.github.kszuba1.entity.Account;
import io.github.kszuba1.entity.Student;
import io.github.kszuba1.entity.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void saveStudentDto(StudentDTO studentDTO) {

        Student student = new Student();
        Account account = new Account();

        account.setUsername(studentDTO.getUsername());
        account.setPassword(studentDTO.getPassword());
        account.setRole("ROLE_STUDENT");

        accountRepository.save(account);

        student.setNickname(studentDTO.getNickname());
        student.setEmail(studentDTO.getEmail());
        student.setAccount(account);

        System.out.println(student);

        studentRepository.save(student);
    }

    @Override
    public Student findByAccountUsername(String username) {

        Optional<Account> resultAccount =  accountRepository.findByUsername(username);

        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        }
        else {
            throw new RuntimeException("Did not find account username - " + username);
        }

        return studentRepository.findByAccount(account);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}
