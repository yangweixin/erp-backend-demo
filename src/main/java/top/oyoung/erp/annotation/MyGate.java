package top.oyoung.erp.annotation;

import top.oyoung.erp.validator.DemoValidator;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DemoValidator.class})
public @interface MyGate {
    String message() default "mygate";
    String regexp();
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
