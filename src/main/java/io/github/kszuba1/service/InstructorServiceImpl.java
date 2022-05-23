package io.github.kszuba1.service;

import io.github.kszuba1.dao.AccountRepository;
import io.github.kszuba1.dao.InstructorRepository;
import io.github.kszuba1.entity.Account;
import io.github.kszuba1.entity.Instructor;
import io.github.kszuba1.entity.dto.InstructorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(InstructorDTO instructorDTO) {

        Instructor instructor = new Instructor();
        Account account = new Account();

        account.setUsername(instructorDTO.getUsername());
        account.setPassword(instructorDTO.getPassword());
        account.setRole("ROLE_INSTRUCTOR");

        accountRepository.save(account);

        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructor.setEmail(instructorDTO.getEmail());
        instructor.setAccount(account);

        System.out.println(instructor);

        instructorRepository.save(instructor);

    }

    @Override
    public Instructor findByAccountUsername(String username) {

        Optional<Account> resultAccount =  accountRepository.findByUsername(username);

        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        }
        else {
            throw new RuntimeException("Did not find account username - " + username);
        }

        return instructorRepository.findByAccount(account);
    }
}
