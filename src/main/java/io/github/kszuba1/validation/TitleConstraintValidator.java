package io.github.kszuba1.validation;

import io.github.kszuba1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TitleConstraintValidator implements ConstraintValidator<Title, String> {


    @Autowired
    private CourseService courseService;


    @Override
    public void initialize(Title constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {

        if(courseService.existsByTitle(title)) {
            return false;
        }

        return true;
    }
}
