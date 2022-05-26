package io.github.kszuba1.validation;

import io.github.kszuba1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NicknameConstraintValidator implements ConstraintValidator<Nickname, String> {


    @Autowired
    private StudentService studentService;


    @Override
    public void initialize(Nickname constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nickname, ConstraintValidatorContext constraintValidatorContext) {

        if(studentService.existsByNickname(nickname)) {
            return false;
        }

        return true;
    }
}
