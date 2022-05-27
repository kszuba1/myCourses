package io.github.kszuba1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TitleConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Title {

    String message() default "there is already a course with this title";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
