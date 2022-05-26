package io.github.kszuba1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NicknameConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface Nickname {

    String message() default "nickname is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
