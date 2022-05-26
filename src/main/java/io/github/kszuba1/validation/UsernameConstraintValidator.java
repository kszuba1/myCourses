package io.github.kszuba1.validation;

import io.github.kszuba1.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameConstraintValidator implements ConstraintValidator<Username, String> {


    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void initialize(Username constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

        if(accountRepository.existsByUsername(username)) {
            return false;
        }

        return true;
    }
}
