package io.github.kszuba1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {

    String message() default "login is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
