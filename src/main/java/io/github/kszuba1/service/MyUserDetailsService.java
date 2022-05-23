package io.github.kszuba1.service;

import io.github.kszuba1.dao.AccountRepository;
import io.github.kszuba1.entity.Account;
import io.github.kszuba1.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUsername(username);

        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return account.map(MyUserDetails::new).get();
    }

}
